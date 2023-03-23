package com.example.demo.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Compra {
  private int idCompra;
  private double total;

  public Compra(int idCompra, double total) {
    this.idCompra = idCompra;
    this.total = total;
  }
}
