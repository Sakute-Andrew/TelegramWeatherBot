package org.sakute;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.sakute.entities.BlackListedUsers;
import org.sakute.entities.Users;
import org.sakute.persistance.dao.BlackListedUsersDao;
import org.sakute.persistance.dao.impl.BlackListedUsersDaoImpl;

public class Main {

  public static void main(String[] args) {


    BlackListedUsersDao dao = new BlackListedUsersDaoImpl();
     dao.deleteUserFromBlacklist(10);



  }
}