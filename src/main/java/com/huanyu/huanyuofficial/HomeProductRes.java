package com.huanyu.huanyuofficial;

import com.huanyu.huanyuofficial.bean.Product;

import java.util.List;

public class HomeProductRes {
    private long total;
    private int page;
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
