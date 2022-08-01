package web;

import pojo.Brand;
import service.Brandservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    Brandservice brandservice = new Brandservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String brandname = request.getParameter("brandname");
        String companyname = request.getParameter("companyname");
      String ordered=  request.getParameter("ordered");
        String description = request.getParameter("description");
      String satus=  request.getParameter("status");
        System.out.println(brandname+""+companyname);
  Brand  brand=new Brand();
  brand.setId(Integer.valueOf(id));
      brand.setBrandName(brandname);
      brand.setCompanyName(companyname);
      brand.setDescription(description);
      brand.setOrdered(Integer.valueOf(ordered));
 brand.setStatus(Integer.valueOf(satus));;
brandservice.update(brand);
 request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
