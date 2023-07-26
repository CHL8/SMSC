package com.hp.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.GoodsMapper;
import com.hp.pojo.Goods;
import com.hp.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Map<String,Object> getAll(Integer num) {
        Map<String,Object> map=new HashMap<>();
//        定义规则
        PageHelper.startPage(num, 5);
//        原始数据
        List<Goods> all = goodsMapper.getAll();
//        使用规则
        Page<Goods> p = (Page<Goods>) all;
        //总条数
        map.put("sum",p.getTotal());
        if(p.getTotal()%5==0)
            //总页数
            map.put("count",p.getTotal()/5);
        else
            map.put("count",p.getTotal()/5+1);
        //当前页
        map.put("current",num);
        //分页后数据
        map.put("goodList",p.getResult());
        return map;
    }
}
