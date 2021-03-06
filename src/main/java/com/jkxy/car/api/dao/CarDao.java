package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.BuyCarVO;
import com.jkxy.car.api.pojo.Car;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarDao {
    @Select("select * from carMessage")
    List<Car> findAll();

    @Select("select * from carMessage where id = #{id}")
    Car findById(int id);

    @Select("select * from carMessage where carName = #{carName}")
    List<Car> findByCarName(String carName);

    @Delete("delete from carMessage where id = #{id}")
    void deleteById(int id);

    @Update("update carMessage set carName=#{carName},carType=#{carType},price=#{price},carSeries=#{carSeries} where id = #{id}")
    void updateById(Car car);

    @Insert("insert into carMessage(carName,carType,price,carSeries) values(#{carName},#{carType},#{price},#{carSeries})")
    void insertCar(Car car);

    @Select("select inventory from carMessage where carName=#{carName};")
    int selectCarInventoryByCarName(String carName);

    @Update("update carMessage set inventory=#{newInventory} where carName=#{carName};")
    void updateCarInventory(int newInventory,String carName);

    @Select("select * from carMessage where LOWER(carName) like #{carName}")
    List<Car> findLikeCarName(String carName);
}
