package com.honglu.crm.dict.biz;


import com.alibaba.druid.support.json.JSONUtils;
import com.honglu.crm.dict.dao.SystemDictDao;
import com.honglu.crm.dict.entity.SystemDictEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class SystemDictService {
    private static Logger logger =LoggerFactory.getLogger(SystemDictService.class);

    @Autowired
    SystemDictDao baseDao;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Page<SystemDictEntity> listViewAll(int pageNumber,int pageSize,String queryParams){
        logger.info("分页参数：pageNumber={},pageSize={},queryParams={}",pageNumber,pageSize,queryParams);
        PageRequest pageable = new PageRequest(pageNumber,pageSize, Sort.Direction.ASC, "systemDictId");
        Specification<SystemDictEntity> specification = new Specification<SystemDictEntity>() {
            @Override
            public Predicate toPredicate(Root<SystemDictEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if(StringUtils.isNotBlank(queryParams)) {
                    List<Predicate> predicates = new ArrayList<Predicate>();
                    Predicate systemDictId = criteriaBuilder.like(root.get("systemDictId"), "%"+queryParams+"%");
                    predicates.add(systemDictId);
                    Predicate code = (criteriaBuilder.like(root.get("code"), "%"+queryParams+"%"));
                    predicates.add(code);
                    Predicate value = (criteriaBuilder.like(root.get("value"), "%"+queryParams+"%"));
                    predicates.add(value);
                    return criteriaBuilder.or(predicates
                            .toArray(new Predicate[]{}));
                }
                return  null;
            }
        };
        Page<SystemDictEntity> page =  baseDao.findAll(specification,pageable);
        return page;
    }

}
