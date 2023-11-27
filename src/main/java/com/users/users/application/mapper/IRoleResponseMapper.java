package com.users.users.application.mapper;

import com.users.users.application.dto.response.RoleResponseDto;
import com.users.users.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {
    RoleResponseDto toRoleResponseDto(Role role);
    default Optional<RoleResponseDto> toRoleOptional (Optional<Role> role) {
        return role.map(this::toRoleResponseDto);
    }
}
