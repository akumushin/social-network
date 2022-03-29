package com.socialnetwork.common.entities.status;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.socialnetwork.common.entities.blockcause.BlockCauseInfo;
import com.socialnetwork.common.entities.page.PageInfo;
import com.socialnetwork.common.entities.user.UserInfo;
import com.socialnetwork.common.types.BooleanConvert;
import com.socialnetwork.common.types.StatusType;

import lombok.Data;

@Data
@Entity
@Table(name = "m_status_info")
@IdClass(StatusPk.class)
public class StatusInfo{
	// PAGE_ID
	@Id
	@Column(name = "page_id")
	private Long pageId;
	// STATUS_ID
	@Id
	@Column(name = "status_id")
	private Long statusId;
	//owner_id
	@Column(name="owner_id", nullable = false)
	private Long ownerId;
	// STATUS_TYPE
	@Column(name = "status_type", nullable = false)
	@Convert(converter = StatusType.Convert.class)
	private StatusType statusType;
	// create_at
	@Column(name = "create_at")
	private LocalDateTime createAt;
	// update_at
	@Column(name = "update_at")
	private LocalDateTime updateAt;
	// del_flag
	@Column(name = "del_flag", nullable = false)
	@Convert(converter = BooleanConvert.class)
	private boolean delFlag;
	// del_at
	@Column(name = "del_at")
	private LocalDateTime delAt;
	// block_flag
	@Column(name = "block_flag", nullable = false)
	@Convert(converter = BooleanConvert.class)
	private boolean blockFlag;
	// block_at
	@Column(name = "block_at")
	private LocalDateTime blockAt;
	// block_cause_id
	@Column(name = "block_cause_id")
	private Integer blockCauseId;

	//relationship
	
	@JoinColumn(name="owner_id", updatable = false, insertable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo ownerInfo;
	
	@JoinColumn(name="block_cause_id", updatable = false, insertable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private BlockCauseInfo blockCauseInfo;
	
	@JoinColumn(name="page_id", updatable = false, insertable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private PageInfo pageInfo;
}
