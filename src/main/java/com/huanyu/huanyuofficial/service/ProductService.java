package com.huanyu.huanyuofficial.service;

import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse<List<Product>> all() {
        Iterable<Product> all = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        all.forEach(products::add);
        BaseResponse<List<Product>> listBaseResponse = new BaseResponse<>(200,"");
        listBaseResponse.setData(products);
        return listBaseResponse;
    }

    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public Long addOrUpdate(Product product) {
        return productRepository.save(product).getId();
    }
}
