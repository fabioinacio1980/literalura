package br.com.fabionacio.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Integer dataNascimento;
    private Integer dataMorte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livro;

    public Autor(){}

    public Autor(DadosAutor dadosAutor){
        this.nome = dadosAutor.nome();
        this.dataNascimento = dadosAutor.dataNascimento();
        this.dataMorte = dadosAutor.dataMorte();
    }

    @Override
    public String toString() {
        StringBuilder livrosStr = new StringBuilder();
        livrosStr.append("Livros: ");

        for(int i = 0; i < livro.size() ; i++) {
            livrosStr.append(livro.get(i).getTitulo());
            if (i < livro.size() - 1 ){
                livrosStr.append(", ");
            }
        }
        return String.format("********** Autor **********%nNome:" +
                " %s%n%s%nData de Nascimento: %s%nData da Morte:" +
                " %s%n***************************%n", nome,livrosStr.toString(), dataNascimento, dataMorte);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Integer dataMorte) {
        this.dataMorte = dataMorte;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }
}
