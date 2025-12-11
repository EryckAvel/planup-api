package com.eryckavel.planup.repository;

import com.eryckavel.planup.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepositoy extends JpaRepository<Meta, Long> {

    @Query(value = """
    SELECT * FROM meta m WHERE m.id_usuario=:idUsuario;
    """, nativeQuery = true)
    List<Meta> listar(Long idUsuario);

}
