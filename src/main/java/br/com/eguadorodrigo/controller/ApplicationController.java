package br.com.eguadorodrigo.controller;

import br.com.eguadorodrigo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller da camada de Controller.
 */
@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/")
    public String get(Model model) {
        return applicationService.hello();
    }
}
