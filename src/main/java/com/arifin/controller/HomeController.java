package com.arifin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by etos on 10/31/2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home()
    {
        return "home";
    }
}
