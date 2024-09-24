package ru.job4j.dream.servlet;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeletPhotoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        File folder = new File("c:\\images\\");
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                if (id.equals(file.getName().split("\\.")[0])) {
                    file.delete();
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }

}
