package com.atguigu.gmall.pms.Vo;

import com.atguigu.gmall.pms.entity.SpuEntity;
import lombok.Data;

import java.awt.*;
import java.util.List;

/**
 * @Author chris
 * @Time 2021/12/27 22:52
 * @Descripition
 */
//spu扩展对象,接受提交页面json数据
@Data
public class SpuVo extends SpuEntity {

    //图片信息
    private List<String> spuIamges;
    //基本属性信息
    private List<SpuAttrValueVo> baseAttrs;
    //sku信息
    private List<SkuVo> skus;

}
