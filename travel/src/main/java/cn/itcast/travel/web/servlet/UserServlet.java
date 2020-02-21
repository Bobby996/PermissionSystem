package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UserServlet
 * @Description TODO
 * @Date 2020/2/7 21:39
 * @Created by Bobby
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(checkcode_server == null||!checkcode_server.equalsIgnoreCase(check)) {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(resultInfo);
            response.getWriter().write(s);
            return ;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = userService.register(user);
        ResultInfo resultInfo = new ResultInfo();
        if(flag) {
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(resultInfo);
        response.getWriter().write(s);
    }

    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        ResultInfo resultInfo = new ResultInfo();
        if(checkcode_server == null ||!checkcode_server.equalsIgnoreCase(check)) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(resultInfo);
            response.getWriter().write(s);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User u = userService.login(user);
        if( u == null) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误");
        }
        if( u != null && "N".equals(u.getStatus())) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户尚未激活");
        }
        if( u != null && "Y".equals(u.getStatus())) {
            resultInfo.setFlag(true);
        }
        session.setAttribute("user",u);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(resultInfo);
        response.getWriter().write(s);
    }

    public void findOne(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        if(user != null) {
            map.put("flag",true);
            map.put("msg",user.getName());
        }else {
            map.put("flag",false);
            map.put("msg","您尚未登陆");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),map);
    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    public void active(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        if(code == null || code.length() == 0) {
            return;
        }
        boolean flag = userService.active(code);
        if(flag) {
            response.getWriter().write("<a href='login.html'>激活成功</a>");
        }else {
            response.getWriter().write("激活失败,请联系管理员");
        }
    }
}
