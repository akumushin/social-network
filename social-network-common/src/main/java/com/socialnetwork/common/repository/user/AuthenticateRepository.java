package com.socialnetwork.common.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.AuthenticateInfo;
import com.socialnetwork.common.entities.user.AuthenticatePk;

@Repository
public interface AuthenticateRepository extends JpaRepository<AuthenticateInfo, AuthenticatePk>{

}
