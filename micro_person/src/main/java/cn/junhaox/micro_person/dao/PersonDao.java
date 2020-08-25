package cn.junhaox.micro_person.dao;

import cn.junhaox.micro_person.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 16:05
 */
// 1.集成其他接口 有基础增删改查方法
public interface PersonDao extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {

    // 2.按照约定的方法名 定义接口方法即可使用
    List<Person> findByNameOrderByAgeDesc(String name);

    List<Person> findByIdIn(List<String> ids);

    // 3.面向对象的SQL查询  JQL 增删改 需要加上 @Modifying 注解 service层需要加上@Transactional注解
    @Query("select p from Person p where age = ?1")
    List<Person> findByAge(Integer age);

    @Query("select p from Person p where age = ?1")
    List<Person> findByAgeWithPage(Integer age, Pageable pageable);

    @Modifying
    @Query("update Person p set p.age = :#{#person.age}, p.address = :#{#person.address}, p.name = :#{#person.name} where p.id = :#{#person.id}")
    Integer updatePerson(@Param("person") Person person);

    // 4.原生SQL查询 nativeQuery = true 增删改 需要加上 @Modifying 注解 service层需要加上@Transactional注解
    @Query(nativeQuery = true, value = "select name from tb_person where id = ?2 and name like %?1%")
    String findNameById(String id1, String id);

    @Query(nativeQuery = true, value = "select * from tb_person where age in (:ages) order by age")
    Page<Person> findPersonByAgeWithPage(@Param("ages") List<Integer> ages, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from tb_person where id = :#{#person.id}")
    Person findPersonById(@Param("person") Person person);

    @Modifying
    @Query(nativeQuery = true, value = "insert into tb_person(id, name, age, address) values (:#{#per.id}, :#{#per.name}, :#{#per.age}, :#{#per.address})")
    Integer addPerson(@Param("per") Person person);

    @Modifying
    @Query(nativeQuery = true, value = "update tb_person set name = :#{#per.name}, age = :#{#per.age}, address = :#{#per.address} where id = :#{#per.id}")
    Integer updatePersonById(@Param("per") Person person);

    @Modifying
    @Query(nativeQuery = true, value = "delete from tb_person where id = :id")
    Integer deletePersonById(@Param("id") String id);

    /**
     * 查询多表  -> 每个城市的人数
     * @return 每行数据是一个数组，有多行
     */
    @Query(nativeQuery = true, value = "select a.name, count(1) as 'count' from tb_address a INNER JOIN tb_person b ON a.id = b.address GROUP BY a.`name`")
    List<Object[]> findAddressNameAndCount();

}
