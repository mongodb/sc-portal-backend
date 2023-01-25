package com.example.mdbspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
    public class MdbSpringBootApplicationController {

        String appName="SampleAppName";


        MdbSpringBootApplicationController() {}

        @GetMapping("/")
        @ResponseBody
        public String homePage(Model model) {
            model.addAttribute("appName", appName);
            return "home";
        }


}


