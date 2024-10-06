package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Candidate {

    private int id;

    private String name;

    private String city;

    private OffsetDateTime time = OffsetDateTime.now();

    private static DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss xxx");


    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Candidate(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Candidate(int id, String name, String city, OffsetDateTime time) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name) && Objects.equals(city, candidate.city) && Objects.equals(time, candidate.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, time);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", time=" + time.format(offsetFormatter) +
                '}';
    }

}
