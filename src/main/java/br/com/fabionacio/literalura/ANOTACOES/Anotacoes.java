package br.com.fabionacio.literalura.ANOTACOES;

public class Anotacoes {
    /*
    Escolha o número de sua opção:
    1 - Buscar Livro pelo título
    2 - Listar Livros registrados
    3 - Listar Autores registrados
    4 - Listar Autores vivos em um determinado ano
    5 - Listar Livros em um determinado idioma
    0 - Sair
     */

    //Somente para a opção 1 vamos utilizar a API, os demais itens somente o BD

    /*
    1 - Buscar Livro pelo título
    ***forma de entrada do título:***
    -------- Livro --------
    Título:
    Autor:
    Idioma:
    Número de downloads:
    -----------------------
     */

    /*
    2 - Listar Livros registrados
    -------- Livro --------
    Título:
    Autor:
    Idioma:
    Número de downloads:
    -----------------------
     */

    /*
    3 - Listar Autores registrados
    -------- Autores --------
    Autor:
    Ano de Nascimento:
    Ano de Falecimento:
    Livros: [nome dos livros]
    -------------------------
     */

    /*
    4 - Listar Autores vivos em um determinado ano
    -------- Autores --------
    Autor:
    Ano de Nascimento:
    Ano de Falecimento:
    Livros: [nome dos livros]
    -------------------------
     */

    /*
    5 - Listar Livros em um determinado idioma
    Insira o Idioma para realizar a busca:
    1 - es - Espanhol
    2 - en - Inglês
    3 - fr - Francês
    4 - pt - Português

    depois de selecionado, deverá apresentar o livro nesse formato:
    -------- Livro --------
    Título:
    Autor:
    Idioma:
    Número de downloads:
    -----------------------

    caso não exista o livro, deverá apresentar uma mensagem:
    Não existem livros nesse idioma no Banco de Dados!
     */

    /*
    A API = https://gutendex.com/books?
    a forma de procura será:
    search=dom%20casmurro - onde %20 representa o espaço entre as palavras
    author_year_end=-499 - fornece livros com autores vivos antes de 500 a.C.
    author_year_start=1800&author_year_end=1899 - fornece livros com autores vivos no século XIX
    languages=fr,fi - representa livros em francês, finlandês ou ambos
    topic=children - retorna livros na estante "Literatura Infantil"

    Objetos de API
    Os tipos de objetos JSON servidos pelo Gutendex são fornecidos abaixo.

    Livro
    {
      "id": <number of Project Gutenberg ID>,
      "title": <string>,
      "subjects": <array of strings>,
      "authors": <array of Persons>,
      "summaries": <array of strings>,
      "translators": <array of Persons>,
      "bookshelves": <array of strings>,
      "languages": <array of strings>,
      "copyright": <boolean or null>,
      "media_type": <string>,
      "formats": <Format>,
      "download_count": <number>
    }
    Formatar
    {
      <string of MIME-type>: <string of URL>,
      ...
    }
    Pessoa
    {
      "birth_year": <number or null>,
      "death_year": <number or null>,
      "name": <string>
    }

     */
}
