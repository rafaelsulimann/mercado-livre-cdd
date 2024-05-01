package com.sulimann.mercadolivrecdd.models;

import com.sulimann.mercadolivrecdd.utils.constants.TableName;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.CATEGORIA)
@Getter
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @ManyToOne(fetch = FetchType.LAZY)
  private Categoria categoriaMae;

  /**
  * @deprecated
  * Não utilizar! Criado por obrigação do hibernate
  */
  @Deprecated
  public Categoria(){
  }

  public Categoria(String nome) {
    this.nome = nome;
  }

  public void setCategoriaMae(Categoria categoriaMae) {
    this.categoriaMae = categoriaMae;
  }

  @Override
  public String toString() {
    return "Categoria [id=" + id + ", nome=" + nome + ", categoriaMae=" + categoriaMae + "]";
  }

}
