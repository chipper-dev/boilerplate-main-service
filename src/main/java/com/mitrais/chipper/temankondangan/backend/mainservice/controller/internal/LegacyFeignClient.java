package com.mitrais.chipper.temankondangan.backend.mainservice.controller.internal;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitrais.chipper.temankondangan.backend.mainservice.dto.response.UserResponseDTO;

@FeignClient(name = "legacy-service")
@RequestMapping(value = "/api")
public interface LegacyFeignClient {
	
	// user service
    @GetMapping(value = "/user/{id}")
    Optional<UserResponseDTO> fetchUserbyId(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("id") Long id);
    
}
