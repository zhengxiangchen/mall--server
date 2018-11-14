package com.tianyu.jty.business.service;

import com.tianyu.jty.business.dao.MiniUserDao;
import com.tianyu.jty.business.entity.MiniUserEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MiniUserService extends BaseService<MiniUserEntity, Integer> {

    @Autowired
    private MiniUserDao miniUserDao;

    @Override
    public HibernateDao<MiniUserEntity, Integer> getEntityDao() {
        return miniUserDao;
    }
}
