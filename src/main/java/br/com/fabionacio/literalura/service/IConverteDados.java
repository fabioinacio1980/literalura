package br.com.fabionacio.literalura.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
