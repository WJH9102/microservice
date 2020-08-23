package cn.junhaox.micro_city.mapper;

import cn.junhaox.micro_city.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 11:12
 */
public interface CityMapper {

    @Insert("insert into city(id, name, area) values (#{id}, #{name}, #{area})")
    boolean addCity(City city);

    @Delete("delete from city where id = #{id}")
    boolean deleteCity(Integer id);

    @Update("update city set name = #{name}, area = #{area} where id = #{id}")
    boolean updateCity(City city);

    @Select("select * from city")
    List<City> queryCities();


}
