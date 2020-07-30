package com.mitrais.chipper.temankondangan.backend.mainservice.controller.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.chipper.temankondangan.backend.mainservice.common.CommonResource;
import com.mitrais.chipper.temankondangan.backend.mainservice.security.TokenProvider;
import com.mitrais.chipper.temankondangan.backend.mainservice.service.CommandService;

import io.swagger.annotations.Api;

@Api(value = "Profile Command Management System")
@RestController
@Validated
@RequestMapping("/")
public class CommandController extends CommonResource {

	@Autowired
	TokenProvider tokenProvider;

	@Autowired
	CommandService profileService;

}