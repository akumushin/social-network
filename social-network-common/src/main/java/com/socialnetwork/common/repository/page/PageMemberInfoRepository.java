package com.socialnetwork.common.repository.page;

import org.springframework.data.repository.CrudRepository;

import com.socialnetwork.common.entities.page.PageMemberInfo;
import com.socialnetwork.common.entities.page.PageMemberPk;

public interface PageMemberInfoRepository extends CrudRepository<PageMemberInfo, PageMemberPk>{

}
