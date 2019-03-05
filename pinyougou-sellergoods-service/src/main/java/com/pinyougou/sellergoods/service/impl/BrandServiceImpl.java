package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;

import entity.PageResult;

/**
 * 品牌服务层
 * @author CHENG
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	/**
	 * 查询所有品牌
	 */
	@Override
	public List<TbBrand> findAll() {
		
		return brandMapper.selectByExample(null);
	}


	/**
	 * 分页查询所有品牌
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum,pageSize);//分页
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}


	/**
	 * 新增品牌
	 */
	@Override
	public void add(TbBrand brand) {
		
		brandMapper.insert(brand);
		
	}


	/**
	 * 修改品牌
	 */
	@Override
	public void update(TbBrand brand) {

		brandMapper.updateByPrimaryKey(brand);
		
	}


	
	/**
	 * 根据id查找品牌
	 */
	@Override
	public TbBrand findOne(Long id) {
		
		return brandMapper.selectByPrimaryKey(id);
	}


	/**
	 * 批量删除品牌
	 */
	@Override
	public void delete(Long[] ids) {
		
		for(Long id:ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
		
	}


	/**
	 * 分页查询品牌
	 */
	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);//分页
		
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		
		if(brand != null) {
			if(brand.getName()!=null && brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0) {
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

}
