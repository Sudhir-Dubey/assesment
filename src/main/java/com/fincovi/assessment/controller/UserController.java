package com.fincovi.assessment.controller;

import com.fincovi.assessment.domain.User;
import com.fincovi.assessment.resource.ResponseResource;
import com.fincovi.assessment.resource.UserResource;
import com.fincovi.assessment.service.impl.UserService;
import com.fincovi.assessment.utils.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    HttpEntity<ResponseResource> getHealth() {
        return ResponseBuilder.build("I am alive ", HttpStatus.OK);
    }

    @PostMapping("/signin")
    public HttpEntity<ResponseResource> login(//
                                              @RequestParam String username,
                                              @RequestParam String password) {
        LOGGER.info("start of the " + UserController.class.getName() + " login method");
        String token = userService.signin(username, password);
        LOGGER.info("end of the " + UserController.class.getName() + " login method");
        return ResponseBuilder.build(token, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public HttpEntity<ResponseResource> signup(@RequestBody UserResource userResource) {
        LOGGER.info("start of the " + UserController.class.getName() + " signup method");
        User user = new User();
        BeanUtils.copyProperties(userResource, user);
        String token = userService.signup(user);
        LOGGER.info("end of the " + UserController.class.getName() + " signup method");
        return ResponseBuilder.build(token, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public HttpEntity<ResponseResource> delete(@PathVariable String username) {
        LOGGER.info("start of the " + UserController.class.getName() + " delete method");
        userService.delete(username);
        LOGGER.info("end of the " + UserController.class.getName() + " delete method");
        return ResponseBuilder.build("User deleted successfully", HttpStatus.OK);
    }


    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public HttpEntity<ResponseResource> refresh(HttpServletRequest req) {
        LOGGER.info("start of the " + UserController.class.getName() + " refresh method");
        String refreshedToken = userService.refresh(req.getRemoteUser());
        LOGGER.info("end  of the " + UserController.class.getName() + " refresh method");
        return ResponseBuilder.build(refreshedToken, HttpStatus.OK);
    }

}
