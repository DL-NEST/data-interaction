package com.example.datainteraction.Service;

import com.example.datainteraction.entiy.User;
import com.example.datainteraction.repository.Temperaturerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TemperatureService {

    @Autowired
    private Temperaturerepository temperaturerepository;

    /**
     * 通过姓名查询
     * @param name
     * @return
     */
//    public List<User> findByName(String name){
//        return temperaturerepository.findByName(name);
//    }
//
//    /**
//     * 通过地址查询
//     * @param address
//     * @return
//     */
//    public List<User> findByAddress(String address){
//        return temperaturerepository.findByAddress(address);
//    }
//
//    /**
//     * 通过姓名和地址查询
//     * @param name
//     * @param address
//     * @return
//     */
//    public List<User> withNameAndAddressQuery(String name,String address){
//        return temperaturerepository.withNameAndAddressQuery(name,address);
//    }
//
//    /**
//     * 删除一行
//     * @param name
//     * @return
//     */
//    public  int deleteByName(String name){
//        return temperaturerepository.deleteByName(name);
//    }
//
//    /**
//     * 新增方法
//     * @param name
//     * @param age
//     * @param address
//     * @return
//     */
//    public int Add(String name, int age,String address){
//        return temperaturerepository.Add(name,age,address);
//    }
//
//    /**
//     * 更改数据库中的一行
//     * @param id
//     * @param name
//     * @return
//     */
//    public int modify(int id,String name){
//        return temperaturerepository.modify(id,name);
//    }
}
