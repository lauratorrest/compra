package com.example.demo.application;

import com.example.demo.domain.entities.Compra;
import com.example.demo.domain.service.CompraSaveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompraSave {
  private final CompraSaveService compraSaveService;

  public Compra saveCompra(Compra compra){
    return compraSaveService.saveCompra(compra);
  }
}
