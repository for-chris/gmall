package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chris
 * @email 543542806@qq.com
 * @date 2021-12-26 14:35:57
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {
	
}
