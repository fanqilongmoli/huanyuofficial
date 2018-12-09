package com.huanyu.huanyuofficial.repository;

import com.huanyu.huanyuofficial.bean.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}
