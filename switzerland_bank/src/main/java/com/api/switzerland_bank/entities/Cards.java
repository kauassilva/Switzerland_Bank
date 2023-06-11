package com.api.switzerland_bank.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards_tb")
public class Cards {
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cards_id;

    private Long clientId;

    private String numberCard;
    private String holderName;
    private LocalDate expirationDate;
    private int securityCode;
    private String cardName;
    private BigDecimal creditLimit;
    private int agency;
    
    private int cardPassword;

    public Cards(){
    }

   
    public Cards(Long cards_id, Long clientId, String numberCard, String holderName, LocalDate expirationDate,
            int securityCode, String cardName, BigDecimal creditLimit, int agency, int cardPassword) {
        this.cards_id = cards_id;
        this.clientId = clientId;
        this.numberCard = numberCard;
        this.holderName = holderName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.cardName = cardName;
        this.creditLimit = creditLimit;
        this.agency = agency;
        this.cardPassword = cardPassword;
    }


    public Long getCards_id() {
        return cards_id;
    }
    public void setCards_id(Long cards_id) {
        this.cards_id = cards_id;
    }
    
    
    public String getNumberCard() {
        return numberCard;
    }
    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public int getSecurityCode() {
        return securityCode;
    }
    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
    public int getAgency() {
        return agency;
    }
    public void setAgency(int agency) {
        this.agency = agency;
    }
    public int getCardPassword() {
        return cardPassword;
    }
    public void setCardPassword(int cardPassword) {
        this.cardPassword = cardPassword;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }  
    
    
    
      
    
}
