package com.huanyu.huanyuofficial.vo;

import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.ProductSelection;
import com.huanyu.huanyuofficial.bean.TechParam;

import java.util.List;

public class ProductDetail {

    private Product product;
    private List<ProductSelection> productSelections;
    private List<TechParam> techParams;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductSelection> getProductSelections() {
        return productSelections;
    }

    public void setProductSelections(List<ProductSelection> productSelections) {
        this.productSelections = productSelections;
    }

    public List<TechParam> getTechParams() {
        return techParams;
    }

    public void setTechParams(List<TechParam> techParams) {
        this.techParams = techParams;
    }
}
