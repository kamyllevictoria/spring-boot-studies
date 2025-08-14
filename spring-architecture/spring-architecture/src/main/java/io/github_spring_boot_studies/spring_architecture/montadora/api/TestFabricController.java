package io.github_spring_boot_studies.spring_architecture.montadora.api;

import io.github_spring_boot_studies.spring_architecture.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class TestFabricController {

    @Autowired
    //@Qualifier("engineEletric") //especificacao do bean desejado
    @TurboEngine
    private Engine myEngine;

    @PostMapping("/start")
    public CarStatus startCar(@RequestBody CarKey carKey){
        var car = new HondaCivic(myEngine);
        car.getIgnite(carKey);
        return car.getIgnite(carKey);
    }
}
