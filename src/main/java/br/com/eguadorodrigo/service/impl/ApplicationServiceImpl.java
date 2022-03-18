package br.com.eguadorodrigo.service.impl;

import br.com.eguadorodrigo.repository.ApplicationRepository;
import br.com.eguadorodrigo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Classe de implementação da interface ApplicationService.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public String hello() {
        return applicationRepository.hello();
    }
}
