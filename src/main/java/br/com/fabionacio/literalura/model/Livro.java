package br.com.fabionacio.literalura.model;


import jakarta.persistence.*;


@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer numeroDownloads;

    public Livro(){}

    public Livro(DadosLivros dadosLivros){
        this.titulo = dadosLivros.titulo();
        this.idioma = Idioma.fromString(dadosLivros.idiomas().toString().split(",")[0].trim());
        this.numeroDownloads = dadosLivros.numeroDownloads();
    }

    @Override
    public String toString() {
        String nomeAutor = (autor != null) ? autor.getNome() : "Autor desconhecido";
        return String.format("********** Livro **********%nTitulo:" +
                " %s%nAutor: %s%nIdioma: %s%nNumero de Downloads:" +
                " %d%n***************************%n",titulo,nomeAutor, idioma, numeroDownloads);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }
}
