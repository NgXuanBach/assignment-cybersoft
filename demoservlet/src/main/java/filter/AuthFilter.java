package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPatterns: khi người dùng gọi link được quy định trong url pattens thì
// filter sẽ được kích hoạt
@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//      Nơi quy dịnh rule
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (!req.getServletPath().startsWith("/login")) {
            if (req.getSession().getAttribute("user") != null) {
                //Cho phép đi vào link mà người dùng request
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            //Cho phép đi vào link mà người dùng request
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
