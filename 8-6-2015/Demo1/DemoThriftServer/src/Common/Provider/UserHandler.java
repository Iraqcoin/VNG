/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common.Provider;

import Common.ThriftInterface.User;
import Common.ThriftInterface.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;

/**
 *
 * @author HoaiBao
 */
public class UserHandler implements UserService.Iface {

    @Override
    public User GetUser(String username) throws TException {
        User user = new User();
        Connection conn = ConnectionProvider.Connect();
        try {
            String sql = "Select * from users where username=?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, username);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                user = new User();
                user.setId(res.getInt(1));
                user.setUsername(res.getString(2));
                user.setPassword(res.getString(3));
                user.setVisitor(res.getInt(4));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return user;
    }

    @Override
    public int UpdateVisitor(String username) throws TException {
        int n = -1;
        User u = Increase(username);
        Connection con = ConnectionProvider.Connect();
        try {
            String sql = "Update users set username=? , passwd=? , visitor=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getVisitor());
            pst.setInt(4, u.getId());
            n = pst.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return n;
    }

    @Override
    public User Increase(String username) throws TException {
        User u = GetUser(username);
        u.setVisitor(u.getVisitor() + 1);
        return u;
    }

    @Override
    public boolean CheckLogin(String username, String pword) throws TException {
        boolean check = false;
        Connection conn = ConnectionProvider.Connect();
        try {
            String sql = "Select id from users where username=? and passwd=?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, username);
            pre.setString(2, pword);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                check = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return check;
    }

}
