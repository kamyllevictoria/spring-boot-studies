package io.github_spring_boot_studies.spring_architecture.montadora.api;

import io.github_spring_boot_studies.spring_architecture.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFabricController {

    @Autowired
    private Engine engine;

    @PostMapping("/start")
    public CarStatus startCar(@RequestBody CarKey carKey){
        var car = new HondaCivic(engine);
        car.getIgnite(carKey);
        return car.getIgnite(carKey);
    }
}
