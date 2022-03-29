package com.socialnetwork.common.repository.page;

import org.springframework.data.repository.CrudRepository;

import com.socialnetwork.common.entities.page.PageInfo;
import com.socialnetwork.common.repository.CustomDao;

public interface PageInfoRepository extends CrudRepository<PageInfo, Long>, CustomDao<PageInfo>{
	
}
