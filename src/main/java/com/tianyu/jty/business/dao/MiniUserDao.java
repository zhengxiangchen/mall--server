package com.tianyu.jty.business.dao;

import com.tianyu.jty.business.entity.MiniUserEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import org.springframework.stereotype.Repository;

@Repository
public class MiniUserDao extends HibernateDao<MiniUserEntity, Integer> {

}
