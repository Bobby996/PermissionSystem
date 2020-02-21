package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.commons.collections.set.PredicatedSortedSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/2/8 13:23
 * @Created wenjunpei
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid_str = request.getParameter("cid");
        String currentPage_str = request.getParameter("currentPage");
        String pageSize_str = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");
        int cid = 5;
        if( cid_str != null && cid_str.length() > 0 && !"null".equals(cid_str)) {
            cid = Integer.parseInt(cid_str);
        }
        int currentPage = 1;
        if( currentPage_str != null && currentPage_str.length() > 0) {
            currentPage = Integer.parseInt(currentPage_str);
        }
        int pageSize = 5;
        if( pageSize_str != null && pageSize_str.length() > 0) {
            pageSize = Integer.parseInt(pageSize_str);
        }
        PageBean<Route> pageBean =  routeService.pageQuery(cid,currentPage,pageSize,rname);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),pageBean);
    }
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rid_str = request.getParameter("rid");
        int rid = 1;
        if(rid_str != null && rid_str.length()>0) {
            rid = Integer.parseInt(rid_str);
        }
        Route one = routeService.findOne(rid);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),one);
    }
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rid_str = request.getParameter("rid");
        int rid = 1;
        if(rid_str != null && rid_str.length()>0) {
            rid = Integer.parseInt(rid_str);
        }
        int uid = 0 ;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if( user == null) {
            uid = 0 ;
        }else {
            uid = user.getUid();
        }
        boolean flag = favoriteService.isFavorite(rid,uid);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(flag);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),resultInfo);
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rid_str = request.getParameter("rid");
        int rid = 1;
        if(rid_str != null && rid_str.length()>0) {
            rid = Integer.parseInt(rid_str);
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if( user != null) {
            favoriteService.add(rid,user.getUid());
        }else {

        }
    }
}
