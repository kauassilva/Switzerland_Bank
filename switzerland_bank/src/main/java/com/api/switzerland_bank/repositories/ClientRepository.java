package com.api.switzerland_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.switzerland_bank.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  /**
   * Busca um cliente pelo email.
   * @param email O email do cliente a ser encontrado.
   * @return O cliente correspondente ao email fornecido.
   */
  Client findByEmail(String email);
  Client findByChave(String chave);
  
}
