package ru.job4j.dream.servlet;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.internal.matchers.NotNull;
import ru.job4j.dream.model.Candidate;
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

public class CandidateServletTest {

    @Test
    public void FindAllCandidatesandCreateNewCandidate() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        int sizeStart = DbStore.instOf().findAllCandidates().size();
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("newCandidate");
        new CandidateServlet().doPost(req, resp);
        MatcherAssert.assertThat(
                DbStore.instOf().findAllCandidates().size(),
                Matchers.is(sizeStart + 1)
        );
    }

    @Test
    public void FindCandidateByIdAndUpdateCandidate() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        String nameCandidate = new StringBuilder().append("newCandidate").append(new Random().nextInt(1000)).toString();
        when(req.getParameter("id")).thenReturn("4");
        when(req.getParameter("name")).thenReturn(nameCandidate);
        new CandidateServlet().doPost(req, resp);
        MatcherAssert.assertThat(
                DbStore.instOf().findCandidateById(4).getName(),
                Matchers.is(nameCandidate)
        );
    }

}