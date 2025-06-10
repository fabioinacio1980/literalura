package br.com.fabionacio.literalura.repository;

import br.com.fabionacio.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);

    @Query("SELECT a FROM Autor a WHERE a.dataNascimento <= :anio AND a.dataMorte >= :anio")
    List<Autor> listaAutoresVivosPorAno(Integer ano);
}
