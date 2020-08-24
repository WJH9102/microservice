package cn.junhaox.micro_person.controller;

import cn.junhaox.entity.Message;
import cn.junhaox.entity.StatusCode;
import cn.junhaox.micro_person.entity.Person;
import cn.junhaox.micro_person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/8/23 16:17
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Message savePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return new Message(true, StatusCode.OK.getCode());
    }

    @DeleteMapping("/{id}")
    public Message deletePersonById(@PathVariable String id) {
        personService.deletePersonById(id);
        return new Message(true, StatusCode.OK.getCode());
    }

    @PutMapping
    public Message updatePersonById(@RequestBody Person person) {
        personService.updatePersonById(person);
        return new Message(true, StatusCode.OK.getCode());
    }

    @GetMapping("/{id}")
    public Message findPersonById(@PathVariable String id) {
        return new Message(true, StatusCode.OK.getCode(), personService.findPersonById(id));
    }

    @GetMapping
    public Message findAllPerson() {
        return new Message(true, StatusCode.OK.getCode(), personService.findAllPerson());
    }

    @GetMapping("/findByName/{name}")
    public Message findByNameOrderByAgeDesc(@PathVariable String name) {
        return new Message(true, StatusCode.OK.getCode(), personService.findByNameOrderByAgeDesc(name));
    }

    @GetMapping("findByAge/{age}")
    public Message findByAge(@PathVariable Integer age) {
        return new Message(true, StatusCode.OK.getCode(), personService.findByAge(age));
    }

    @GetMapping("/{age}/{page}/{size}")
    public Message findByAgeWithPage(@PathVariable Integer age, @PathVariable int page, @PathVariable int size) {
        return new Message(true, StatusCode.OK.getCode(), personService.findByAgeWithPage(age, page, size));
    }

    @PutMapping("/update")
    public Message updatePerson(@RequestBody Person person) {
        return new Message(true, StatusCode.OK.getCode(), personService.updatePerson(person));
    }

    @GetMapping("/findNameById/{id}")
    public Message findNameById(@PathVariable String id) {
        return new Message(true, StatusCode.OK.getCode(), personService.findNameById(id));
    }

    @GetMapping("/findPersonByAgeWithPage/{page}/{size}")
    public Message findPersonByAgeWithPage(@RequestParam("ages") List<Integer> ages, @PathVariable Integer page, @PathVariable Integer size) {
        return new Message(true, StatusCode.OK.getCode(), personService.findPersonByAgeWithPage(ages, page, size));
    }

    @GetMapping("/findPersonById")
    public Message findPersonById(@RequestBody Person person) {
        return new Message(true, StatusCode.OK.getCode(), personService.findPersonById(person));
    }

    @PostMapping("/addPerson")
    public Message addPerson(@RequestBody Person person) {
        return new Message(true, StatusCode.OK.getCode(), personService.addPerson(person));
    }

    @PutMapping("/updatePersonById1")
    public Message updatePersonById1(@RequestBody Person person) {
        return new Message(true, StatusCode.OK.getCode(), personService.updatePersonById1(person));
    }

    @DeleteMapping("/deletePersonById1/{id}")
    public Message deletePersonById1(@PathVariable String id) {
        return new Message(true, StatusCode.OK.getCode(), personService.deletePersonById1(id));
    }

    @GetMapping("/findByIdIn")
    public Message findByIdIn(@RequestParam("ids") List<String> ids) {
        return new Message(true, StatusCode.OK.getCode(), personService.findByIdIn(ids));
    }


}
