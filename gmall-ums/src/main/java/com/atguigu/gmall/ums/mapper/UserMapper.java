package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author chris
 * @email 543542806@qq.com
 * @date 2021-12-26 14:59:49
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
