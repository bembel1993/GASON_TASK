package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {
        // pretty print
    /*    Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
                .create();
    */
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
                .create();

        Staff staff = createStaffObject();

        // Java objects to String
        String json = gson.toJson(staff);
        try (FileWriter writer = new FileWriter("D:/Activity/Programming/ПрилИС_2/3_DOM, SAX, JAXB/GASON_task/student.json")) {
            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

}

