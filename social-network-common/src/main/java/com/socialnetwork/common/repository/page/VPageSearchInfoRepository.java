package com.socialnetwork.common.repository.page;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.socialnetwork.common.entities.page.VPageSearchInfo;

public interface VPageSearchInfoRepository extends Repository<VPageSearchInfo, Long>, JpaSpecificationExecutor<VPageSearchInfo>{
	Optional<VPageSearchInfo> findById(Long id);
}
