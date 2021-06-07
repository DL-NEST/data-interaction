package com.example.datainteraction.repository;
import com.example.datainteraction.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

//定义程序接口
public interface Userrepository extends JpaRepository<User,Integer> {

}
