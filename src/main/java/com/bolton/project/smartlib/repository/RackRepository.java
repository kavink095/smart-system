package com.bolton.project.smartlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.project.smartlib.entity.Rack;

@Repository
public interface RackRepository extends JpaRepository<Rack,String> {
}
