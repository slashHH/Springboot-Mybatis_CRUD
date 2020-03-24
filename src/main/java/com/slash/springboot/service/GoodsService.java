package com.slash.springboot.service;

import com.slash.springboot.entity.Goods;
import com.slash.springboot.entity.PageBean;

public interface GoodsService extends BaseService<Goods> {

    PageBean findByPage(Goods goods, int pageCode, int pageSize);
}
