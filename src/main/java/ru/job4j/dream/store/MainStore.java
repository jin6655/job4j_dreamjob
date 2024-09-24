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
        Post post = new Post(0, "Jobbi");
        Candidate candidate = new Candidate(0, "Master Java");
        User user = new User(4, "Kegla", "test@mail.ru", "pfk");
        System.out.println(store.findByEmail("testemai@mail.ri"));
    }

}
