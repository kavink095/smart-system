package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellRepository extends JpaRepository<Cell,String> {
}
