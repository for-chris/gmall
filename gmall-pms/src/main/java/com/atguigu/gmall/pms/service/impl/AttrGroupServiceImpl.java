package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.Vo.GroupVo;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.mapper.AttrMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.Group;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.AttrGroupMapper;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;
import org.w3c.dom.Attr;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<AttrGroupEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageResultVo(page);
    }

    @Autowired
    private AttrMapper attrMapper;

    @Override
    public List<GroupVo> queryByCid(Long catId) {
        //查询所属的分组  catId分组id
        List<AttrGroupEntity> attrGroupEntities = list(
                new QueryWrapper<AttrGroupEntity>().eq("category_id",catId)
        );
        //查询出每组下的规格参数
        return attrGroupEntities.stream().map(attrGroupEntity ->{
            GroupVo groupVo = new GroupVo();
            BeanUtils.copyProperties(attrGroupEntity,groupVo);

            //查询规格参数，只需查询出每个分组下的通用属性就可以了(不需要销售属性)
            List<AttrEntity> attrEntities = attrMapper.selectList(
                    new QueryWrapper<AttrEntity>().eq("group_id",attrGroupEntity.getId()).eq("type",1));
            groupVo.setAttrEntities(attrEntities);
            return groupVo;
        }).collect(Collectors.toList());
    }

}