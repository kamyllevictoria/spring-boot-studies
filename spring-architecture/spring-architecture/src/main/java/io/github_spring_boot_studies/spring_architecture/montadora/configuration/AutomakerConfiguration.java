package io.github_spring_boot_studies.spring_architecture.montadora.configuration;

import io.github_spring_boot_studies.spring_architecture.montadora.Engine;
import io.github_spring_boot_studies.spring_architecture.montadora.TypeCarMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AutomakerConfiguration {

    @Bean
    public Engine engine(){
        var engine = new Engine();
        engine.setHorses(120);
        engine.setCylinders(3);
        engine.setModel("Sedan");
        engine.setLiters(2.0);
        engine.setTypeEngine(TypeCarMotor.ASPIRATED);
        return engine;
    }

    @Bean
    //@Primary //define o bean engineEletric como padrao
    public Engine eletricEngine(){
        var engine = new Engine();
        engine.setHorses(120);
        engine.setCylinders(3);
        engine.setModel("Sedan2");
        engine.setLiters(2.0);
        engine.setTypeEngine(TypeCarMotor.ELETRIC);
        return engine;
    }

    @Bean
    public Engine turboEngine(){
        var engine = new Engine();
        engine.setHorses(120);
        engine.setCylinders(3);
        engine.setModel("Sedan3");
        engine.setLiters(2.0);
        engine.setTypeEngine(TypeCarMotor.TURBO);
        return engine;
    }
}
