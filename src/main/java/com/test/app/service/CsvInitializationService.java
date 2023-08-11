package com.test.app.service;

import com.test.app.entity.MyObject;
import com.test.app.repository.MyObjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CsvInitializationService {
    private  final List<MyObject> myObjects = new ArrayList<>();

    @Autowired
    private MyObjectRepo myObjectRepo;

    public void initializationFromCsv() throws IOException {
        Resource resource = new ClassPathResource("my-data.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            myObjects.add(new MyObject(Long.parseLong(data[0]),data[1],data[2]));
        }
        reader.close();
        for (MyObject item : myObjects) {
            System.out.println(item);
        }
        addToDB();

    }
    private void addToDB(){
        for(MyObject e : myObjects)
            myObjectRepo.save(e);
    }

    public List<MyObject> getAll(){
        return myObjectRepo.findAll();
    }

    public void addObject(MyObject myObject) {
        myObjectRepo.save(myObject);
    }

    public void addRandomObject() {
    myObjectRepo.save(new MyObject(randomLong(),randomString(),randomString()));
    }
    private  long randomLong() {
        Random random = new Random();
        return random.nextLong();
    }



    private String randomString() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
