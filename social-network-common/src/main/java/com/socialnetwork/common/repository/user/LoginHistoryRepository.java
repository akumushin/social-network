package com.socialnetwork.common.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.LoginHistoryPk;
import com.socialnetwork.common.entities.user.LoginTokenInfo;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginTokenInfo, LoginHistoryPk>{

}
