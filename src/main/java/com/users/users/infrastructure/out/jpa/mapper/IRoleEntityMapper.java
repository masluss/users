package com.users.users.infrastructure.out.jpa.mapper;

import com.users.users.domain.model.Role;
import com.users.users.infrastructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRoleEntityMapper {
    RoleEntity toEntity(Role role);
    Role toRole(RoleEntity roleEntity);
}
