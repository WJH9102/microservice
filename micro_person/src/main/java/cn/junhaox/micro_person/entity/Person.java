package cn.junhaox.micro_person.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 16:03
 */
@Entity
@Table(name = "tb_person")
public class Person implements java.io.Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;
    private Integer address;

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer addrId) {
        this.address = addrId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
