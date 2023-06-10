package com.api.switzerland_bank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_statement_tb")
public class BankStatement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bank_statement_id;

    private Long clientId;

    private String tipoTransacao;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private String descricao;

    // Contrutores
    public BankStatement() {
    }
    
    public BankStatement(Long bank_statement_id, Long clientId, String tipoTransacao, BigDecimal valor,
            LocalDateTime dataHora, String descricao) {
        this.bank_statement_id = bank_statement_id;
        this.clientId = clientId;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    // Getters & Setters
    public Long getBank_statement_id() {
        return bank_statement_id;
    }
    
    public void setBank_statement_id(Long bank_statement_id) {
        this.bank_statement_id = bank_statement_id;
    }
    
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
