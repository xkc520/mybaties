package web;

import pojo.Brand;
import service.Brandservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {
    Brandservice brandservice = new Brandservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        Brand brand = brandservice.selectByid(Integer.valueOf(id));
        System.out.println(brand);
        brandservice.delete(brand);
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
