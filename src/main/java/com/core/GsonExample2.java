package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonExample2 {

    public static void main(String[] args) {

        // Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (Reader reader = new FileReader("D:/Activity/Programming/ПрилИС_2/3_DOM, SAX, JAXB/GASON_task/student.json")) {

            // Convert JSON File to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);

            // print staff
            System.out.println(staff);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //////////////// READ FILE and SHOW IN CONSOLE////////////////////


    }

}

