package com.example.demo.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.demoModel;

public interface demoRepository extends JpaRepository<demoModel ,UUID>{
    
}


