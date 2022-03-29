package com.socialnetwork.common.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.ForgetPwdTokenInfo;

@Repository
public interface ForgetPwdTokenRepository extends JpaRepository<ForgetPwdTokenInfo, Long> {

}
