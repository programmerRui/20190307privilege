package com.privilege.conteroller;

import com.privilege.po.User;
import com.privilege.service.UserService;
import com.privilege.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/checkUserServlet.do")
public class checkUserServlet extends HttpServlet {
    private UserService user=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter=response.getWriter();
        String username = request.getParameter("checkname");
        List<User> users=user.checkusername(username);
        if(users.size()==0){
            printWriter.print(1);
            //printWriter.print("该账号未被注册，可以使用");
        }else{
            printWriter.print(2);
            //printWriter.print("该账号已被注册，请更换注册名");
        }
        printWriter.flush();
        printWriter.close();
    }
}
