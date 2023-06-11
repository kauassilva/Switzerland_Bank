package com.api.switzerland_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.switzerland_bank.entities.Cards;
@Repository
public interface CardRepository extends JpaRepository<Cards, Long> {
    
}
