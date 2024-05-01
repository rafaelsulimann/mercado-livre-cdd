package com.sulimann.mercadolivrecdd.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sulimann.mercadolivrecdd.utils.constants.TableName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.USUARIO)
@Getter
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "usuario", nullable = false, unique = true)
  private String email;

  @Column(name = "senha", nullable = false)
  private String senha;

  @Column(name = "data_criacao", nullable = false)
  private LocalDateTime dataCriacao = LocalDateTime.now(ZoneId.of("UTC"));

  public Usuario(String email, String senha) {
    this.email = email;
    this.senha = new BCryptPasswordEncoder().encode(senha);
  }

}
