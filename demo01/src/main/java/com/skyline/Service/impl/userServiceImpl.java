package com.skyline.Service.impl;

import com.skyline.Entity.User;
import com.skyline.Mapper.userMapper;
import com.skyline.Service.userService;
import com.skyline.Util.uploadImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public int updatePssword(User user) {
        System.out.println(user.getUid());
        System.out.println(user.getOldpassword());
        System.out.println(user.getPassword());
        if (user.getUid() != null && user.getOldpassword() != null && user.getPassword() != null) {
            User u = userMapper.selectByAP(user.getAccount(), user.getOldpassword());
            if (u == null) {
                return 0;
            } else {
                return userMapper.updatePassword(user.getPassword(), user.getUid());
            }
        } else {
            return -1;
        }

    }

    @Override
    public User selectByUid(Integer uid) {
        try {
            return userMapper.selectByUid(uid);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**/
    @Override
    public User loginUser(String account, String password) {
        try {
            User user = userMapper.selectByAP(account, password);
            user.setIslogin(1);
            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int checkAccount(String account) {
        try {
            int flag = userMapper.selectByAccount(account);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int updateUser(User u) {
        try {
            u.setIslogin(1);
            if (u.getUserimg() != null) {
                String path = uploadImgUtil.saveBase64Image(u.getUserimg());
                u.setUserimg(path);
            }
            int flag = userMapper.updateUserByUid(u);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int registerUser(User u) {
        try {
            u.setUsername("用户" + u.getAccount());
            u.setIslogin(0);
            System.out.println(22);
            System.out.println(u.getUserimg());
            if (u.getUserimg() != null) {
                String path = uploadImgUtil.saveBase64Image(u.getUserimg());
                System.out.println(path);
                u.setUserimg(path);
            }
            int flag = userMapper.AinsertUser(u);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateLogin(Integer uid) {
        try {
            User user = new User();
            user.setUid(uid);
            user.setIslogin(0);
            userMapper.updateUserByUid(user);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int userNum() {
        int uNum = userMapper.selectUserNum();
        return uNum;
    }

    @Override
    public List<User> selectUser() {
        List<User> uList = userMapper.selectUser();
        return uList;
    }

    @Override
    public List<User> selectUserByAccountId(Integer uid, String account) {
        List<User> uList = userMapper.selectByAccountId(uid, account);
        return uList;
    }

    @Override
    public int delByUid(Integer uid) {
        try {
            int flag = userMapper.deleteByPid(uid);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int deleteUserByUids(List<Integer> uidList) {
        try {
            userMapper.deleteUserByIds(uidList);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public User selectAccountByUid(Integer uid) {
        System.out.println(uid);
        try {
            User user = userMapper.selectAccountByUid(uid);
            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public int insertUser(String account, String password) {
        try {
            userMapper.insertUser(account, password);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("插入用户失败，该用户名已存在！");
            return 0;
        }
    }

    @Override
    public int updatelogin(Integer uid) {
        try {
            userMapper.updatelogin(uid);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
