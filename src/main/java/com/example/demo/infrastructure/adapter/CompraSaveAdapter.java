package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.entities.Compra;
import com.example.demo.domain.service.CompraSaveService;
import com.example.demo.infrastructure.dto.CompraDto;
import com.example.demo.infrastructure.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompraSaveAdapter implements CompraSaveService {
  private final CompraRepository compraRepository;

  @Override
  public Compra saveCompra(Compra compra) {
    return buildCompra(compraRepository.save(buildCompraDto(compra)));
  }

  private Compra buildCompra(CompraDto compraDto){
    return new Compra(compraDto.getIdCompra(), compraDto.getTotal());
  }

  private CompraDto buildCompraDto(Compra compra){
    return new CompraDto(compra.getIdCompra(), compra.getTotal());
  }


}
