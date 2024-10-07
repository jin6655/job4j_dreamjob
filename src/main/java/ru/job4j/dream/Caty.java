package ru.job4j.dream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Caty {

    private int x;
    private String str;
    private String[] massStr;

    public Caty() {
    }

    public Caty(int x, String str, String[] massStr) {
        this.x = x;
        this.str = str;
        this.massStr = massStr;
    }

    @Override
    public String toString() {
        return "Caty{" +
                "x=" + x +
                ", str='" + str + '\'' +
                ", massStr=" + Arrays.toString(massStr) +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Привет!");
    }

}
