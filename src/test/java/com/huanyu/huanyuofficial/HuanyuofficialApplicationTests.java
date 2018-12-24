package com.huanyu.huanyuofficial;

import com.huanyu.huanyuofficial.bean.Product;
import com.huanyu.huanyuofficial.bean.TechParam;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import com.huanyu.huanyuofficial.repository.TechParamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuanyuofficialApplicationTests {

    @Autowired
    TechParamRepository techParamRepository;

    @Autowired
    ProductRepository productRepository;
    @Test
    public void contextLoads() {
        List<TechParam> techParamByPid = techParamRepository.findTechParamByPidAndShowInTableOrderBySort(114L,true);
        System.out.println(techParamByPid);
        PageRequest pageRequest = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "sort"));
        Page<TechParam> all = techParamRepository.findAll(pageRequest);
        all.map((item)->{
            System.out.println(item.getSort());
            return item;
        });
        System.out.println(all);
    }

    @Test
    public void products(){
        PageRequest pageRequest = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> page = productRepository.findProductsByDelFlagAndPtNameLike(0,"%123%",pageRequest);
        Page<Product> map = page.map((item) -> {
            item.setMainPic(null);
            return item;
        });
        System.out.println(map);
    }

}
