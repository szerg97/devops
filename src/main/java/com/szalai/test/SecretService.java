package com.szalai.test;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class SecretService {

    @Value("${spring.profiles.active}")
    private String env;

    public void read(){

        if (env.equals("dev")){
            System.out.println("Reading secret...");
            try {
                FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\secrets\\secret.json");
                Object ob = new JSONParser(reader);
                System.out.println("Secret loaded");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Running without secret...");
        }

    }

}
