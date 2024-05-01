package com.sulimann.mercadolivrecdd.usecases.categoria.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.mercadolivrecdd.models.Categoria;
import com.sulimann.mercadolivrecdd.repositories.CategoriaRepository;
import com.sulimann.mercadolivrecdd.utils.constants.Path;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = Path.CATEGORIA)
@RequiredArgsConstructor
@Log4j2
public class CriarCategoriaController {

  private final CategoriaRepository repository;

  @PostMapping
  public ResponseEntity<CriarCategoriaResponse> criarCategoria(@RequestBody @Valid CriarCategoriaRequest request){
    log.debug("Post recebido para criar uma nova categoria, {}", request);
    Categoria categoria = request.toModel(repository);
    log.debug("Salvando {} no banco de dados", categoria);
    this.repository.save(categoria);
    log.info("{} salva no banco de dados", categoria);
    return ResponseEntity.status(HttpStatus.CREATED).body(new CriarCategoriaResponse(categoria));
  }

}
