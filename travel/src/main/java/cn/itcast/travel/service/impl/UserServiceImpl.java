package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;


public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public boolean register(User user) {
        User u = userDao.findByUsername(user.getUsername());
        if(u == null) {
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            userDao.save(user);
            String text = "<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击链接，激活黑马旅游网</a>";
            MailUtils.sendMail(user.getEmail(),text,"激活邮件");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean active(String code) {
        User u = userDao.findByCode(code);
        if(u != null) {
            userDao.updateStatus(u);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        User u = userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        return u;
    }


}
