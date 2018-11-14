package com.shuang.girl.service;

import com.shuang.girl.domain.Girl;
import com.shuang.girl.enums.ResultEnum;
import com.shuang.girl.exception.GirlException;
import com.shuang.girl.repository.GirlRepository;
import com.shuang.girl.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void girlAddTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("n");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("P11");
        girlB.setAge(20);
        girlRepository.save(girlB);
    }

    public void checkAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 10) {
            //小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16 ) {
            //初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }
}
