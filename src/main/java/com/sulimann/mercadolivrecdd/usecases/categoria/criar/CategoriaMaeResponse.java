package com.sulimann.mercadolivrecdd.usecases.categoria.criar;

import com.sulimann.mercadolivrecdd.models.Categoria;

import lombok.Getter;

@Getter
public class CategoriaMaeResponse {

  private Long id;
  private String nome;

  public CategoriaMaeResponse(Categoria categoriaMae) {
    this.id = categoriaMae.getId();
    this.nome = categoriaMae.getNome();
  }

}
