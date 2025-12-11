package com.eryckavel.planup.repository;

import com.eryckavel.planup.dto.response.query.RelacaoMontanteResponseQueryDTO;
import com.eryckavel.planup.model.Montante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MontanteRepository extends JpaRepository<Montante, Long> {

    @Query(value = """
    SELECT * FROM montante WHERE id_usuario=:idUsuario
    """, nativeQuery = true)
    Optional<Montante> buscarPorUsuario(Long idUsuario);

    @Query(value = """
    SELECT
        COALESCE(sum(mo.saldo)) AS saldo,
        COALESCE(SUM(me.valor_estimado)) AS total_estimado,
        COALESCE(SUM(me.valor_gasto)) AS total_gasto
    FROM montante mo
    JOIN meta me ON me.id_usuario=:idUsuario
    WHERE mo.id_usuario=:idUsuario
    """, nativeQuery = true)
    RelacaoMontanteResponseQueryDTO consultarRelacaoMontante(Long idUsuario);

}
