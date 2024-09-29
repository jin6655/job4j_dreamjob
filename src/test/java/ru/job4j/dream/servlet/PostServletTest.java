package ru.job4j.dream.servlet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostServletTest {

    @Test
    public void whenCreatePost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("3");
        when(req.getParameter("name")).thenReturn("name of new post");
        new PostServlet().doPost(req, resp);
        Post post = DbStore.instOf().findPostById(3);
        assertThat(post, notNullValue());
    }

    @Test
    public void whenFindAllPosts() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        int start = DbStore.instOf().findAllPosts().size();
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("newPost");
        new PostServlet().doPost(req, resp);
        MatcherAssert.assertThat(DbStore.instOf().findAllPosts().size(), Matchers.is(start + 1));
    }

    @Test
    public void wnenFindPostByIdAndUpdatePost() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        String namePost = new StringBuilder().append("newPost").append(new Random().nextInt(1000)).toString();
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn(namePost);
        new PostServlet().doPost(req, resp);
        MatcherAssert.assertThat(
                namePost,
                Matchers.is(DbStore.instOf().findPostById(1).getName())
        );
    }

}