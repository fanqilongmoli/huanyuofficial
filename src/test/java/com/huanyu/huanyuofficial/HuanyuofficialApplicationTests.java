package com.huanyu.huanyuofficial;

import com.huanyu.huanyuofficial.repository.CasesRepository;
import com.huanyu.huanyuofficial.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuanyuofficialApplicationTests {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    CasesRepository casesRepository;

    @Test
    public void contextLoads() {
        /*List<TechParam> techParamByPid = techParamRepository.findTechParamByPidAndShowInTableOrderBySort(114L,true);
        System.out.println(techParamByPid);
        PageRequest pageRequest = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "sort"));
        Page<TechParam> all = techParamRepository.findAll(pageRequest);
        all.map((item)->{
            System.out.println(item.getSort());
            return item;
        });
        System.out.println(all);*/
        /*Cases cases = new Cases();
        cases.setName("sss");
        cases.setCaseImage(new String[]{"23","43"});
        casesRepository.save(cases);

        Iterable<Cases> all = casesRepository.findAll();
        System.out.println(all);*/
    }

    @Test
    public void products(){
        /*PageRequest pageRequest = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<Product> page = productRepository.findProductsByDelFlagAndPtNameLike(0,"%123%",pageRequest);
        Page<Product> map = page.map((item) -> {
            item.setMainPic(null);
            return item;
        });
        System.out.println(map);*/
    }

}
