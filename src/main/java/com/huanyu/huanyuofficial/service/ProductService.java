package com.huanyu.huanyuofficial.service;

import com.google.common.collect.Iterables;
import com.huanyu.huanyuofficial.HomeProductRes;
import com.huanyu.huanyuofficial.bean.*;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import com.huanyu.huanyuofficial.repository.ProductSelectionRepository;
import com.huanyu.huanyuofficial.repository.TechParamRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSelectionRepository productSelectionRepository;

    @Autowired
    private TechParamRepository techParamRepository;

    public BaseResponse<HomeProductRes> all(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> allProducts = productRepository.findAllPageByDelFlag(0, pageRequest);
        HomeProductRes homeProductRes = new HomeProductRes();
        homeProductRes.setPage(allProducts.getTotalPages());
        homeProductRes.setTotal(allProducts.getTotalElements());
        homeProductRes.setProducts(allProducts.getContent());
        return new BaseResponse<>(200,"success",homeProductRes);

    }

    public void deleteProduct(List<Long> ids){
        ids.forEach((item)->{
            Product product = new Product();
            product.setId(item);
            product.setDelFlag(1);
            productRepository.save(product);
        });
    }

    public BaseResponse<ProductWithTechParamRes> getAllProductDetail(int page, int size,String ptName){
        ProductWithTechParamRes productWithTechParamRes = new ProductWithTechParamRes();
        List<ProductWithTechParam> productWithTechParams = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> all;
        if (StringUtils.isNullOrEmpty(ptName)){
            all = productRepository.findAllPageByDelFlag(0,pageRequest);
        }else {
            all =  productRepository.findProductsByDelFlagAndPtNameLike(0,"%"+ptName+"%",pageRequest);
        }
        all.forEach((item)->{
            item.setMainPic(null);
            item.setSecondPic(null);
            item.setSizeLook(null);
            ProductWithTechParam productWithTechParam = new ProductWithTechParam();
            List<TechParam> techParamByPidAndShowInTableOrderBySort = techParamRepository.findTechParamByPidAndShowInTableOrderBySort(item.getId(), true);
            productWithTechParam.setProduct(item);
            productWithTechParam.setTechParams(techParamByPidAndShowInTableOrderBySort);
            productWithTechParams.add(productWithTechParam);
        });
        productWithTechParamRes.setProductWithTechParams(productWithTechParams);
        productWithTechParamRes.setTotal(all.getTotalElements());
        productWithTechParamRes.setTotalPage(all.getTotalPages());
        return new BaseResponse<>(200,"success",productWithTechParamRes);
    }


    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public Long addOrUpdate(Product product) {
        return productRepository.save(product).getId();
    }


    public List<ProductSelection> allProductSelectionById(Long pid){
        return productSelectionRepository.findAllByPidOrderById(pid);
    }

    public void addOrUpdateSelection(List<ProductSelection> productSelections,Long pid){
        productSelections.forEach((productSelection) -> {
            productSelection.setPid(pid);
            if (productSelection.getId()<0){
                productSelection.setId(null);
            }
        });
        Iterable<ProductSelection> selectionIterable = Iterables.concat(productSelections);
        productSelectionRepository.saveAll(selectionIterable);
    }

    public List<TechParam> allTechParamById(Long pid){
        return techParamRepository.findTechParamByPidOrderBySort(pid);
    }


    public void addOrUpdateTechParam(List<TechParam> techParams, Long pid){
        techParams.forEach(productSelection -> productSelection.setPid(pid));
        Iterable<TechParam> selectionIterable = Iterables.concat(techParams);
        techParamRepository.saveAll(selectionIterable);
    }
}
