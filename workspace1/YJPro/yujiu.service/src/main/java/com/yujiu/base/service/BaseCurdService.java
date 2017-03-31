package com.yujiu.base.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yujiu.base.common.enums.CommonOperatorEnum;
import com.yujiu.base.common.exception.ServiceException;
import com.yujiu.base.common.util.SimplePage;
import com.yujiu.base.dao.BaseCurdMapper;



@SuppressWarnings("restriction")
public abstract class BaseCurdService {
	@Autowired(required=false)
	private Validator validator;
	
	@Value("")
	private String valid="false";
	
	private BaseCurdMapper mapper;
	
	
	@PostConstruct
	private void initConfig(){
		this.mapper=this.init();
		if(null!=valid&&new Boolean(valid)&&null==validator){
			throw new RuntimeException("注入service失败");
		}
	}
	
	public abstract BaseCurdMapper init();
	

	public <ModelType> void validate(ModelType t) throws ServiceException {
		if(null==valid||!new Boolean(valid)){
			return;
		}
		Set<ConstraintViolation<ModelType>> constraintViolations = validator.validate(t);
		if (constraintViolations.size() > 0) {
			StringBuilder validateError = new StringBuilder();
			for (ConstraintViolation<ModelType> constraintViolation : constraintViolations) {
				validateError.append("灞炴�э細").append(constraintViolation.getPropertyPath()).append("鎶ラ敊锛�")
						.append(constraintViolation.getMessage()).append(";");
			}
			throw new ServiceException(validateError.toString());
		}
	}
	
	
	public <ModelType> int deleteById(ModelType modelType) throws ServiceException {
		try {
			return mapper.deleteByPrimarayKeyForModel(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	public <ModelType> int deleteFakeById(ModelType modelType) throws ServiceException {
		try {
			return mapper.updateByPrimaryKeySelective(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	
	public <ModelType> int add(ModelType modelType) throws ServiceException {
		try {
			validate(modelType);
			return mapper.insertSelective(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	
	public <ModelType> ModelType findById(ModelType modelType) throws ServiceException {
		try {
			return mapper.selectByPrimaryKey(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	
	public <ModelType> List<ModelType> findByBiz(ModelType modelType,
			Map<String, Object> params) throws ServiceException {
		try {
			return mapper.selectByParams(modelType, params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	
	public <ModelType> int modifyById(ModelType modelType) throws ServiceException {
		try {
			return mapper.updateByPrimaryKeySelective(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	
	public int findCount(Map<String,Object> params) throws ServiceException {
		try {
			return mapper.selectCount(params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	
	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField,
			String orderBy,Map<String,Object> params) throws ServiceException {
		try {
			return this.findByPage(page, orderByField, orderBy, params);
		} catch (ServiceException e) {
			throw e;
		}
	}


	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
	public <ModelType> int save(Map<CommonOperatorEnum, List<ModelType>> params) throws ServiceException {
		try {
			int count=0;
			for (Entry<CommonOperatorEnum, List<ModelType>> param : params.entrySet()) {
				if(param.getKey().equals(CommonOperatorEnum.DELETED)){
					List<ModelType> list=params.get(CommonOperatorEnum.DELETED);
					if(null!=list&&list.size()>0){
						for (ModelType modelType : list) {
							count+=this.mapper.deleteByPrimarayKeyForModel(modelType);
						}
					}
				}
				if(param.getKey().equals(CommonOperatorEnum.UPDATED)){
					List<ModelType> list=params.get(CommonOperatorEnum.UPDATED);
					if(null!=list&&list.size()>0){
						for (ModelType modelType : list) {
							count+=this.mapper.updateByPrimaryKeySelective(modelType);
						}
					}
				}
				if(param.getKey().equals(CommonOperatorEnum.INSERTED)){
					List<ModelType> list=params.get(CommonOperatorEnum.INSERTED);
					if(null!=list&&list.size()>0){
						for (ModelType modelType : list) {
							this.mapper.insertSelective(modelType);
						}
						count+=list.size();
					}
				}
			}
			return count;
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
}
