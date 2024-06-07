package com.car.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 个人中心.
 */
@RequestMapping("/car/mine")
@Controller
public class MineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MineController.class);

    /**
     * index.
     *
     * @return index
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "/car/mine/index";
    }
}
