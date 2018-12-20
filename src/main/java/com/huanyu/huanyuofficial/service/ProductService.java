package com.huanyu.huanyuofficial.service;

import com.google.common.collect.Iterables;
import com.huanyu.huanyuofficial.bean.*;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import com.huanyu.huanyuofficial.repository.ProductSelectionRepository;
import com.huanyu.huanyuofficial.repository.TechParamRepository;
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

    public BaseResponse<List<Product>> all() {
        Iterable<Product> all = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        all.forEach(products::add);
        BaseResponse<List<Product>> listBaseResponse = new BaseResponse<>(200,"");
        listBaseResponse.setData(products);
        return listBaseResponse;
    }

    public BaseResponse<ProductWithTechParamRes> getAllProductDetail(int page, int size){
        ProductWithTechParamRes productWithTechParamRes = new ProductWithTechParamRes();
        List<ProductWithTechParam> productWithTechParams = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> all = productRepository.findAll(pageRequest);
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


    public List<ProductSelection> allProductSelectionById(Long id){
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        Iterable<ProductSelection> productSelections = productSelectionRepository.findAllById(ids);
        List<ProductSelection> selectionArrayList = new ArrayList<>();
        productSelections.forEach(selectionArrayList::add);
        return selectionArrayList;
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

    public List<TechParam> allTechParamById(Long id){
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        Iterable<TechParam> techParams = techParamRepository.findAllById(ids);
        List<TechParam> paramArrayList = new ArrayList<>();
        techParams.forEach(paramArrayList::add);
        return paramArrayList;
    }


    public void addOrUpdateTechParam(List<TechParam> techParams, Long pid){
        techParams.forEach(productSelection -> productSelection.setPid(pid));
        Iterable<TechParam> selectionIterable = Iterables.concat(techParams);
        techParamRepository.saveAll(selectionIterable);
    }
}
