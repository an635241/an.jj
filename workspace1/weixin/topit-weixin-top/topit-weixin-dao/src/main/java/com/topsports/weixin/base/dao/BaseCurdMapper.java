package com.topsports.weixin.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.topsports.weixin.base.common.model.AuthorityParams;
import com.topsports.weixin.base.common.utils.SimplePage;

/**
 * DAO层基类接口
 * @author zhang.p
 *
 */
public interface BaseCurdMapper {
	
	public int deleteByPrimaryKey(int id);

    public <ModelType> int insert(ModelType record);

    public <ModelType> int insertSelective(ModelType record);

    public <ModelType> ModelType selectByPrimaryKey(ModelType modelType);
    
    public <ModelType> List<ModelType> selectByParams(@Param("model")ModelType modelType,@Param("params")Map<String,Object> params);

    public <ModelType> int updateByPrimaryKeySelective(ModelType record);

    public <ModelType> int updateByPrimaryKey(ModelType record);
    
    public int selectCount(@Param("params")Map<String,Object> params,@Param("authorityParams") AuthorityParams authorityParams);
    
    public <ModelType> List<ModelType> selectByPage(@Param("page") SimplePage page,@Param("orderByField") String orderByField,@Param("orderBy") String orderBy,@Param("params")Map<String,Object> params,@Param("authorityParams") AuthorityParams authorityParams);
    
    public <ModelType> int deleteByPrimarayKeyForModel(ModelType record);
}
