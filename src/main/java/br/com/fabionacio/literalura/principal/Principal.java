package br.com.fabionacio.literalura.principal;

import br.com.fabionacio.literalura.model.*;
import br.com.fabionacio.literalura.repository.IAutorRepository;
import br.com.fabionacio.literalura.repository.ILivroRepository;
import br.com.fabionacio.literalura.service.ConsumoApi;
import br.com.fabionacio.literalura.service.ConverteDados;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConverteDados conversor = new ConverteDados();
    private ILivroRepository livroRepository;
    private IAutorRepository autorRepository;
    private List<Autor> autores;
    private List<Livro> livros;

    public Principal(ILivroRepository livroRepository, IAutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            System.out.println("*********************************\n");
            var menu = """
                    1 - Buscar livros pelo Título
                    2 - Listar livros Registrados
                    3 - Mostrar Autores Registrados
                    4 - Autores vivos em determinado ano
                    5 - Buscar livro por idioma
                    6 - Top 10 livros mais baixados
                    7 - Livro mais Baixado e Livro Menos Baixado
                    
                    0 - Sair
                    
                    """;


            System.out.println(menu);
            while (!teclado.hasNextInt()) {
                System.out.println("Número inválido, insira um número disponível no menu!");
                teclado.nextLine();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarLivros();
                    break;
                case 2:
                    mostrarLivros();
                    break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    autoresVivosPorAno();
                    break;
                case 5:
                    buscarLivroPorIdioma();
                    break;
                case 6:
                    top10LivrosMaisBaixados();
                    break;
                case 7:
                    rankingDeLivros();
                    break;
                case 0:
                    System.out.println("Finalizando o sistema");
                    break;
                default:
                    System.out.printf("Opção inválida\n");
            }
        }
    }

    private DadosBusca getBusca() {
        System.out.println("Insira o nome do livro: ");
        var nomeDoLivro = teclado.nextLine();
        var json = consumoApi.obterDados(URL_BASE + nomeDoLivro.replace(" ", "%20"));
        DadosBusca dados = conversor.obterDados(json, DadosBusca.class);
        return dados;

    }

    private void buscarLivros() {
        DadosBusca dadosBuscados = getBusca();
        if (dadosBuscados != null && !dadosBuscados.resultado().isEmpty()) {
            DadosLivros imprimirLivro = dadosBuscados.resultado().get(0);


            Livro livro = new Livro(imprimirLivro);
            System.out.println("***** Livro *****");
            System.out.println(livro);
            System.out.println("*****************");

            Optional<Livro> livroExiste = livroRepository.findByTitulo(livro.getTitulo());
            if (livroExiste.isPresent()) {
                System.out.println("\nEste livro já está registrado\n");
            } else {

                if (!imprimirLivro.autor().isEmpty()) {
                    DadosAutor autor = imprimirLivro.autor().get(0);
                    Autor autor1 = new Autor(autor);
                    Optional<Autor> autorOptional = autorRepository.findByNome(autor1.getNome());

                    if (autorOptional.isPresent()) {
                        Autor autorExiste = autorOptional.get();
                        livro.setAutor(autorExiste);
                        livroRepository.save(livro);
                    } else {
                        Autor autorNovo = autorRepository.save(autor1);
                        livro.setAutor(autorNovo);
                        livroRepository.save(livro);
                    }

                    Integer numeroDescargas = livro.getNumeroDownloads() != null ? livro.getNumeroDownloads() : 0;
                    System.out.println("********** Livro **********");
                    System.out.printf("Titulo: %s%nAutor: %s%nIdioma: %s%nNumero de Downloads: %s%n",
                            livro.getTitulo(), autor1.getNome(), livro.getIdioma(), livro.getNumeroDownloads());
                    System.out.println("***************************\n");
                } else {
                    System.out.println("Sem autor");
                }
            }
        } else {
            System.out.println("Livro não encontrado");
        }
    }

    private void mostrarLivros() {
        livros = livroRepository.findAll();
        livros.stream()
                .forEach(System.out::println);
    }

    private void mostrarAutores() {
        autores = autorRepository.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    private void autoresVivosPorAno() {
        System.out.println("Insira o ano do autor que deseja procurar: ");
        var ano = teclado.nextInt();
        autores = autorRepository.listaAutoresVivosPorAno(ano);
        autores.stream()
                .forEach(System.out::println);
    }

    private List<Livro> dadosBuscaIdioma(String idioma) {
        var dados = Idioma.fromString(idioma);
        System.out.println("Idioma buscado: " + dados);

        List<Livro> livroPorIdioma = livroRepository.findByIdioma(dados);
        return livroPorIdioma;
    }

    private void buscarLivroPorIdioma() {
        System.out.println("Selecione a lingua/idioma que deseja buscar: ");

        var opcao = -1;
        while (opcao != 0) {
            var opciones = """
                    1. en - Inglês
                    2. es - Espanhol
                    3. fr - Francês
                    4. pt - Português
                    
                    0. Retornar as opções anteriores
                    """;
            System.out.println(opciones);
            while (!teclado.hasNextInt()) {
                System.out.println("Número inválido, insira um número disponível no menu!");
                teclado.nextLine();
            }
            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1:
                    List<Livro> livrosEmIngles = dadosBuscaIdioma("[en]");
                    livrosEmIngles.forEach(System.out::println);
                    break;
                case 2:
                    List<Livro> livrosEmEspanhol = dadosBuscaIdioma("[es]");
                    livrosEmEspanhol.forEach(System.out::println);
                    break;
                case 3:
                    List<Livro> livrosEmFrances = dadosBuscaIdioma("[fr]");
                    livrosEmFrances.forEach(System.out::println);
                    break;
                case 4:
                    List<Livro> livrosEmPortugues = dadosBuscaIdioma("[pt]");
                    livrosEmPortugues.forEach(System.out::println);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ningún idioma seleccionado");
            }
        }
    }

    private void top10LivrosMaisBaixados() {
        List<Livro> topLibros = livroRepository.top10LivrosMaisBaixados();
        topLibros.forEach(System.out::println);
    }

    private void rankingDeLivros() {
        livros = livroRepository.findAll();
        IntSummaryStatistics est = livros.stream()
                .filter(l -> l.getNumeroDownloads() > 0)
                .collect(Collectors.summarizingInt(Livro::getNumeroDownloads));

        Livro livroMaisBaixado = livros.stream()
                .filter(l -> l.getNumeroDownloads() == est.getMax())
                .findFirst()
                .orElse(null);

        Livro livroMenosBaixado = livros.stream()
                .filter(l -> l.getNumeroDownloads() == est.getMin())
                .findFirst()
                .orElse(null);
        System.out.println("******************************************************");
        System.out.printf("%nLivro mais Baixado: %s%nNúmero de descargas: " +
                        "%d%n%nLivro menos Baixado: %s%nNúmero de descargas: " +
                        "%d%n%n", livroMaisBaixado.getTitulo(), est.getMax(),
                livroMenosBaixado.getTitulo(), est.getMin());
        System.out.println("******************************************************");
    }

}