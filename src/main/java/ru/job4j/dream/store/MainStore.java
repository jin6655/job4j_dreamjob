package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainStore {

    public static void main(String[] args) throws InterruptedException, IOException {
        Store store = DbStore.instOf();
        Post post = new Post(1, "Jobbi 003");
        Candidate candidate = new Candidate(0, "Master Java 001", "Grodno");
        User user = new User(4, "Kegla", "test@mail.ru", "pfk");
        store.findAllPosts().stream().forEach(System.out::println);
    }

}
