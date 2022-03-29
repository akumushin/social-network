package com.socialnetwork.common.repository.sequence;

import org.springframework.data.repository.CrudRepository;

import com.socialnetwork.common.entities.sequence.TSequenceInfo;
import com.socialnetwork.common.repository.CustomDao;

public interface TSequenceInfoRepository extends CrudRepository<TSequenceInfo, String>, CustomDao<TSequenceInfo>{
	
}
