package ru.hello.controller.api;

import org.springframework.web.bind.annotation.*;
import ru.hello.controller.model.Person;

@RestController
public class HelloController {
    @PostMapping("/post")
    public String post(@RequestBody Person person) {
        return "post: "+ person.getName() + " " + person.getAge();
    }

    @GetMapping("/names")
    public String getName(@RequestParam String name,
                          @RequestParam String age) {
        return "get: " + name + " " + age;
    }
}
