package com.sulimann.mercadolivrecdd.usecases.categoria.criar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sulimann.mercadolivrecdd.models.Categoria;

import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class CriarCategoriaResponse {

  private Long id;
  private String nome;
  private CategoriaMaeResponse categoriaMae;

  public CriarCategoriaResponse(Categoria categoria) {
    this.id = categoria.getId();
    this.nome = categoria.getNome();
    this.categoriaMae = categoria.getCategoriaMae() != null ? new CategoriaMaeResponse(categoria.getCategoriaMae()) : null;
  }

}
