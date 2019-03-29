package com.huanyu.huanyuofficial.service;

import com.huanyu.huanyuofficial.vo.ProductListVo;
import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse<ProductListVo> all(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> allProducts = productRepository.findAllPageByDelFlag(0, pageRequest);
        ProductListVo productListVo = new ProductListVo();
        productListVo.setPage(allProducts.getTotalPages());
        productListVo.setTotal(allProducts.getTotalElements());
        productListVo.setList(allProducts.getContent());
        return new BaseResponse<>(200,"success",productListVo);

    }

    public BaseResponse deleteProduct(List<Long> ids){
        ids.forEach((item)->{
            Product product = new Product();
            product.setId(item);
            product.setDelFlag(1);
            productRepository.save(product);
        });
        return new BaseResponse(200,"success");
    }


    public BaseResponse<Product> getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return new BaseResponse<>(200,"success",optionalProduct.orElse(null));
    }

    public BaseResponse addOrUpdate(Product product) {
         productRepository.save(product);
        return new BaseResponse(200,"success");
    }

    public BaseResponse updateImage(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        boolean present = optionalProduct.isPresent();
        if (present){
            Product p = optionalProduct.get();
            p.setSizeLook(product.getSizeLook());
            p.setSecondPic(product.getSecondPic());
            p.setMainPic(product.getMainPic());
            p.setProductSelections(product.getProductSelections());
            p.setProductTech(product.getProductTech());
            productRepository.save(p);
            return new BaseResponse(200,"success");
        }else {
            return new BaseResponse(404,"产品不存在！");
        }
    }

}
