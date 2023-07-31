package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 { // servlet과 비슷한 모양의 인터페이스를 도입한다.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
