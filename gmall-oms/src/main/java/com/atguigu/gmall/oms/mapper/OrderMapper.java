package com.atguigu.gmall.oms.mapper;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author chris
 * @email 543542806@qq.com
 * @date 2021-12-26 14:50:49
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	
}
