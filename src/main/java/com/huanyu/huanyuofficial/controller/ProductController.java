package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.param.ProductListParam;
import com.huanyu.huanyuofficial.service.ProductService;
import com.huanyu.huanyuofficial.vo.ProductListVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hyofficial/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("list")
    @CrossOrigin
    public BaseResponse<ProductListVo> getAllProductByPage(@RequestBody ProductListParam productListParam){
        return productService.all(productListParam.getPageNo(),productListParam.getPageSize());
    }


    @ApiOperation("获取产品详情")
    @GetMapping("{id}")
    @CrossOrigin
    public BaseResponse<Product> getProductDetail(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @ApiOperation("保存产品")
    @PostMapping("save")
    @Transactional
    public BaseResponse save(@RequestBody Product product){
        return productService.addOrUpdate(product);
    }


    @ApiOperation("删除产品")
    @PostMapping("delete")
    @Transactional
    public BaseResponse delete(@RequestBody List<Long> ids){
       return productService.deleteProduct(ids);
    }
}
