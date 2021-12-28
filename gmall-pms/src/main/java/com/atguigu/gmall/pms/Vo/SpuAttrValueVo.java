package com.atguigu.gmall.pms.Vo;

import com.atguigu.gmall.pms.entity.SpuAttrValueEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author chris
 * @Time 2021/12/27 23:02
 * @Descripition
 */
public class SpuAttrValueVo extends SpuAttrValueEntity {

    public void setValueSelected(List<Object> valueSelected){
        //如果接受的集合为空,则不设置
        if (CollectionUtils.isEmpty(valueSelected)){
            return;
        }
        setAttrValue(StringUtils.join(valueSelected,","));
    }
}
