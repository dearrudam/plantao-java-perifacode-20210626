package com.github.dearrudam.perifacode.plantaojava20210626.repository;

import com.github.dearrudam.perifacode.plantaojava20210626.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmailAndCpf(String email, String cpf);
}
