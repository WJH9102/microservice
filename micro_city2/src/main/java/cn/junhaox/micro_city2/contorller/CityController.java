package cn.junhaox.micro_city2.contorller;

import cn.junhaox.entity.Message;
import cn.junhaox.entity.StatusCode;
import cn.junhaox.micro_city2.entity.City;
import cn.junhaox.micro_city2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/22 14:18
 */
@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("addCity")
    public Message addCity(@RequestBody City city){
        Message msg = new Message();
        boolean res = cityService.addCity(city);
        if (res) {
            msg.setFlag(true);
            msg.setCode(StatusCode.OK.getCode());
        } else {
            msg.setFlag(false);
            msg.setCode(StatusCode.ERROR.getCode());
        }
        return msg;
    }

    @DeleteMapping("deleteCity/{id}")
    public Message deleteCity(@PathVariable Integer id) {

        Message msg = new Message();
        boolean res = cityService.deleteCity(id);
        if (res) {
            msg.setFlag(true);
            msg.setCode(StatusCode.OK.getCode());
        } else {
            msg.setFlag(false);
            msg.setCode(StatusCode.ERROR.getCode());
        }
        return msg;
    }

    @PutMapping("updateCity")
    public Message updateCity(@RequestBody City city) {
        Message msg = new Message();
        boolean res = cityService.updateCity(city);
        if (res) {
            msg.setFlag(true);
            msg.setCode(StatusCode.OK.getCode());
        } else {
            msg.setFlag(false);
            msg.setCode(StatusCode.ERROR.getCode());
        }
        return msg;
    }

    @GetMapping("queryCities")
    public Message queryCities() {
        Message msg = new Message();
        List<City> cities = cityService.queryCities();
        msg.setFlag(true);
        msg.setCode(StatusCode.OK.getCode());
        msg.setData(cities);
        return msg;
    }

}
