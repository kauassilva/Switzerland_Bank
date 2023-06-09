package com.api.switzerland_bank.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.switzerland_bank.entities.BankStatement;
import com.api.switzerland_bank.repositories.BankStatementRepository;

@Service
public class BankStatementService {
    
    private BankStatementRepository bankStatementRepository;

    public BankStatementService(BankStatementRepository bankStatementRepository) {
        this.bankStatementRepository = bankStatementRepository;
    }

    public void save(BankStatement bs) {
        bankStatementRepository.save(bs);
    }

    public List<BankStatement> getAllBankStatement(Long id) {
        return bankStatementRepository.findByClientIdOrderByDataHoraDesc(id);
    }

}
