package com.huanyu.huanyuofficial.controller;

import com.huanyu.huanyuofficial.HomeProductRes;
import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.ProductSelection;
import com.huanyu.huanyuofficial.bean.ProductWithTechParamRes;
import com.huanyu.huanyuofficial.bean.TechParam;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.service.ProductService;
import com.huanyu.huanyuofficial.utils.Base64ImageUtil;
import com.huanyu.huanyuofficial.vo.ProductDetail;
import com.huanyu.huanyuofficial.vo.ProductParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    @CrossOrigin
    public BaseResponse<HomeProductRes> getAllProductByPage(int page, int size){
        if (size==0){
            size=10;
        }
        page = page-1;
        if (page<=0){
            page=0;
        }
        return productService.all(page,size);
        //return productService.all();
    }


    @GetMapping("products")
    public BaseResponse<ProductWithTechParamRes> getAllProductDetail(int page, int size, String ptName){
        if (size==0){
            size=10;
        }
        page = page-1;
        if (page<=0){
            page=0;
        }
        return productService.getAllProductDetail(page,size,ptName);
    }

    @ApiOperation("获取产品详情")
    @GetMapping("{id}")
    @CrossOrigin
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

        Product product = productParam.getProduct();
        String mainPic = product.getMainPic();
        String secondPic = product.getSecondPic();
        String sizeLook = product.getSizeLook();
        if (product.getId()!=null){
            //修改
            if (mainPic.startsWith("data")){
                Base64ImageUtil.GenerateImage(mainPic,product.getId()+"main-pic.jpg");
                product.setMainPic(product.getId()+"main-pic.jpg");
            }
            //修改
            if (secondPic.startsWith("data")){
                Base64ImageUtil.GenerateImage(secondPic,product.getId()+"second-pic.jpg");
                product.setSecondPic(product.getId()+"second-pic.jpg");
            }
            //修改
            if (sizeLook.startsWith("data")){
                Base64ImageUtil.GenerateImage(sizeLook,product.getId()+"size-look.jpg");
                product.setSizeLook(product.getId()+"size-look.jpg");
            }
            Long pid = productService.addOrUpdate(product);
            productService.addOrUpdateSelection(productParam.getProductSelections(),pid);
            productService.addOrUpdateTechParam(productParam.getTechParams(),pid);
        }else {
            //新增
            product.setMainPic("");
            product.setSizeLook("");
            product.setSecondPic("");
            Long pid = productService.addOrUpdate(product);
            Base64ImageUtil.GenerateImage(mainPic,pid+"main-pic.jpg");
            Base64ImageUtil.GenerateImage(secondPic,pid+"second-pic.jpg");
            Base64ImageUtil.GenerateImage(sizeLook,pid+"size-look.jpg");
            product.setId(pid);
            product.setMainPic(pid+"main-pic.jpg");
            product.setSizeLook(pid+"size-look.jpg");
            product.setSecondPic(pid+"second-pic.jpg");
            pid = productService.addOrUpdate(product);
            productService.addOrUpdateSelection(productParam.getProductSelections(),pid);
            productService.addOrUpdateTechParam(productParam.getTechParams(),pid);
        }


        return new BaseResponse(200,"success");
    }

    @ApiOperation("保存产品")
    @GetMapping("/image/preview/{pic}")
    @Transactional
    public ResponseEntity<Resource> preview(@PathVariable String pic){
        try {
            String imageDir = System.getProperty("user.dir")+File.separator+"image";
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(new File(imageDir,File.separator+pic)));
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<>(inputStreamResource,httpHeaders, HttpStatus.OK);
        }catch (Exception e){
        }
        return null;
    }

    @ApiOperation("删除产品")
    @PostMapping("delete")
    @Transactional
    public BaseResponse delete(@RequestBody List<Long> ids){
        productService.deleteProduct(ids);
        return new BaseResponse(200,"success");
    }
}
