package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.sellergoods.service.BrandService;
import com.pinyougou.pojo.TbBrand;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	/**
	 * 
	 * 查询所有品牌
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	/**
	 * 分页查询所有品牌
	 * @param page  当前页
	 * @param rows  当前页显示数据
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows) {
		return brandService.findPage(page, rows);
	}
	
	
	/**
	 * 新增品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		
		try {
			brandService.add(brand);
			return new Result(true,"品牌添加成功");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(false,"品牌添加失败");
		}
		
	}
	
	
	/**
	 * 修改品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		
		try {
			brandService.update(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败"); 
		}
	}
	
	
	
	/**
	 * 根据id查找品牌
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		
		return brandService.findOne(id);
	}
	
	
	@RequestMapping("/delete")
	public Result delete(Long [] ids) {
		
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
		
	}
	
	
	/**
	 * 分页查询品牌
	 * @param brand
	 * @param page 当前页
	 * @param rows 当前页显示数据
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,int page,int rows) {
		
		return brandService.findPage(brand, page, rows);
		
	}
}
