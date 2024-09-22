package com.theater.utils;

import java.text.DecimalFormat;

public class Utility {
    static String humanReadable(float number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }
}
