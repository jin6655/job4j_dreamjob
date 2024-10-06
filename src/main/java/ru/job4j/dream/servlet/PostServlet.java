package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.DbStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PostServlet extends HttpServlet {

    private final Store store = DbStore.instOf();

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instOf().findAllPosts());
        req.setAttribute("postsForDay", DbStore.instOf().findPostsForTheLastDay());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("name") != "") {
            DbStore.instOf().save(new Post(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name")
            ));
            resp.sendRedirect(req.getContextPath() + "/posts.do");
        } else {
            resp.sendRedirect(req.getContextPath() + "/post/edit.jsp");
        }
    }

}
