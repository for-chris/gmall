package com.atguigu.gmall.pms.Vo;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author chris
 * @Time 2021/12/27 20:24
 * @Descripition
 */
@Data
public class GroupVo extends AttrGroupEntity {

    private List<AttrEntity> attrEntities;
}
