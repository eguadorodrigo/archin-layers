package br.com.eguadorodrigo.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class MyArchitectureTest {

    @Test
    void service_architecture_rules(){
        JavaClasses javaClass = new ClassFileImporter().importPackages("br.com.eguadorodrigo");

        ArchRule rule = ArchRuleDefinition
            .classes()
            .that()
            .haveNameMatching(".*Service")
            .or().areAnnotatedWith(Service.class)
            .should().resideInAnyPackage("..service..")
            .allowEmptyShould(true);

        rule.check(javaClass);

    }

    @Test
    void repository_architecture_rules(){
        JavaClasses javaClass = new ClassFileImporter().importPackages("br.com.eguadorodrigo");

        ArchRule rule = ArchRuleDefinition
            .classes()
            .that()
            .haveNameMatching(".*Repository")
            .or().areAnnotatedWith(Repository.class)
            .should().resideInAnyPackage("..repository..")
            .allowEmptyShould(true);
        rule.check(javaClass);

    }

    @Test
    void controller_architecture_rules(){
        JavaClasses javaClass = new ClassFileImporter().importPackages("br.com.eguadorodrigo");

        ArchRule rule = ArchRuleDefinition
            .classes()
            .that()
            .haveNameMatching(".*Controller")
            .or().areAnnotatedWith(Controller.class)
            .should().resideInAnyPackage("..controller..")
            .allowEmptyShould(true);
        rule.check(javaClass);

    }

    @Test
    void layers_architecture_rules(){
        JavaClasses importedJavaClass = new ClassFileImporter().importPackages("br.com.eguadorodrigo");

        ArchRule rule = layeredArchitecture()
            .layer("Controller").definedBy("..controller..")
            .layer("Service").definedBy("..service..")
            .layer("Repository").definedBy("..repository..")

            .whereLayer("Controller").mayNotAccessAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

        rule.check(importedJavaClass);

    }
}
