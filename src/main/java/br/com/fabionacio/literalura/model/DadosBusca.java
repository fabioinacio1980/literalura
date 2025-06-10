package br.com.fabionacio.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBusca(

        @JsonAlias("count") Integer conta,
        @JsonAlias("results") List<DadosLivros> resultado
) {
}
