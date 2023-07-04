package user_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * A class that does the CRUD operations on the table USER.
 */
public class UserCRUD {
    public static int insertUser(String name, String email, String password){
        ConnectionDB db = new ConnectionDB();
        try{
            Statement statement = db.getConnection().createStatement();
            String sql = "INSERT INTO \"user\"(name, email, password) " +
                    "VALUES ('"+name+"', '"+email+"', '"+password+"')";
            return statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static User findUserById(int id){
        ConnectionDB db = new ConnectionDB();
        try{
            Statement statement = db.getConnection().createStatement();
            String sql = "SELECT * FROM \"user\" WHERE id = "+id;
            ResultSet result = statement.executeQuery(sql);

            if(result.next()){
                return new User(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static List<User> findAllUsers(){
        return null;
    }

    public static int deleteById(int id){
        return 0;
    }

    public static int updateUser(int id, String newName, String newEmail, String newPassword){
        return 0;
    }

    public static void main(String[] args) {
        UserCRUD.findUserById(1);
    }
}
