package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.ProductSelection;
import com.huanyu.huanyuofficial.bean.TechParam;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.service.ProductSelectionService;
import com.huanyu.huanyuofficial.service.ProductService;
import com.huanyu.huanyuofficial.service.TeachParamService;
import com.huanyu.huanyuofficial.vo.ProductDetail;
import com.huanyu.huanyuofficial.vo.ProductParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private TeachParamService teachParamService;
    @Autowired
    private ProductSelectionService productSelectionService;

    @GetMapping("products")
    public BaseResponse<List<Product>> getAllProduct(){
        return productService.all();
    }

    @GetMapping("product/{id}")
    public BaseResponse<ProductDetail> getProductDetail(@PathVariable Long id){
       // return productService.all();
        List<TechParam> techParams = teachParamService.allById(id);
        List<ProductSelection> productSelections = productSelectionService.allById(id);
        Product product = productService.getProductById(id);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setProductSelections(productSelections);
        productDetail.setTechParams(techParams);
        return new BaseResponse<>(200,"success",productDetail);
    }


    @PostMapping
    @Transactional
    public BaseResponse save(@RequestBody ProductParam productParam){
        Long pid = productService.addOrUpdate(productParam.getProduct());
        productSelectionService.addOrUpdate(productParam.getProductSelections(),pid);
        teachParamService.addOrUpdate(productParam.getTechParams(),pid);
        return new BaseResponse(200,"success");
    }
}
