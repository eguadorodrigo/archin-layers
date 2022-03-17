package br.com.eguadorodrigo.service.impl;

import br.com.eguadorodrigo.repository.ApplicationRepository;
import br.com.eguadorodrigo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public String hello() {
        return applicationRepository.hello();
    }
}
