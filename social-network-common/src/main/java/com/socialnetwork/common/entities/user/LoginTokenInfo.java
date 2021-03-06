package com.socialnetwork.common.entities.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.socialnetwork.common.entities.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "T_LOGIN_TOKEN_INFO")
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginTokenInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 100, nullable = false)
	private String token;
	
	@Column(name="ip_address",length = 12, nullable = false)
	private String ipAddress;
	
	@Column(name="user_id", nullable = false)
	private Long userId;
	
	@Column(name="token_expired_at",nullable = false)
	private LocalDateTime tokenExpiredAt;

	//relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private UserInfo userInfo;
}
