package com.socialnetwork.common.repository.sequence;

import org.springframework.data.repository.CrudRepository;

import com.socialnetwork.common.entities.sequence.SequenceInfo;
import com.socialnetwork.common.repository.CustomDao;

public interface TSequenceInfoRepository extends CrudRepository<SequenceInfo, String>, CustomDao<SequenceInfo>{
	
}
