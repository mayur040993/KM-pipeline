package com.ttn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harkesh on 18/8/17.
 */
@RestController
public class TestController {


  @RequestMapping(value = "/test")
  public String test(){
    return "Testing done";
  }
}
