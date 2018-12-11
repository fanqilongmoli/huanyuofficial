package com.huanyu.huanyuofficial.service;

import com.google.common.collect.Iterables;
import com.huanyu.huanyuofficial.bean.TechParam;
import com.huanyu.huanyuofficial.repository.TechParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachParamService {

    @Autowired
    private TechParamRepository techParamRepository;

    public List<TechParam> allById(Long id){
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        Iterable<TechParam> techParams = techParamRepository.findAllById(ids);
        List<TechParam> paramArrayList = new ArrayList<>();
        techParams.forEach(paramArrayList::add);
        return paramArrayList;
    }


    public void addOrUpdate(List<TechParam> techParams, Long pid){
        techParams.forEach(productSelection -> productSelection.setPid(pid));
        Iterable<TechParam> selectionIterable = Iterables.concat(techParams);
        techParamRepository.saveAll(selectionIterable);
    }
}
