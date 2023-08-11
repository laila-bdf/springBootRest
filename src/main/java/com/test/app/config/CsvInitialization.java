package com.test.app.config;

import com.test.app.service.CsvInitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class CsvInitialization implements ApplicationRunner {

    @Autowired
    private CsvInitializationService csvInitializationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        csvInitializationService.initializationFromCsv();
    }
}
