package ru.job4j.dream.store;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainStore {

    public static void main(String[] args) throws InterruptedException, IOException {
        Store store = DbStore.instOf();
        System.out.println("Проверка методов  save findPostById findAllPosts для Post");
        store.save(new Post(7, "Super Java Job"));
        System.out.println(store.findPostById(7).getName());
        store.save(new Post(7, "Master Java Job"));
        System.out.println(store.findPostById(7).getName());
        System.out.println("__________________________________");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        System.out.println("__________________________________" + System.lineSeparator());
        System.out.println("Проверка методов  save findCandidateById findAllCandidates() для Candidates");
        store.save(new Candidate(2, "Anna"));
        System.out.println(store.findCandidateById(2).getName());
        store.save(new Candidate(2, "Bob"));
        System.out.println(store.findCandidateById(2).getName());
        System.out.println("__________________________________");
        for (Candidate candidate: store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
    }

}
