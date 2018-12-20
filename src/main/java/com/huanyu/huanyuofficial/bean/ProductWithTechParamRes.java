package com.huanyu.huanyuofficial.bean;

import java.util.List;

public class ProductWithTechParamRes {
    private Integer totalPage;
    private Long total;
    private List<ProductWithTechParam> productWithTechParams;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<ProductWithTechParam> getProductWithTechParams() {
        return productWithTechParams;
    }

    public void setProductWithTechParams(List<ProductWithTechParam> productWithTechParams) {
        this.productWithTechParams = productWithTechParams;
    }
}
