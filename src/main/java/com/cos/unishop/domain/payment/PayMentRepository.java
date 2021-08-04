package com.cos.unishop.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayMentRepository extends JpaRepository<Payment, Integer>{

}
