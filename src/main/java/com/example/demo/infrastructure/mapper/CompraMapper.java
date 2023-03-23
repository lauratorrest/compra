package com.example.demo.infrastructure.mapper;

import com.example.demo.domain.entities.Compra;
import com.example.demo.infrastructure.dto.CompraDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompraMapper {
  Compra toCompraEntity(CompraDto compraDto);

  @Mapping(target = "idCompra", source = "idCompra")
  @Mapping(target = "total", source = "total")
  CompraDto toDto(Compra compra);

}
