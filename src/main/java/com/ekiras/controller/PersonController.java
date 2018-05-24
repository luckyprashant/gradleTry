package com.ekiras.controller;

import com.ekiras.domain.Person;
import com.ekiras.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ekansh on 12/7/15.
 */

@RestController
public class PersonController {
	
	@GetMapping(value = "/test")
    public String test(){
        return " hello world";
    }
}
