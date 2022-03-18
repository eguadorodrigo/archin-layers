package br.com.eguadorodrigo.repository.impl;

import br.com.eguadorodrigo.repository.ApplicationRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe implementadora de ApplicationRepository.
 */
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {
    @Override
    public String hello() {
        return "Hello world is different, if you see me, I'm going back through all layers in the project Archin!";
    }
}
