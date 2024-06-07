package com.spring.repository;

import org.springframework.stereotype.Repository;
@Repository("userRepository")
public class UserRepositoryImps implements UserRepository{
 
     @Override
     public void save() {
         System.out.println("已经完成save方法的实例化！");
     }
}
