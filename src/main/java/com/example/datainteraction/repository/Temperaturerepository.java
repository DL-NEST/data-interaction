package com.example.datainteraction.repository;
import com.example.datainteraction.entiy.User;
import com.example.datainteraction.entiy.temperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//定义程序接口
public interface Temperaturerepository extends JpaRepository<temperature, Integer> {

}