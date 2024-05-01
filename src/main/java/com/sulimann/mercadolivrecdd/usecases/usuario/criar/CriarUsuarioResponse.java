package com.sulimann.mercadolivrecdd.usecases.usuario.criar;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.mercadolivrecdd.models.Usuario;

import lombok.Getter;

@Getter
public class CriarUsuarioResponse {

  private Long id;
  private String email;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime dataCriacao;

  public CriarUsuarioResponse(Usuario usuario) {
    this.id = usuario.getId();
    this.email = usuario.getEmail();
    this.dataCriacao = usuario.getDataCriacao();
  }

}
