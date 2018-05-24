package com.ekiras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ekiras.domain.Coordinate;

/**
 * Created by ekansh on 12/7/15.
 */

@RestController
public class AirportLocationController {
	
	@GetMapping(value = "/test")
    public String test(){
        return " hello world";
    }
	
	@PostMapping(value = "/testMe")
    public String getAirport(@RequestBody Coordinate coordinate){
		System.out.println(coordinate.getLatitude());
        return " hello world";
    }
}
