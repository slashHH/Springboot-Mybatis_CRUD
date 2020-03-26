package com.slash.springboot.controller;


import com.github.pagehelper.Page;
import com.slash.springboot.entity.Goods;
import com.slash.springboot.entity.PageBean;
import com.slash.springboot.entity.Result;
import com.slash.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/create")
    public Result create(@RequestBody Goods goods) {
        try {
            goodsService.create(goods);
            return new Result(true, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }


    @RequestMapping("/findAll")
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    public List<Goods> findById(@RequestParam(value = "id", required = false) Long id) {
        List<Goods> goodsList = goodsService.findById(id);
        return goodsList;
    }

    @RequestMapping("findByConPage")
    public PageBean findByConPage(
            Goods goods, @RequestParam(value = "pageCode", required = false)
            int pageCode,
            @RequestParam(value = "pageSize", required = false)
                    int pageSize) {
        return goodsService.findByPage(goods, pageCode, pageSize);

    }

    @RequestMapping("delete")
    public Result delete(@RequestBody Long... ids) {
        try {
            goodsService.delete(ids);
            return new Result(true, "更新数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }
}
