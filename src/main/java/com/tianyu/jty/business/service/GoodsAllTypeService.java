package com.tianyu.jty.business.service;

import com.tianyu.jty.business.dao.GoodsAllTypeDao;
import com.tianyu.jty.business.entity.GoodsAllTypeEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import com.tianyu.jty.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GoodsAllTypeService extends BaseService<GoodsAllTypeEntity, Integer> {

    @Autowired
    private GoodsAllTypeDao goodsAllTypeDao;

    @Override
    public HibernateDao<GoodsAllTypeEntity, Integer> getEntityDao() {
        return goodsAllTypeDao;
    }

    /**
     * 获取所有商品类型
     * @return 商品类型集合
     */
    public List<GoodsAllTypeEntity> getAllList() {
        return goodsAllTypeDao.getAllList();
    }

    /**
     * 判断一级类型是否可以删除
     * @param id
     * @return
     */
    public boolean canDel(Integer id) {
        List<GoodsAllTypeEntity> list = goodsAllTypeDao.getListByPid(id);
        if(list.size() > 0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 一级商品类型集合
     * @return
     */
    public List<GoodsAllTypeEntity> getFirstTypeList() {
        return goodsAllTypeDao.getFirstTypeList();
    }
}
