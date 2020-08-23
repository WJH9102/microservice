package cn.junhaox.micro_person.service;

import cn.junhaox.micro_person.dao.PersonDao;
import cn.junhaox.micro_person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
