package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        // StreamUtils : spring이 만들어놓은 유틸리티 클래스
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// byte를 string으로 변환할 때는 항상 인코딩 정보를 알려줘야한다. (string -> byte도 마찬가지)
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
