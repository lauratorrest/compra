package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.dto.CompraDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraDto,Integer> {

}
