package com.bolton.project.smartlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolton.project.smartlib.entity.Rack;

import java.util.List;

@Repository
public interface RackRepository extends JpaRepository<Rack,String> {
    List<Rack> findByRacid(@Param("racid") String racid);

}
