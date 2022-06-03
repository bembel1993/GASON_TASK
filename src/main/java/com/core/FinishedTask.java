package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FinishedTask {

    public static void main(String[] args) {
        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Staff staff = createStaffObject();

        // Java objects to String
        String json = gson.toJson(staff);
        try (FileWriter writer = new FileWriter("D:/Activity/Programming/ПрилИС_2/3_DOM, SAX, JAXB/GASON_task/student2.json")) {
            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("Vitali");
        staff.setAge(28);
        staff.setPosition(new String[]{"Engineer 2 category", "Java developer"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2022", new BigDecimal(25000));
            put("2020", new BigDecimal(20000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "jaxb", "JDBC", "Hibernate", "Gson", "SQL", "Git", "Maven"));

        return staff;

    }

}
