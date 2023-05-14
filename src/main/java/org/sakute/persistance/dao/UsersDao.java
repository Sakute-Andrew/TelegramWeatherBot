package org.sakute.persistance.dao;

import java.util.List;
import org.sakute.entities.Users;

public interface UsersDao {

    public abstract List<Users> getAllUsers();
    public abstract void addUser(Users user);
    public abstract void updateUser(Users user);
    public abstract void deleteUser(int userId);


}
