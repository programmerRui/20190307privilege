package com.privilege.conteroller;

import com.privilege.dao.PrivilegesDao;
import com.privilege.dao.impl.PrivilegesDaoImpl;
import com.privilege.po.Privileges;
import com.privilege.service.PrivilegeService;
import com.privilege.service.impl.PrivilegeServiceImpl;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PrivilegsServlet.do")
public class PrivilegsServlet extends HttpServlet {
    private PrivilegeService privilegeService=new PrivilegeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取
        String choose = request.getParameter("choose");
        switch (choose){
            case "1":
                toPrivilege(request,response);
                break;
            case "2":
                addPrivilege(request,response);
                break;
            case "3":
                selectPrivilege(request,response);
                break;
                default:
                    System.out.println("");
                    break;
        }


    }

    private void selectPrivilege(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //调用
        List<Privileges> list=privilegeService.getALLPrivilegeList();
        HttpSession session= request.getSession();
        session.setAttribute("PrivilegesList",list);
        response.sendRedirect("/jsp/privilege_list.jsp");
//        request.setAttribute("PrivilegesList",list);
//        request.getRequestDispatcher("/jsp/privilege_list.jsp").forward(request,response);
       // response.sendRedirect("/jsp/privilege_list.jsp");
    }

    private void addPrivilege(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String p_name = request.getParameter("p_name");
        String p_url = request.getParameter("p_url");
        String p_description = request.getParameter("p_description");
        Privileges privileges = new Privileges(0, p_name, p_url, p_description);
        int rows=privilegeService.addPrivilege(privileges);
        if(rows>0){
            //跳转到查看页面
            response.sendRedirect("/PrivilegsServlet.do?choose=3");
        }
    }

    private void toPrivilege(HttpServletRequest request, HttpServletResponse response) {
        String roleid = request.getParameter("roleid");
        String[] privilegedeleteid= request.getParameter("privilegedeleteid").split(",");
        String[] privilegeaddid=request.getParameter("privilegeaddid").split(",");
        //调
        int derows=0;
        int addrows=0;
        if(privilegedeleteid.length!=0){
            derows=privilegeService.deletePrivilegesByRoleid(privilegedeleteid,Integer.parseInt(roleid));
        }
        if(privilegeaddid.length!=0){
            addrows=privilegeService.addPrivilegesByRoleid(privilegeaddid,Integer.parseInt(roleid));
        }
        PrintWriter a = null;
        try {
             a=response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(derows>0||addrows>0){
           a.write("1");
        }else{
            a.write("0");
        }
    }
}
