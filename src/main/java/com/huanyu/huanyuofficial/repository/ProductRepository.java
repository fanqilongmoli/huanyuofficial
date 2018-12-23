package com.huanyu.huanyuofficial.repository;

import com.huanyu.huanyuofficial.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    List<Product> findAllByDelFlag(int delFlag);
    Page<Product> findAllPageByDelFlag(int delFlag, Pageable request);

}
