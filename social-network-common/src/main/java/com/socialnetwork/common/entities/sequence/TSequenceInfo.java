package com.socialnetwork.common.entities.sequence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="t_sequence_info")
@Data
public class TSequenceInfo {
	@Id
	@Column(name= "name",length = 10)
	private String name;
	@Column(name="current_num")
	private long currentNum;
	@Column(name="max_num")
	private long maxNum;
}
