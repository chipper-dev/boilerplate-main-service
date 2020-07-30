package com.mitrais.chipper.temankondangan.backend.mainservice.controller.external;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.chipper.temankondangan.backend.mainservice.dto.response.UserResponseDTO;
import com.mitrais.chipper.temankondangan.backend.mainservice.service.HelloService;

@RestController
public class HelloController {
    @Autowired
    private HelloService userInterface;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        return "Hello from Profile Service running at port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/user/{id}")
    public UserResponseDTO getUser(HttpServletRequest request, @PathVariable("id") Long id) {
        return userInterface.fetchUser(request.getHeader(HttpHeaders.AUTHORIZATION), id);
    }
}
