package cn.junhaox.micro_person.controller;

import cn.junhaox.entity.Message;
import cn.junhaox.entity.StatusCode;
import cn.junhaox.micro_person.entity.Person;
import cn.junhaox.micro_person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
