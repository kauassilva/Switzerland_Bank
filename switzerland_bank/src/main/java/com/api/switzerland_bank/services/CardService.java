package com.api.switzerland_bank.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.api.switzerland_bank.entities.Cards;
import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.repositories.CardRepository;

@Service
public class CardService {
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void save(Cards cr) {
        cardRepository.save(cr);
    }

    public Cards findByClientId(Long id) {
        return cardRepository.findByClientId(id);
    }

    private Long gerarNumeroAleatorio(int tamanho) {
        Random random = new Random();
        double limiteInferior = Math.pow(10, tamanho - 1); // Limite inferior do intervalo
        double limiteSuperior = Math.pow(10, tamanho) - 1; // Limite superior do intervalo
        long numeroAleatorio = (long) (random.nextLong() % ((long) limiteSuperior - (long) limiteInferior + 1)) + (long) limiteInferior;
        numeroAleatorio = Math.abs(numeroAleatorio);
        return numeroAleatorio;
    }

    private int gerarNumeroIntAleatorio(int tamanho) {
        Random random = new Random();
        int limiteInferior = (int) Math.pow(10, tamanho - 1); // Limite inferior do intervalo
        int limiteSuperior = (int) Math.pow(10, tamanho) - 1; // Limite superior do intervalo
        int numeroAleatorio = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
        return numeroAleatorio;
    }

    private String gerarNumeroAleatorioString(int tamanho) {
        return String.valueOf(gerarNumeroAleatorio(tamanho));
    }

    public Cards gerarCartao(Client authenticatedClient) {
        Cards card = new Cards();
        card.setClientId(authenticatedClient.getId());
        card.setNumberCard(gerarNumeroAleatorioString(16));
        card.setHolderName(authenticatedClient.getName());
        card.setExpirationDate(LocalDate.now().plusYears(7));
        card.setSecurityCode(gerarNumeroIntAleatorio(3));
        card.setCardName("SwiterCard");
        card.setCreditLimit(new BigDecimal(500));
        card.setAgency(1374);
        card.setCardPassword(gerarNumeroIntAleatorio(4));
        return card;
    }
}
