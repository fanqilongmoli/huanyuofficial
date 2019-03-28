package com.huanyu.huanyuofficial.vo;

import com.huanyu.huanyuofficial.bean.Product;

import java.util.List;

public class ProductListVo {
    private long total;
    private int page;
    private List<Product> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
