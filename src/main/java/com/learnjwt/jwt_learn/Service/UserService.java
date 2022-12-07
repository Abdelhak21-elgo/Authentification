package com.learnjwt.jwt_learn.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnjwt.jwt_learn.Dao.RoleDao;
import com.learnjwt.jwt_learn.Dao.UserDao;
import com.learnjwt.jwt_learn.Entity.Role;
import com.learnjwt.jwt_learn.Entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){
        return userdao.save(user);
    }

    public void initRoleandUser(){

        // Admin Role
        Role adminRole = new Role();
        adminRole.setRolename("Admin");
        adminRole.setRoleDescription("Admin fro administration");
        roleDao.save(adminRole);

        // User Role
        Role userRole = new Role();
        userRole.setRolename("User");
        userRole.setRoleDescription("default role for new User");
        roleDao.save(userRole);

        // admin registration
        User adminUser= new User();
        adminUser.setUsrFirstName("Admin");
        adminUser.setUserLastName("Admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userdao.save(adminUser);
        

        // user regestration 
        User user= new User();
        user.setUsrFirstName("User");
        user.setUserLastName("User");
        user.setUserName("user123");
        user.setUserPassword("user@pass");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userdao.save(user);
        

    }
}
