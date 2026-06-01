package cl.SalmonesAustral.Cosecha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import cl.SalmonesAustral.Cosecha.modelo.Cosecha;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface CosechaRepository extends JpaRepository<Cosecha, Long> {

    // 🔹 Búsqueda simple (la mantenemos)
    List<Cosecha> findByJaulaId(int jaulaId);

    // 1. Cosechas con peso mayor a X
    @Query("SELECT c FROM Cosecha c WHERE c.pesoTotal > :peso")
    List<Cosecha> buscarPorPesoMayor(@Param("peso") double peso);

    //2. Cosechas en rango de fechas
    @Query("SELECT c FROM Cosecha c WHERE c.fecha BETWEEN :inicio AND :fin")
    List<Cosecha> buscarPorRangoFechas(
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    //3. Cosechas por estado
    @Query("SELECT c FROM Cosecha c WHERE c.estado = :estado")
    List<Cosecha> buscarPorEstado(@Param("estado") String estado);

    //4. Cosechas por jaula + estado
    @Query("SELECT c FROM Cosecha c WHERE c.jaulaId = :jaulaId AND c.estado = :estado")
    List<Cosecha> buscarPorJaulaYEstado(
            @Param("jaulaId") int jaulaId,
            @Param("estado") String estado
    );

    //5. Cosechas rechazadas (consulta útil de negocio)
    @Query("SELECT c FROM Cosecha c WHERE c.estado = 'RECHAZADA'")
    List<Cosecha> obtenerRechazadas();

    //6. Promedio de peso por jaula (nivel PRO)
    @Query("SELECT AVG(c.pesoPromedio) FROM Cosecha c WHERE c.jaulaId = :jaulaId")
    Double promedioPesoPorJaula(@Param("jaulaId") int jaulaId);
}