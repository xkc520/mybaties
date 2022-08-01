package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 HttpServletRequest req=(HttpServletRequest) request;
 String []url={"/login.jsp","/imgs/","/css/","/login","register.jsp","/register"};
        String requestURI = req.getRequestURI();
        for (String u:url){
            if (requestURI.contains(u)){
                chain.doFilter(request,response);
           return;
            }
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user!=null){
            chain.doFilter(request,response);
        }else {
          req.setAttribute("error","你还没有登陆");
          req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
