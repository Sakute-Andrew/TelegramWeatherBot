package org.sakute.telebot.persistance.dao.impl;

import org.hibernate.Session;
import org.sakute.telebot.domain.entities.Admins;
import org.sakute.telebot.persistance.dao.AdminDao;
import org.sakute.telebot.persistance.utility.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

    final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public void createAdmin(Admins admin) {
        try (session) {
            String sqlQuery = "INSERT INTO admins (admin_username, admin_password)" +
                    " VALUES (:username, :pass)";
            session.createNativeQuery(sqlQuery)
                    .setParameter("username", admin.getAdminUsername())
                    .setParameter("pass", admin.getAdminPassword())
                    .executeUpdate();
        } catch (Exception e){

        } finally {
            session.close();
        }

    }

    @Override
    public void updateAdmin(Admins admin) {
        try (session) {
            String sqlQuery = "UPDATE admins SET admin_password = :pass WHERE admin_id = :id";
            session.createNativeQuery(sqlQuery)
                    .setParameter("pass", admin.getAdminPassword())
                    .setParameter("id", admin.getAdminId())
                    .executeUpdate();

        } catch (Exception e){

        } finally {
            session.close();
        }
    }

    @Override
    public void deleteAdmin(int adminId) {
        try (session) {
            String sqlQuery = "DELETE FROM admins WHERE admin_id = :id";
            session.createNativeQuery(sqlQuery)
                    .setParameter("id", adminId)
                    .executeUpdate();
            System.out.println("sdfsdhjf0sdohjf0sdhjf0sdjf0oswdf");
        } catch (Exception e){

        } finally {
            session.close();
        }

    }

}
