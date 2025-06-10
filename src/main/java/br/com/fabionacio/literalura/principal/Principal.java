package br.com.fabionacio.literalura.principal;

import br.com.fabionacio.literalura.model.*;
import br.com.fabionacio.literalura.repository.ISerieRepository;
import br.com.fabionacio.literalura.service.ConsumoApi;
import br.com.fabionacio.literalura.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private List<DadosSerie> dadosSeries = new ArrayList<DadosSerie>();

    private Optional<Serie> serieBuscada;

    private ISerieRepository repositorio;

    private List<Serie> series = new ArrayList<>();

    public Principal(ISerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                 1 - Buscar Livro pelo título
                 2 - Listar Livros registrados
                 3 - Listar Autores registrados
                 4 - Listar Autores vivos em um determinado ano
                 5 - Listar Livros em um determinado idioma
                 0 - Sair
                 """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("1 - Buscar Livro pelo título");
                    //buscarSerieWeb();
                    break;
                case 2:
                    System.out.println("2 - Listar Livros registrados");
                    //buscarEpisodioPorSerie();
                    break;
                case 3:
                    System.out.println("3 - Listar Autores registrados");
                    //listarSeriesBuscadas();
                    break;
                case 4:
                    System.out.println("4 - Listar Autores vivos em um determinado ano");
                    //buscarSeriePorTitulo();
                    break;
                case 5:
                    System.out.println("5 - Listar Livros em um determinado idioma");
                    //buscarSeriesPorAtor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
//
//    private void buscarEpisodiosPorData() {
//        buscarSeriePorTitulo();
//        if(serieBuscada.isPresent()){
//            System.out.println("Digite o ano máximo de lançamento: ");
//            var anoMaximo = leitura.nextInt();
//            leitura.nextLine();
//            Serie serie = serieBuscada.get();
//            List<Episodio> episodios = repositorio.buscarEpisodiosPorData(serie, anoMaximo);
//            episodios.forEach(s ->
//                    System.out.printf("Série: %s Temporada %s - Episódio %s - %s - Avaliação %s\n",
//                            s.getSerie().getTitulo(), s.getTemporada(),
//                            s.getNumeroEpisodio(), s.getTitulo(),
//                            s.getAvaliacao()));
//        }
//    }
//
//    private void topEpisodiosPorSerie() {
//        buscarSeriePorTitulo();
//        if(serieBuscada.isPresent()){
//            Serie serie = serieBuscada.get();
//            List<Episodio> episodios = repositorio.topEpisodiosPorSerie(serie);
//            episodios.forEach(s ->
//                    System.out.printf("Série: %s Temporada %s - Episódio %s - %s - Avaliação %s\n",
//                            s.getSerie().getTitulo(), s.getTemporada(),
//                            s.getNumeroEpisodio(), s.getTitulo(),
//                            s.getAvaliacao()));
//        }
//    }
//
//    private void filtrarSeriePorTechoEpisodio() {
//        System.out.println("Informe o trecho do episódio ");
//        var trechoEpisodio = leitura.nextLine();
//        List<Episodio> episodiosEncontrados = repositorio.seriePorTrechoEpisodio(trechoEpisodio);
//        System.out.println("*** Séries filtradas ***");
//        episodiosEncontrados.forEach(s ->
//                System.out.printf("Série: %s Temporada %s - Episódio %s - %s - Avaliação %s\n",
//                        s.getSerie().getTitulo(), s.getTemporada(),
//                        s.getNumeroEpisodio(), s.getTitulo(),
//                        s.getAvaliacao()));
//    }
//
//    private void filtrarSeriesPorTemporadaEAvaliacao() {
//        System.out.println("Filtrar séries até quantas temporadas? ");
//        var totalTemporadas = leitura.nextInt();
//        leitura.nextLine();
//        System.out.println("Com avaliação a partir de que valor? ");
//        var avaliacao = leitura.nextDouble();
//        leitura.nextLine();
//        List<Serie> filtroSeries = repositorio.seriePorTemporadaEAvaliacao(totalTemporadas, String.valueOf(avaliacao));
//        System.out.println("*** Séries filtradas ***");
//        filtroSeries.forEach(s ->
//                System.out.println(s.getTitulo() + "  - avaliação: " + s.getAvaliacao()));
//}
//
//    private void buscarSeriesPorCategoria() {
//        System.out.println("Deseja buscar séries de que categoria/gênero? ");
//        var nomeGenero = leitura.nextLine();
//        Categoria categoria = Categoria.fromPortugues(nomeGenero);
//        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
//        System.out.println("Séries da categoria " + nomeGenero);
//        seriesPorCategoria.forEach(System.out::println);
//    }
//
//    private void buscarTop5Series() {
//        List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
//        serieTop.forEach(s ->
//                System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
//    }
//
//    private void buscarSeriesPorAtor() {
//        System.out.println("Qual o nome para busca?");
//        var nomeAtor = leitura.nextLine();
//        System.out.println("Avaliações a partir de que valor? ");
//        var avaliacao = leitura.nextDouble();
//        List<Serie> seriesEncontradas = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, String.valueOf(avaliacao));
//        System.out.println("Séries em que " + nomeAtor + " trabalhou: ");
//        seriesEncontradas.forEach(s ->
//                System.out.println(s.getTitulo() + " avaliação: " + s.getAvaliacao()));
//    }
//
//    private void buscarSeriePorTitulo() {
//        System.out.println("Escolha um série pelo nome: ");
//        var nomeSerie = leitura.nextLine();
//        serieBuscada = repositorio.findByTituloContainingIgnoreCase(nomeSerie);
//
//        if (serieBuscada.isPresent()) {
//            System.out.println("Dados da série: " + serieBuscada.get());
//
//        } else {
//            System.out.println("Série não encontrada!");
//        }
//    }
//
//    private void buscarSerieWeb() {
//        DadosSerie dados = getDadosSerie();
//        Serie serie = new Serie(dados);
//        //dadosSeries.add(dados);
//        repositorio.save(serie);
//        System.out.println(dados);
//    }
//
//    private DadosSerie getDadosSerie() {
//        System.out.println("Digite o nome da série para busca");
//        var nomeSerie = leitura.nextLine();
//        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//        return dados;
//    }
//
//    private void buscarEpisodioPorSerie(){
//        //DadosSerie dadosSerie = getDadosSerie();
//        listarSeriesBuscadas();
//        System.out.println("Escolha uma série pelo nome:");
//        String serie = leitura.nextLine();
//
//        Optional<Serie> first = repositorio.findByTituloContainingIgnoreCase(serie);
//
//        if(first.isPresent()) {
//            var serieEncontrado = first.get();
//            List<DadosTemporada> temporadas = new ArrayList<>();
//            for (int i = 1; i <= serieEncontrado.getTotalTemporadas(); i++) {
//                var json = consumo.obterDados(ENDERECO + serieEncontrado.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
//                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//                temporadas.add(dadosTemporada);
//            }
//            temporadas.forEach(System.out::println);
//            List<Episodio> episodios = temporadas.stream()
//                    .flatMap(d -> d.episodios().stream()
//                            .map(e -> new Episodio(d.numero(), e)))
//                    .collect(Collectors.toList());
//            serieEncontrado.setEpisodios(episodios);
//            repositorio.save(serieEncontrado);
//
//        }
//        else{
//            System.out.println("Série não encontrada!");
//        }
//    }
//    private void listarSeriesBuscadas(){
//        this.series = repositorio.findAll();
//        series.stream()
//                .sorted(Comparator.comparing(Serie::getGenero))
//                .forEach(System.out::println);
//    }
}