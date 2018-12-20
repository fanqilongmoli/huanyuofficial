package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.bean.*;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.service.ProductService;
import com.huanyu.huanyuofficial.vo.ProductDetail;
import com.huanyu.huanyuofficial.vo.ProductParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public BaseResponse<List<Product>> getAllProduct(){
        return productService.all();
    }

    @GetMapping("products")
    public BaseResponse<ProductWithTechParamRes> getAllProductDetail(int page, int size){
        if (size==0){
            size=10;
        }
        return productService.getAllProductDetail(page,size);
    }

    @ApiOperation("获取产品详情")
    @GetMapping("{id}")
    public BaseResponse<ProductDetail> getProductDetail(@PathVariable Long id){
       // return productService.all();
        List<TechParam> techParams = productService.allTechParamById(id);
        List<ProductSelection> productSelections = productService.allProductSelectionById(id);
        Product product = productService.getProductById(id);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setProductSelections(productSelections);
        productDetail.setTechParams(techParams);
        return new BaseResponse<>(200,"success",productDetail);
    }

    @ApiOperation("保存产品")
    @PostMapping("save")
    @Transactional
    public BaseResponse save(@RequestBody ProductParam productParam){
        Long pid = productService.addOrUpdate(productParam.getProduct());
        productService.addOrUpdateSelection(productParam.getProductSelections(),pid);
        productService.addOrUpdateTechParam(productParam.getTechParams(),pid);
        //System.out.println(productParam.getProduct().getPtName());
        return new BaseResponse(200,"success");
    }
}
