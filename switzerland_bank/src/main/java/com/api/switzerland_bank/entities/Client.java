package com.api.switzerland_bank.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "client_tb")
public class Client {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome não pode ser vazio!")
  @Column(nullable = false, length = 100)
  private String name;

  @NotBlank(message = "O CPF não pode ser vazio ou inválido!")
  @Column(nullable = false, unique = true, length = 11)
  private String cpf;

  @NotBlank(message = "O nome da mãe não pode ser vazio!")
  @Column(nullable = false, length = 100)
  private String motherName;

  @Column(nullable = false)
  private LocalDate dateBirth;

  @NotBlank(message = "Selecione o seu gênero!")
  @Column(nullable = false)
  private String gender;

  @NotBlank(message = "O endereço não pode ser vazio!")
  @Column(nullable = false, length = 255)
  private String address;

  @NotBlank(message = "O e-mail não pode ser vazio!")
  @Column(nullable = false, unique=true, length = 255)
  private String email;

  @NotBlank(message = "A senha não pode ser vazia!")
  @Column(nullable = false, length = 128)
  private String password;

  private Double balance;

  private String chave;
  
  /*
  * Constructors
  * ==================================================
  */
  public Client() {
  }

  
  
  // public Client(Long id, String name, String cpf, String motherName, LocalDate dateBirth, String gender,
  // String address, String email, String password) {
  //   this.id = id;
  //   this.name = name;
  //   this.cpf = cpf;
  //   this.motherName = motherName;
  //   this.dateBirth = dateBirth;
  //   this.gender = gender;
  //   this.address = address;
  //   this.email = email;
  //   this.password = password;
  // }
  
  public Client(Long id, @NotBlank(message = "O nome não pode ser vazio!") String name,
      @NotBlank(message = "O CPF não pode ser vazio ou inválido!") String cpf,
      @NotBlank(message = "O nome da mãe não pode ser vazio!") String motherName, LocalDate dateBirth,
      @NotBlank(message = "Selecione o seu gênero!") String gender,
      @NotBlank(message = "O endereço não pode ser vazio!") String address,
      @NotBlank(message = "O e-mail não pode ser vazio!") String email,
      @NotBlank(message = "A senha não pode ser vazia!") String password, Double balance, String chave) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.motherName = motherName;
    this.dateBirth = dateBirth;
    this.gender = gender;
    this.address = address;
    this.email = email;
    this.password = password;
    this.balance = balance;
  }



  /*
   * Getters & Setters
   * ==================================================
   */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getMotherName() {
    return motherName;
  }
  
  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public LocalDate getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public Double getBalance() {
    return balance;
  }
  
  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public String getChave(){
    return chave;
  }

  public void setChave(String chave){
    this.chave = chave;
  }
}
