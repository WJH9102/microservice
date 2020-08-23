package cn.junhaox.micro_city2.mapper;

import cn.junhaox.micro_city2.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 11:12
 */
@Mapper
public interface CityMapper {

    boolean addCity(City city);

    boolean deleteCity(Integer id);

    boolean updateCity(City city);

    List<City> queryCities();


}
