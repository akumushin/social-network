package com.socialnetwork.common.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.RegistTokenInfo;

@Repository
public interface RegistTokenRepository extends JpaRepository<RegistTokenInfo, String>{

}
