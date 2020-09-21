package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Integer> {
}
