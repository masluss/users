package com.users.users.application.mapper;

import com.users.users.application.dto.request.RoleRequestDto;
import com.users.users.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {
    Role toRole(RoleRequestDto roleRequestDto);
}
