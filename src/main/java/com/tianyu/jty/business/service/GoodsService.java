package com.tianyu.jty.business.service;

import com.tianyu.jty.business.dao.GoodsDao;
import com.tianyu.jty.business.entity.GoodsEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BaseService<GoodsEntity, Integer> {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public HibernateDao<GoodsEntity, Integer> getEntityDao() {
        return goodsDao;
    }
}
