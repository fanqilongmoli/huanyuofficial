package com.huanyu.huanyuofficial.service;

import com.google.common.collect.Iterables;
import com.huanyu.huanyuofficial.bean.ProductSelection;
import com.huanyu.huanyuofficial.repository.ProductSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSelectionService {

    @Autowired
    private ProductSelectionRepository productSelectionRepository;

    public List<ProductSelection> allById(Long id){
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        Iterable<ProductSelection> productSelections = productSelectionRepository.findAllById(ids);
        List<ProductSelection> selectionArrayList = new ArrayList<>();
        productSelections.forEach(selectionArrayList::add);
        return selectionArrayList;
    }

    public void addOrUpdate(List<ProductSelection> productSelections,Long pid){
        productSelections.forEach((productSelection) -> {
            productSelection.setPid(pid);
            if (productSelection.getId()<0){
                productSelection.setId(null);
            }
        });
        Iterable<ProductSelection> selectionIterable = Iterables.concat(productSelections);
        productSelectionRepository.saveAll(selectionIterable);
    }
}
