package br.com.fabionacio.literalura.service;

import br.com.fabionacio.literalura.dto.EpisodioDTO;
import br.com.fabionacio.literalura.dto.SerieDTO;
import br.com.fabionacio.literalura.model.Categoria;
import br.com.fabionacio.literalura.model.Serie;
import br.com.fabionacio.literalura.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

//    @Autowired
//    private ISerieRepository repository;
//
//    public List<SerieDTO> obterTodasSeries() {
//        return converteDados(repository.findAll());
//    }
//
//    public List<SerieDTO> obterTop5Series() {
//        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
//
//    }
//
//    public List<SerieDTO> obterLancamentos() {
//        return converteDados(repository.lancamentosMaisRecentes());
//
//    }
//
//    public SerieDTO obterPorId(Long id) {
//        Optional<Serie> serie = repository.findById(id);
//        if (serie.isPresent()) {
//            Serie s = serie.get();
//            return new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse());
//        }
//        return null;
//    }
//
//    private List<SerieDTO> converteDados(List<Serie> serie) {
//        return
//                serie
//                        .stream()
//                        .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
//                        .collect(Collectors.toList());
//    }
//
//
//    public List<EpisodioDTO> obterTodasTemporadas(Long id) {
//        Optional<Serie> serie = repository.findById(id);
//        if (serie.isPresent()) {
//            Serie s = serie.get();
//            return s.getEpisodios().stream()
//                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
//                    .collect(Collectors.toList());
//        }
//        return null;
//    }
//
//
//    public List<EpisodioDTO> obterTemporadasPorNumero(Long id, Long numero) {
//        return repository.obterEpisodiosPorTemporada(id, numero).stream()
//                .map(e -> new EpisodioDTO(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
//                .collect(Collectors.toList());
//    }
//
//    public List<SerieDTO> obterSeriePorCategoria(String categoria) {
//        Categoria categoriaSerie = Categoria.fromPortugues(categoria);
//        return converteDados(repository.findByGenero(categoriaSerie));
//    }
//
//    public List<EpisodioDTO> obterTopEpisodios(Long id) {
//        var serie = repository.findById(id).get();
//        return repository.topEpisodiosPorSerie(serie)
//                .stream()
//                .map(e -> new EpisodioDTO(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
//                .collect(Collectors.toList());
//    }
}
