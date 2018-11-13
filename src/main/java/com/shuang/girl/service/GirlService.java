package com.shuang.girl.service;

import com.shuang.girl.domain.Girl;
import com.shuang.girl.repository.GirlRepository;
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
}
