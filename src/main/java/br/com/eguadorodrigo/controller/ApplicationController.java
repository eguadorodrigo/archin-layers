package br.com.eguadorodrigo.controller;

import br.com.eguadorodrigo.model.dto.ApplicationResponse;
import br.com.eguadorodrigo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    ResponseEntity<String> get(){
        return ResponseEntity.ok(applicationService.hello());
    }
}
