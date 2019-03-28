package com.huanyu.huanyuofficial.repository;

import com.huanyu.huanyuofficial.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAllPageByDelFlag(int delFlag, Pageable request);
    Page<Product> findProductsByDelFlagAndPtNameLike(int delFlag,String ptName, Pageable request);
}
