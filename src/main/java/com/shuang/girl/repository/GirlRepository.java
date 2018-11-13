package com.shuang.girl.repository;

import com.shuang.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface GirlRepository extends JpaRepository<Girl,Integer> {
    public List<Girl> findByAge(Integer age);
}
