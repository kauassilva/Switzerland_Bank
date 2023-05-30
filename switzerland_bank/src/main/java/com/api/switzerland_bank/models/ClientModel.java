package com.api.switzerland_bank.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_tb")
public class ClientModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 100)
  private String name;
  @Column(nullable = false, unique = true, length = 11)
  private String cpf;
  @Column(nullable = false, length = 100)
  private String motherName;
  @Column(nullable = false)
  private LocalDate dateBirth;
  @Column(nullable = false)
  private Gender gender;
  @Column(nullable = false, length = 255)
  private String address;
  @Column(nullable = false, length = 255)
  private String email;
  @Column(nullable = false, length = 128)
  private String password;

  public enum Gender {
    MALE,
    FEMALE,
    OTHER
  }

  /*
   * Constructors
   * ==================================================
   */
  public ClientModel() {
  }

  public ClientModel(Long id, String name, String cpf, String motherName, LocalDate dateBirth, Gender gender,
      String address, String email, String password) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.motherName = motherName;
    this.dateBirth = dateBirth;
    this.gender = gender;
    this.address = address;
    this.email = email;
    this.password = password;
  }

}
