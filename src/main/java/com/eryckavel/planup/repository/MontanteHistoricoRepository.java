package com.eryckavel.planup.repository;

import com.eryckavel.planup.dto.response.query.MontanteHistoricoResponseQueryDTO;
import com.eryckavel.planup.model.MontanteHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MontanteHistoricoRepository extends JpaRepository<MontanteHistorico, Long> {

    @Query(value = """
    SELECT mh.tipo_movimento, mh.valor_diferenca, mh.data_criacao FROM montante_historico mh
    JOIN montante mo ON mo.id_montante = mh.id_montante
    WHERE mo.id_usuario=:idUsuario
    """, nativeQuery = true)
    List<MontanteHistoricoResponseQueryDTO> listarMontanteHistorico(Long idUsuario);

}
