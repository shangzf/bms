package com.rimi.bms.servlet;

import com.rimi.bms.service.ILoginService;
import com.rimi.bms.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author shangzf
 * @date 2019/9/20 16:46
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private ILoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码
        request.setCharacterEncoding("UTF-8");
        // 获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用service中的方法
        boolean login = loginService.login(username, password);
        // 如果请求成功显示[成功],否则[失败]
        String result = login ? "成功" : "失败";
        // 设置响应的正文类型
        response.setContentType("text/html;charset=utf8");
        // 把结果输出
        response.getWriter().print(result);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
