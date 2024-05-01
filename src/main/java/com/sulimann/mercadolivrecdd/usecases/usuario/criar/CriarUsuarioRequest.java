package com.sulimann.mercadolivrecdd.usecases.usuario.criar;

import com.sulimann.mercadolivrecdd.models.Usuario;
import com.sulimann.mercadolivrecdd.utils.constants.ErrorMessage;
import com.sulimann.mercadolivrecdd.utils.validators.senhalimpa.SenhaLimpa;
import com.sulimann.mercadolivrecdd.utils.validators.uniquevalue.UniqueValue;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CriarUsuarioRequest {

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Email(message = "Email inválido")
  @UniqueValue(domainClass = Usuario.class, fieldName = "email", message = "Email já existente")
  private String email;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @SenhaLimpa(message = "Senha não pode estar encodada")
  @Size(min = 6, message = "Senha deve contêr no mínimo 5 caracteres")
  private String senha;

  public Usuario toModel() {
    return new Usuario(this.email, this.senha);
  }

  @Override
  public String toString() {
    return "CriarUsuarioRequest [email=" + email + "]";
  }

}
