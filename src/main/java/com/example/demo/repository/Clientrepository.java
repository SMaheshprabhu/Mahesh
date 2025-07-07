package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Client;

public interface Clientrepository extends JpaRepository<Client, Integer> {
        
}