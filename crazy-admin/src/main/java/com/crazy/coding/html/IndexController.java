package com.crazy.coding.html;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping({"", "index"})
    public ModelAndView index() {
        return new ModelAndView("index", "name", "Crazy");
    }
}
