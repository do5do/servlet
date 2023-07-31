package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemverFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // WEB-INF 내부에 있는 jsp는 외부에서 직접 호출할 수 없다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // controller에서 view로 이동할 때 사용하는 객체
        dispatcher.forward(request, response); // forward는 서버 내부에서 일어나는 호출 (redirect와 차이점)
    }
}
