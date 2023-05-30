package com.api.switzerland_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.repositories.ClientRepository;

@Service
public class ClientService {

  // Injeção de dependência do ClientRepository
  @Autowired
  private ClientRepository clientRepository;

  /*
   * Método de salvar os clientes
   */
  public void save(Client c) {
    clientRepository.save(c);
  }
  
}
