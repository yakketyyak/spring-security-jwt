package com.yakketyyak.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.yakketyyak.dao.entity.UserEntity;
import com.yakketyyak.dto.UserDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

	UserDto toDto(UserEntity entity);

	UserEntity toEntity(UserDto dto);

	List<UserDto> toDtos(List<UserEntity> entities);

}
