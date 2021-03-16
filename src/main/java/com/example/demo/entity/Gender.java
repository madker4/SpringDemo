package com.example.demo.entity;

import java.util.Arrays;
import java.util.List;

public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;
    private static List<String> maleNames = Arrays.asList("Ervin", "Dennis", "Kurtis");
    private static List<String> femaleNames = Arrays.asList("Leanne", "Clementine", "Chelsey", "Glenna");

    public static Gender genderDefinition(String nameUser)
    {
        if (maleNames.stream().filter(name -> nameUser.contains(name)).count() > 0)
        {return MALE;}
        else if (femaleNames.stream().filter(name -> nameUser.contains(name)).count() > 0)
        {return FEMALE;}
        else
            return UNKNOWN;
    }

}
