package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu信息介绍
 * 
 * @author chris
 * @email 543542806@qq.com
 * @date 2021-12-26 14:35:57
 */
@Data
@TableName("pms_spu_desc")
public class SpuDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 * spuDesc使用的是spu的主键,需要根据spu的结果来设置
	 * 而在application.yml配置的逐渐策略是自增长
	 * 如果不设置为IdType.INPUT (手动设置主键),会报错
	 */
	@TableId(type = IdType.INPUT)
	private Long spuId;
	/**
	 * 商品介绍
	 */
	private String decript;

}
