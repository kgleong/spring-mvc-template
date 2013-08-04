package com.orangemako.spring.controller.webservice;

import com.orangemako.spring.domain.User;
import com.orangemako.spring.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * User Web Service Controller
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping("user")
public class UserWebServiceController {
    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> getAllItems() {
        return userRepository.findAll();
    }
}
