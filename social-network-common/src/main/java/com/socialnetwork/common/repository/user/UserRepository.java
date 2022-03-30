package com.socialnetwork.common.repository.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialnetwork.common.entities.user.UserInfo;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	Optional<UserInfo> findByUsername(String username);
	
	@Modifying
	@Query("UPDATE #{#entityName} u SET u.isEnabled = true WHERE u.username = :username")
	void activeByUsername(String username);
	
	@Modifying
	@Query("UPDATE #{#entityName} u SET u.isEnabled = true WHERE u.id = ?1")
	void activeById(long id);
	
	@Modifying
	@Query("UPDATE #{#entityName} u SET u.isBlocked = ?2 WHERE u.username = ?1")
	void blockAndUnblock(String username, boolean status);
	@Modifying
	@Query("UPDATE #{#entityName} u SET u.isBlocked = ?2 WHERE u.id = ?1")
	void blockAndUnblock(long id, boolean status);
	@Modifying
	@Query("UPDATE #{#entityName} u SET u.email = ?2 WHERE u.username = ?1")
	void changeEmail(String username, String email);
}
