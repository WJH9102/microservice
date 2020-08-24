package cn.junhaox.micro_person.service;

import cn.junhaox.micro_person.dao.PersonDao;
import cn.junhaox.micro_person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 16:14
 */
@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    public void savePerson(Person person) {
        personDao.save(person);
    }

    public void deletePersonById(String id) {
        personDao.deleteById(id);
    }

    public void updatePersonById(Person person) {
        personDao.save(person);
    }

    public Person findPersonById(String id) {
        return personDao.findById(id).get();
    }

    public List<Person> findAllPerson() {
        return personDao.findAll();
    }

    public List<Person> findByNameOrderByAgeDesc(String name) {
        return personDao.findByNameOrderByAgeDesc(name);
    }

    public List<Person> findByAge(Integer age) {
        return personDao.findByAge(age);
    }

    public List<Person> findByAgeWithPage(Integer age, int page, int size) {
        PageRequest pageOf = PageRequest.of(page - 1, size);
        return personDao.findByAgeWithPage(age, pageOf);
    }

    @Transactional
    public Integer updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    public String findNameById(String id) {
        return personDao.findNameById("s", id);
    }

    public Page<Person> findPersonByAgeWithPage(List<Integer> ages, Integer page, Integer size) {
        PageRequest of = PageRequest.of(page - 1, size);
        return personDao.findPersonByAgeWithPage(ages, of);
    }

    public Person findPersonById(Person person) {
        return personDao.findPersonById(person);
    }

    @Transactional
    public Integer addPerson(Person person) {
        return personDao.addPerson(person);
    }

    @Transactional
    public Integer updatePersonById1(Person person) {
        return personDao.updatePersonById(person);
    }

    @Transactional
    public Integer deletePersonById1(String id) {
        return personDao.deletePersonById(id);
    }

    public List<Person> findByIdIn(List<String> ids) {
        return personDao.findByIdIn(ids);
    }

}
