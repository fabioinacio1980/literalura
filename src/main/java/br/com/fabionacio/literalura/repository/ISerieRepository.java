package br.com.fabionacio.literalura.repository;


import br.com.fabionacio.literalura.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISerieRepository extends JpaRepository<Serie, Long> {
//
//    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
//
//    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, String avaliacao);
//
//    List<Serie> findTop5ByOrderByAvaliacaoDesc();
//
//    List<Serie> findByGenero(Categoria categoria);
//
//    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, String avaliacao);
//
//    // não utilizar nativeQuery, pois ficamos presos, acomplados a classe
//    //    @Query(value = "select * from series where series.total_temporadas <= 5 and series.avaliacao >= 7.5", nativeQuery = true)
//    //    List<Serie> seriePorTemporadaEAvaliacao();
//
//    //USAR JPQL
//    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporada AND s.avaliacao >= :avaliacao")
//    List<Serie> seriePorTemporadaEAvaliacao(@Param("totalTemporada") int totalTemporada, @Param("avaliacao") String avaliacao);
//
//    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:titulo%")
//    List<Episodio> seriePorTrechoEpisodio(String titulo);
//
//    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s= :serie ORDER BY e.avaliacao DESC LIMIT 5")
//    List<Episodio> topEpisodiosPorSerie(Serie serie);
//
//    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s= :serie AND YEAR (e.dataLancamento) >= :dataLancamento ORDER BY e.avaliacao DESC LIMIT 5")
//    List<Episodio> buscarEpisodiosPorData(Serie serie, int dataLancamento);
//
//    @Query("SELECT s FROM Serie s " +
//            "JOIN s.episodios e " +
//            "GROUP BY s " +
//            "ORDER BY MAX(e.dataLancamento) DESC LIMIT 5")
//    List<Serie> lancamentosMaisRecentes();
//
//    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s.id = :id AND e.temporada = :numero")
//    List<Episodio> obterEpisodiosPorTemporada(Long id, Long numero);
}
