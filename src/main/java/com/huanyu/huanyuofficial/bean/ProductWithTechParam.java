package com.huanyu.huanyuofficial.bean;

import java.util.List;

public class ProductWithTechParam {

    private Product product;
    private List<TechParam> techParams;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<TechParam> getTechParams() {
        return techParams;
    }

    public void setTechParams(List<TechParam> techParams) {
        this.techParams = techParams;
    }
}
