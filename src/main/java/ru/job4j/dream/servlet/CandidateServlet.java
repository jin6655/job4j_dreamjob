package ru.job4j.dream.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Email;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
        req.setAttribute("candidatesForDay", DbStore.instOf().findCandidatesForTheLastDay());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String strName = req.getParameter("name");
        String strCity = req.getParameter("city");
        if (!strName.equals("") && !strCity.contains("Выберите")) {
            System.out.println("Добавляем в базу!");
            DbStore.instOf().save(new Candidate(
                    Integer.parseInt(req.getParameter("id")),
                    strName,
                    strCity
            ));
            System.out.println(strName);
            System.out.println(strCity);
            resp.sendRedirect(req.getContextPath() + "/candidates.do");
        } else {
           resp.sendRedirect(req.getContextPath() + "/candidate/edit.jsp");
        }
    }

}
