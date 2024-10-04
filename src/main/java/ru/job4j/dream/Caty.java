package ru.job4j.dream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Caty cat = new Caty(34, "Anny", new String[]{"Old", "Boy", "Girl"});
        Gson gsonCat = new GsonBuilder().create();
        Caty cat02 = gsonCat.fromJson(gsonCat.toJson(cat), Caty.class);
        System.out.println(cat02);
    }

}
