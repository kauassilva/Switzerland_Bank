package com.api.switzerland_bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.switzerland_bank.entities.BankStatement;

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {

    List<BankStatement> findByClientId(Long id);
    // Lista com ordem descendente do atributo dateBirth
    List<BankStatement> findByClientIdOrderByDataHoraDesc(Long id);

}
