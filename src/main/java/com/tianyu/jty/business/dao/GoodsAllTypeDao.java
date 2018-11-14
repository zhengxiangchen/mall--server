package com.tianyu.jty.business.dao;

import com.tianyu.jty.business.entity.GoodsAllTypeEntity;
import com.tianyu.jty.common.persistence.HibernateDao;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsAllTypeDao extends HibernateDao<GoodsAllTypeEntity, Integer> {

    /**
     * 查询所有的商品类型
     * @return 商品类型集合
     */
    public List<GoodsAllTypeEntity> getAllList() {
        StringBuffer sb = new StringBuffer();
        sb.append("select t.id id, t.pid pid, t.name name from mini_goods_all_type t");
        SQLQuery sqlQuery=createSQLQuery(sb.toString());
        sqlQuery.setResultTransformer(Transformers.aliasToBean(GoodsAllTypeEntity.class));
        return sqlQuery.list();
    }


    /**
     * 取得所有以id为pid的二级类型
     * @param id
     * @return
     */
    public List<GoodsAllTypeEntity> getListByPid(Integer id) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from mini_goods_all_type where pid = ?0");
        SQLQuery sqlQuery=createSQLQuery(sb.toString(), id);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(GoodsAllTypeEntity.class));
        return sqlQuery.list();
    }

    /**
     * 一级商品类型集合
     * @return
     */
    public List<GoodsAllTypeEntity> getFirstTypeList() {
        StringBuffer sb = new StringBuffer();
        sb.append("select t.id id, t.pid pid, t.name name from mini_goods_all_type t where t.pid is null");
        SQLQuery sqlQuery=createSQLQuery(sb.toString());
        sqlQuery.setResultTransformer(Transformers.aliasToBean(GoodsAllTypeEntity.class));
        return sqlQuery.list();
    }
}
