package cn.junhaox.micro_city.service;

import cn.junhaox.micro_city.entity.City;
import cn.junhaox.micro_city.mapper.CityMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 14:09
 */
@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public boolean addCity(City city){
        return cityMapper.addCity(city);
    }

    public boolean deleteCity(Integer id) {
        return cityMapper.deleteCity(id);
    }

    public boolean updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    public List<City> queryCities() {
        return cityMapper.queryCities();
    }
}
