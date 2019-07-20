package com.heyc.gasstation.softem.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyc.gasstation.softem.utils.BaseMapper;
import com.heyc.gasstation.softem.utils.DataGrid;
import com.heyc.gasstation.softem.utils.Entity;
import com.heyc.gasstation.softem.utils.Page;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class BaseBiz <M extends BaseMapper<T>, T extends Entity<PK>,PK extends Serializable> {

    @Autowired
    public M mapper;
    @Autowired
    protected SqlSession sqlSession;

    public BaseBiz(){}

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }
    public T selectOne(T entity) {
        return this.mapper.selectOne(entity);
    }

    public T get(PK id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public List<T> list(T entity){
        return mapper.select(entity);
    }

    public Long selectCount(T entity) {
        return new Long(this.mapper.selectCount(entity));
    }

    public List<T> selectAll() {
        return this.mapper.selectAll();
    }
    public void insert(T entity) {
        this.mapper.insert(entity);
    }

    public void saveAll(List<T> list) {
        list.forEach(obj -> {
            this.insert(obj);
        });
    }

    public T save (T entity) {
        this.mapper.insert(entity);
        return entity;
    }

    public void insertSelect(T entity) {
        this.mapper.insertSelective(entity);
    }

    public void delete(T entity) {
        entity.setDeleted("T");
        this.mapper.delete(entity);
    }

    public void deleteTrue(PK id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    public void deletedById(PK id) {
        T entity = this.get(id);
        if (entity != null) {
            entity.setDeleted("T");
            this.update(entity);
        }
    }

    public void update (T entity) {
        this.mapper.updateByPrimaryKey(entity);
    }

    public void updateSelectiveById(T entity) {
        this.mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Example example) {
        example.and(example.createCriteria().andEqualTo("deleted", "F"));
        return this.mapper.selectByExample(example);
    }

    public int selectCountByExample(Example example) {
        example.and(example.createCriteria().andEqualTo("deleted", "F"));
        return this.mapper.selectCountByExample(example);
    }

    public void delete(Collection<PK> ids) {
        Iterator<PK> ites = ids.iterator();
        while (ites.hasNext()) {
            PK id = ites.next();
            this.deletedById(id);
        }
    }

    public void updateBatch(List<T> entitys) {
        Iterator<T> ites = entitys.iterator();
        while (ites.hasNext()) {
            T entity = ites.next();
            this.mapper.updateByPrimaryKeySelective(entity);
        }
    }

    public DataGrid<T> page(Example example, Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        if (page.getSort() != null && !"".equals(page.getSort())) {
            PageHelper.orderBy(page.getSort() + "" + page.getOrder());
        }
        example.and(example.createCriteria().andEqualTo("deleted", "F"));
        List <T> list = this.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getList(), (int)pageInfo.getTotal(), pageInfo.getPages());
    }

}
