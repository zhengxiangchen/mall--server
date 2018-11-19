package com.tianyu.jty.business.service;

import com.tianyu.jty.business.dao.SwiperImgDao;
import com.tianyu.jty.business.entity.SwiperImgEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiperImgService extends BaseService<SwiperImgEntity, Integer> {

    @Autowired
    private SwiperImgDao swiperImgDao;

    @Override
    public HibernateDao<SwiperImgEntity, Integer> getEntityDao() {
        return swiperImgDao;
    }
}
