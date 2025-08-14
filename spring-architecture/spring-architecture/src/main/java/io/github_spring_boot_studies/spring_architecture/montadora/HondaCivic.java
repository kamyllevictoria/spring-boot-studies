package io.github_spring_boot_studies.spring_architecture.montadora;

import java.awt.*;

public class HondaCivic extends Car {

    public HondaCivic(Engine engine){
        super(engine);
        setModel("Sedan");
        setColor(Color.BLACK);
        setPrice(78.000);
        setMotor(Automaker.HONDA);
    }

}
