package com.sulimann.mercadolivrecdd.usecases.categoria.criar;

import java.util.Objects;

import com.sulimann.mercadolivrecdd.models.Categoria;
import com.sulimann.mercadolivrecdd.repositories.CategoriaRepository;
import com.sulimann.mercadolivrecdd.utils.constants.ErrorMessage;
import com.sulimann.mercadolivrecdd.utils.validators.existsbyid.ExistsById;
import com.sulimann.mercadolivrecdd.utils.validators.uniquevalue.UniqueValue;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CriarCategoriaRequest {

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já existente")
  private String nome;

  @ExistsById(domainClass = Categoria.class, fieldName = "id", message = "Categoria não encontrada")
  private Long categoriaMaeId;

  public Categoria toModel(CategoriaRepository repository) {
    Categoria categoria = new Categoria(this.nome);

    if(this.possuiCategoriaMae()){
      Categoria categoriaMae = repository.findById(this.categoriaMaeId).get();
      categoria.setCategoriaMae(categoriaMae);
    }

    return categoria;
  }

  private boolean possuiCategoriaMae() {
    return Objects.nonNull(categoriaMaeId);
  }

  @Override
  public String toString() {
    return "CriarCategoriaRequest [nome=" + nome + ", categoriaMaeId=" + categoriaMaeId + "]";
  }

}
