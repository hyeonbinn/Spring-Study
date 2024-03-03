package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; //myLogger를 주입 받는 게 아닌, 찾을 수 있는 ObjectProvider가 주입 되는 것.

    @RequestMapping("log-demo") //이런 요청이 오면
    @ResponseBody //뷰 템플렛이 없기에 문자 그대로 응답 보내도록
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject(); //ObjectProvider의 getObject를 통해 myLogger를 조회
        myLogger.setRequestUrl(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
