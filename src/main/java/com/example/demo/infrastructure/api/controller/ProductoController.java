package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.CompraSave;
import com.example.demo.domain.entities.Compra;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/compra")
public class ProductoController {
  private final CompraSave compraSave;

  @PostMapping
  public ResponseEntity<Compra> saveProducto(@RequestBody Compra compra){
    return new ResponseEntity<>(compraSave.saveCompra(compra), HttpStatus.CREATED);
  }
}
