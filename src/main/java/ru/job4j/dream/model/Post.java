package ru.job4j.dream.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Post {

    private int id;

    private String name;

    private Timestamp time = new Timestamp(System.currentTimeMillis());

    private static SimpleDateFormat formatterDate = new SimpleDateFormat("dd MMM yyyy HH:mm");

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Post(int id, String name, Timestamp time) {
        this.id = id;
        this.name = name;
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

    public Timestamp getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(name, post.name) && Objects.equals(time, post.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, time);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + formatterDate.format(time) +
                '}';
    }

}
