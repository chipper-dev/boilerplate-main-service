package com.mitrais.chipper.temankondangan.backend.mainservice.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.chipper.temankondangan.backend.mainservice.controller.internal.LegacyFeignClient;
import com.mitrais.chipper.temankondangan.backend.mainservice.dto.response.UserResponseDTO;

@Service
public class HelloService {
    @Autowired
    private LegacyFeignClient legacyFeignClient;

    public UserResponseDTO fetchUser(String token, Long id) {
        return legacyFeignClient.fetchUserbyId(token, id).orElseThrow(() -> new NoSuchElementException("nothing"));
    }
}
