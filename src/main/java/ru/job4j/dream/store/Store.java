package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Post> findPostsForTheLastDay();

    Collection<Candidate> findAllCandidates();

    Collection<Candidate> findCandidatesForTheLastDay();

    Collection<User> findAllUsers();

    Collection<String> findAllCities();

    void save(Post post);

    void save(Candidate candidate);

    void save(User user);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findByEmail(String email);

}
