package com.api.switzerland_bank.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.repositories.ClientRepository;

@Service
public class ClientService {

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
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

  public Client findByChave(String chave) {
    return clientRepository.findByChave(chave);
  }

  public void deleteById(long id) {
    clientRepository.deleteById(id);
  }

  public String generateRandomValue(int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      int randomIndex = random.nextInt(CHARACTERS.length());
      char randomChar = CHARACTERS.charAt(randomIndex);
      sb.append(randomChar);
    }

    return sb.toString();
  }

    public String cartaoRandom(){
     Random random = new Random();
     long numeroPositivo = Math.abs(random.nextLong());
        String numeroCartao = String.format("%16d", numeroPositivo);
        return numeroCartao;

  }
  
  }
 