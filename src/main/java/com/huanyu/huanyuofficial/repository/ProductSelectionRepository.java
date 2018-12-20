package com.huanyu.huanyuofficial.repository;

import com.huanyu.huanyuofficial.bean.ProductSelection;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductSelectionRepository extends PagingAndSortingRepository<ProductSelection,Long> {
    List<ProductSelection> findAllByPidOrderById(Long pid);
}
