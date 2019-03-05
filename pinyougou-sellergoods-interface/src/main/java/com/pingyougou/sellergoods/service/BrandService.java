package com.pingyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author CHENG
 *
 */
public interface BrandService {

	/**
	 * 查询所有品牌
	 * @return
	 */
	public List<TbBrand> findAll();
	
	
	/**
	 * 品牌分页
	 * @param pageNum  当前页码
	 * @param pageSize 页记录数
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 新增品牌
	 * @param brand
	 */
	public void add(TbBrand brand);
	
	
	/**
	 * 修改品牌
	 * @param brand
	 */
	public void update(TbBrand brand);
	
	
	/**
	 * 根据id查找品牌
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	
	/**
	 * 批量删除品牌
	 * @param ids 
	 */
	public void delete(Long [] ids);
	
	
	/**
	 * 分页查询品牌
	 * @param brand  
	 * @param pageNum  当前页码
	 * @param PageSize 页记录数
	 * @return
	 */
	public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
	
	
}
