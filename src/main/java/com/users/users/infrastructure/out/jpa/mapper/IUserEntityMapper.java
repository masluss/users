package com.users.users.infrastructure.out.jpa.mapper;

import com.users.users.domain.model.User;
import com.users.users.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {
    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
}
