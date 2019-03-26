package com.privilege.conteroller;

import com.privilege.dao.RolesDao;
import com.privilege.dao.impl.RolesDaoImpl;
import com.privilege.po.Privileges;
import com.privilege.po.Roles;
import com.privilege.po.User;
import com.privilege.service.PrivilegeService;
import com.privilege.service.RolesService;
import com.privilege.service.UserService;
import com.privilege.service.impl.PrivilegeServiceImpl;
import com.privilege.service.impl.RolesServiceImpl;
import com.privilege.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RolesServlet.do")
public class RolesServlet extends HttpServlet {
    private RolesService rolesService=new RolesServiceImpl();
    private PrivilegeService privilegeService=new PrivilegeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String choose=request.getParameter("choose");
       switch (choose){
           case "1":
               selectRolesList(request,response);
               break;
           case "2":
               selectprivilege(request,response);
               break;
           case "3":
               addRoles(request,response);
               break;
           case "4":
               rolesUsers(request,response);//授权
               break;
           case "5":
               updatetoRoles(request,response);//授权
               break;
               default:
                   System.out.println("操作有误");
                   break;
       }

    }

    private void updatetoRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();
        int userid = Integer.parseInt(request.getParameter("userid"));
        int delrow=0;
        int addrow=0;
        String[] rolesdeles = request.getParameter("rolesdeles").split(",");
        String[] rolesadds = request.getParameter("rolesadds").split(",");
        if(rolesdeles.length!=0) {
            delrow = rolesService.deleteRolesByRoleid(rolesdeles, userid);
        }
        if(rolesadds.length!=0){
            addrow=rolesService.addRolesByRoleid(rolesadds,userid);
        }
        if(addrow>0||delrow>0){
            printWriter.print(1);
        }else{
            printWriter.print(0);
        }
    }

    //授角
    private void rolesUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        HttpSession session=request.getSession();
        List<Roles> rolesList=rolesService.getRolesList(userid);
        List<Roles> roleList=rolesService.getRoleList(userid);
        session.setAttribute("userid",userid);
        session.setAttribute("username",username);
        session.setAttribute("rolesList",rolesList);
        session.setAttribute("roleList",roleList);
        response.sendRedirect("/jsp/grant_roles.jsp");

    }

    private void addRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        RolesService add=new RolesServiceImpl();
        int i=add.addRoles(name,description);
        if(i>0){
            response.sendRedirect("/RolesServlet.do?choose=1");
        }
    }

    //调用查询权限方法
    private void selectprivilege(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收角色名称
        String rolename = request.getParameter("rolename");
        int roleid = Integer.parseInt(request.getParameter("roleid"));
        //调用根据roleid查询已经具备权限的方法
       HttpSession session=request.getSession();
        List<Privileges>  privilegesesById=privilegeService.getPrivilegeList(roleid);
        List<Privileges>  privilegesesList=privilegeService.getPrivilegesList(roleid);
        session.setAttribute("roleid",roleid);
        session.setAttribute("rolename",rolename);
        session.setAttribute("privilegesesById",privilegesesById);
        session.setAttribute("privilegesesList",privilegesesList);
        response.sendRedirect("/jsp/grant_privilege.jsp");
    }
    //
    private void selectRolesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询角色
        List<Roles> rolesList=rolesService.selectRoles();
        //存
        HttpSession session=request.getSession();
        session.setAttribute("rolesList",rolesList);
        //转
        request.getRequestDispatcher("/jsp/roles_list.jsp").forward(request,response);
    }
}
