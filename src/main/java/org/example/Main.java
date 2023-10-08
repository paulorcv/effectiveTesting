package org.example;

import static org.apache.commons.lang3.StringUtils.substringsBetween;

public class Main {
    public static void main(String[] args) {

        String str = "axcaycazc";
        String[] subs = substringsBetween(str, "a", "c");
        System.out.println(subs);
    }
}