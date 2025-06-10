package br.com.fabionacio.literalura.repository;

import br.com.fabionacio.literalura.model.Idioma;
import br.com.fabionacio.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ILivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(Idioma idioma);

    Optional<Livro> findByTitulo(String titulo);

    @Query("SELECT l FROM Livro l ORDER BY l.numeroDownloads DESC LIMIT 10")
    List<Livro> top10LivrosMaisBaixados();
}
