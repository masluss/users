package com.users.users.infrastructure.out.jpa.repository;

import com.users.users.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleEntityRepository extends JpaRepository<RoleEntity, Long> {
}
