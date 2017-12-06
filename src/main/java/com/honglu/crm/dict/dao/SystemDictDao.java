package com.honglu.crm.dict.dao;

import com.honglu.crm.dict.entity.SystemDictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDictDao extends JpaRepository<SystemDictEntity,String>,JpaSpecificationExecutor {
}
