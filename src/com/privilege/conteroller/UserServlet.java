package com.privilege.conteroller;

import com.privilege.po.User;
import com.privilege.service.UserService;
import com.privilege.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose = request.getParameter("choose");
        switch (choose){
            case "1":
                Login(request,response);//登录
                    break;
            case "2":
                addUser(request,response);//添加
                break;
            case "3":
                updateUser(request,response);//修改
                break;
            case "4":
                selectAllUsers(request,response);//查询
                break;
                default:
                    System.out.println("输入错误！！");
                    break;
        }

    }
    //查询
    private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> list=userService.selectUser();
        HttpSession session=request.getSession();
        session.setAttribute("usersList",list);
        response.sendRedirect("/jsp/users_list.jsp");
    }
    //修改
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int i=userService.updatepwd(username,password);
        if(i>0){
            printWriter.print(1);
        }else {
            printWriter.print(2);
        }
    }
    //添加
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setNickname(request.getParameter("nickname"));
        int i=userService.register(user);
        if(i>0){
            printWriter.print(1);
        }else {
            printWriter.print(2);
        }
    }
    //登录
    private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        //调
        int rows= 0;
        try {
            rows = userService.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rows);
        //存
        session.setAttribute("username",username);
        if(rows>0){
            //转
            request.getRequestDispatcher("/jsp/welcome.jsp").forward(request,response);
        }else{
            response.sendRedirect("/login.jsp");
        }
    }


}
