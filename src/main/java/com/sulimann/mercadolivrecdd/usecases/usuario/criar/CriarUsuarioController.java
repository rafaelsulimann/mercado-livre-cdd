package com.sulimann.mercadolivrecdd.usecases.usuario.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.mercadolivrecdd.models.Usuario;
import com.sulimann.mercadolivrecdd.repositories.UsuarioRepository;
import com.sulimann.mercadolivrecdd.utils.constants.Path;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = Path.USUARIO)
@RequiredArgsConstructor
@Log4j2
public class CriarUsuarioController {

    private final UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<CriarUsuarioResponse> criarUsuario(@RequestBody @Valid CriarUsuarioRequest request) {
        log.debug("Post recebido para criar um novo usuario, {}", request);
        Usuario usuario = request.toModel();
        log.debug("Salvando {} no banco de dados", usuario);
        this.repository.save(usuario);
        log.info("{} salvo no banco de dados", usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CriarUsuarioResponse(usuario));
    }

}
