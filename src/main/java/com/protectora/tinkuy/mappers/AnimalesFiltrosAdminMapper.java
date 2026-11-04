package com.protectora.tinkuy.mappers;

import com.protectora.tinkuy.dto.AnimalesFiltrosAdminDto;
import com.protectora.tinkuy.models.AnimalesFiltrosAdmin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimalesFiltrosAdminMapper {

    AnimalesFiltrosAdmin toModel(AnimalesFiltrosAdminDto filtrosDto);
}