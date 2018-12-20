package com.huanyu.huanyuofficial.repository;

import com.huanyu.huanyuofficial.bean.TechParam;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TechParamRepository extends PagingAndSortingRepository<TechParam,Long> {
    List<TechParam> findTechParamByPidAndShowInTableOrderBySort(Long pid,Boolean show);
}
