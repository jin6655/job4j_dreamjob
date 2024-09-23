package ru.job4j.dream.store;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DbStoreTest {

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenCreateCandidat() {
        Store  store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Min");
        store.save(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), Matchers.is(candidate.getName()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post post02 = new Post(1, "Opus");
        String expected = post02.getName();
        store.save(post02);
        Post postInDb = store.findPostById(1);
        assertThat(postInDb.getName(), Matchers.is(expected));
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate can = new Candidate(0, "Anna");
        store.save(can);
        Candidate can02 = new Candidate(1, "Alli");
        String expected = can02.getName();
        store.save(can02);
        Candidate candidateInDb = store.findCandidateById(1);
        assertThat(candidateInDb.getName(), Matchers.is(expected));
    }

    @Test
    public void whenFindAllPosts() {
        Store store = DbStore.instOf();
        List<Post> list = (List<Post>) store.findAllPosts();
        Post post = new Post(0, "Java Job");
        list.add(post);
        store.save(post);
        assertThat(store.findAllPosts().size(), Matchers.is(list.size()));
    }

    @Test
    public void whenFindAllCandidates() {
        Store store = DbStore.instOf();
        List<Candidate> list = (List<Candidate>) store.findAllCandidates();
        Candidate can = new Candidate(0, "Anna");
        list.add(can);
        store.save(can);
        assertThat(store.findAllCandidates().size(), Matchers.is(list.size()));
    }

}