package com.megayasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class InventoryMegayasaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(InventoryMegayasaApplication.class, args);
        new SpringApplicationBuilder(InventoryMegayasaApplication.class)
                .headless(false).run(args);
    }

}
