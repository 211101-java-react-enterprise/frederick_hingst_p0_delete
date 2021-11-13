package hingst.bank.daos;

import hingst.bank.models.AppUser;
import hingst.bank.util.ConnectionMaker;
import hingst.bank.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
public class AppUserDAO implements CrudDAO<AppUser> {

    public AppUser findUserByUsername(String username) {

        try (Connection conn = ConnectionMaker.getInstance().getConnection()) {

            String sql = "select * from app_users where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                AppUser user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public AppUser findUserByEmail(String email) {

        try (Connection conn = ConnectionMaker.getInstance().getConnection()) {

            String sql = "select * from app_users where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                AppUser user = new AppUser();
                user.setId(rs.getString("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
      String username;
       String password;
        public AppUser findUserByUsernameAndPassword(String username, String password){

            try (Connection conn = ConnectionMaker.getInstance().getConnection()) {

                String sql = "select * from app_users where username = ? and password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();


                if (rs.next()) {
                    AppUser user = new AppUser();
                    user.setId(rs.getString("user_id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;

        }


        public AppUser save (AppUser newUser){

            try (Connection conn = ConnectionMaker.getInstance().getConnection()) {

                newUser.setId(UUID.randomUUID().toString());

                String sql = "insert into app_users (user_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, newUser.getId());
                pstmt.setString(2, newUser.getFirstName());
                pstmt.setString(3, newUser.getLastName());
                pstmt.setString(4, newUser.getEmail());
                pstmt.setString(5, newUser.getUsername());
                pstmt.setString(6, newUser.getPassword());

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted != 0) {
                    return newUser;
                }

            } catch (SQLException e) {
                // TODO log this and throw our own custom exception to be caught in the service layer
                e.printStackTrace();

            }

            return null;

        }


        public List<AppUser> findAll() {return null;}


        public AppUser findById(String id){return null;}


        public boolean update(AppUser updatedObj){return false;}


        public boolean removeById(String id){return false;}
    }
