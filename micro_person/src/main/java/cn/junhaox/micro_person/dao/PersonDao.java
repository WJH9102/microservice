package cn.junhaox.micro_person.dao;

import cn.junhaox.micro_person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 16:05
 */
public interface PersonDao extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {
}
