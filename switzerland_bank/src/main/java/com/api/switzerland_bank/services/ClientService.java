package com.api.switzerland_bank.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.repositories.ClientRepository;

@Service
public class ClientService {

  // Injeção de dependência do ClientRepository
  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void save(Client c) {
    clientRepository.save(c);
  }

  public Client findByEmail(String email) {
    return clientRepository.findByEmail(email);
  }

  public void deleteById(long id){
    clientRepository.deleteById(id);
  }

  


  
}
