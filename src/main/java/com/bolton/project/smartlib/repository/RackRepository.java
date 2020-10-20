package com.bolton.project.smartlib.repository;

import com.bolton.project.smartlib.entity.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<Rack, String> {

}
