package br.com.fabionacio.literalura.controller;

import br.com.fabionacio.literalura.dto.EpisodioDTO;
import br.com.fabionacio.literalura.dto.SerieDTO;
import br.com.fabionacio.literalura.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
//
//    @Autowired
//    private SerieService serieService;
//
//
//    @GetMapping()
//    public List<SerieDTO> obterSerie() {
//        return serieService.obterTodasSeries();
//    }
//
//    @GetMapping("/top5")
//    public List<SerieDTO> obterTop5Serie() {
//        return serieService.obterTop5Series();
//    }
//
//    @GetMapping("/lancamentos")
//    public List<SerieDTO> obterLancamentos() {
//        return serieService.obterLancamentos();
//    }
//
//    @GetMapping("/{id}")
//    public SerieDTO obterPorId(@PathVariable Long id) {
//        return serieService.obterPorId(id);
//    }
//
//    @GetMapping("/{id}/temporadas/todas")
//    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id) {
//        return serieService.obterTodasTemporadas(id);
//    }
//
//    @GetMapping("/{id}/temporadas/{numero}")
//    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero) {
//        return serieService.obterTemporadasPorNumero(id, numero);
//    }
//
//    @GetMapping("/categoria/{categoria}")
//    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String categoria) {
//        return serieService.obterSeriePorCategoria(categoria);
//    }
//
//    @GetMapping("/{id}/temporadas/top")
//    public List<EpisodioDTO> obterTopEpisodios(@PathVariable Long id){
//        return serieService.obterTopEpisodios(id);
//    }

}
