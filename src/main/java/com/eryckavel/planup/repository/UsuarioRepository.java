package com.eryckavel.planup.repository;

import com.eryckavel.planup.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = """
    SELECT * FROM usuario WHERE email=:email
    """, nativeQuery = true)
    Optional<Usuario> buscarPorEmail(String email);

}
