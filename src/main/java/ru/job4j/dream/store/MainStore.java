package ru.job4j.dream.store;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainStore {

    public static void main(String[] args) throws InterruptedException, IOException {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Jobbi");
        Candidate candidate = new Candidate(0, "Master Java");
        store.save(post);
        store.save(candidate);
    }

}
