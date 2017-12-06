package com.honglu.crm.dao;

import com.honglu.crm.bo.SsoUserBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SsoUserBo,String> {

    @Query(value = "select entity from SsoUserBo entity where userName=:name")
    SsoUserBo findByName(@Param("name") String name);
}