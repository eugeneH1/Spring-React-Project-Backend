package com.eugene.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    @RequestMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//        throw new RuntimeException("Something went wrong bruh!");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
