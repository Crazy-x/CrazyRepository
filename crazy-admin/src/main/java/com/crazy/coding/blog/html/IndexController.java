package com.crazy.coding.blog.html;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Slf4j
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping({"", "index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
