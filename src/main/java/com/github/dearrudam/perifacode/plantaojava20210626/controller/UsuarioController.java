package com.github.dearrudam.perifacode.plantaojava20210626.controller;

import com.github.dearrudam.perifacode.plantaojava20210626.model.Usuario;
import com.github.dearrudam.perifacode.plantaojava20210626.repository.UsuarioRepository;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(
        final UsuarioRepository usuarioRepository
    ) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<?> adicionar(
        @RequestBody
        @Valid Usuario usuario
    ) {
        if (usuario.getId() != null) {
            return ResponseEntity.badRequest()
                .body("deve ser um usuário sem id");
        }
        if (usuarioRepository
            .existsByEmailAndCpf(usuario.getEmail(), usuario.getCpf())) {
            return ResponseEntity.badRequest()
                .body("usuário já cadastrado com o email e cpf informado");
        }
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }
}
