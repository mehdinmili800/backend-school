package com.mehdi.project_school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class ProjectSchoolApplication implements CommandLineRunner {

    @Autowired
    private InitData initData;

    public static void main(String[] args) {
        SpringApplication.run(ProjectSchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initData.Init();
    }
}
