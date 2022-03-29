package com.socialnetwork.common.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.RoleInfo;

@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Integer> {

}
