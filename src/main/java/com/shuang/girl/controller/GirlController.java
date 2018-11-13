package com.shuang.girl.controller;

import com.shuang.girl.service.GirlService;
import com.shuang.girl.domain.Girl;
import com.shuang.girl.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /*
     *查询所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /*
    * 新增女生
    * */
    @PostMapping(value = "/girls")
    public Girl grilAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    /*
    * 根据id查询一个女生
    * */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        Girl girl = girlRepository.findById(id).get();
        return girl;
    }

    /*
    *根据id修改一个女生
    * */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("age") Integer age,
                            @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /*
    * 根据id删除
    * */
    @DeleteMapping(value = "/girls/{id}")
    public void  girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /*
    * 根据年龄查询女生列表
    * */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /*
    * 插入两个女生
    * */
    @PostMapping(value = "/girls/two")
    public void girlAddTwo() {
        girlService.girlAddTwo();
    }

}
