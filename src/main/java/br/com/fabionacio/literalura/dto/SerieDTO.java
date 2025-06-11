package br.com.fabionacio.literalura.dto;


import br.com.fabionacio.literalura.model.Categoria;

public record SerieDTO (
        Long id,
        String titulo,
        Integer totalTemporadas,
        String avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse) {

}
