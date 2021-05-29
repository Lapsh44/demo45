package spring.demo.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.demo.services.Programm;

@RestController
public class Mapping {
    @Autowired
    Programm programm;
    @GetMapping ("/hels")
    public String hels ()
    {

        return  "OK"+ programm.test();

    }
}
