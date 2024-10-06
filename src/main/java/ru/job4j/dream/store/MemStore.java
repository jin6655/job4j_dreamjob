package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {

    private static final MemStore INST = new MemStore();

    private static AtomicInteger POST_ID = new AtomicInteger(4);

    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private static AtomicInteger User_ID = new AtomicInteger(4);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private final Map<Integer, String> cities = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Junior Java", "Mocsow"));
        candidates.put(2, new Candidate(2, "Middle Java", "Gradn"));
        candidates.put(3, new Candidate(3, "Senior Java", "Lvov"));
        users.put(1, new User(1, "Anna", "roll@mail.ru", "password01"));
        users.put(2, new User(2, "Bob", "azbuk@mail.ru", "password02"));
        users.put(3, new User(3, "Marli", "chename@mail.ru", "password03"));
        cities.put(1, "Moscow");
        cities.put(2, "Orsha");
        cities.put(3, "Orel");
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public Collection<String> findAllCities() {return cities.values();}

    @Override
    public Collection<Post> findPostsForTheLastDay() {
        return null;
    }

    @Override
    public Collection<Candidate> findCandidatesForTheLastDay() {
        return null;
    }

    @Override
    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }


    @Override
    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(User_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public User findByEmail(String email) {
        for (Map.Entry<Integer, User> user : users.entrySet()) {
            if (user.getValue().getEmail().equals(email)) {
                return user.getValue();
            }
        }
        return null;
    }

}
