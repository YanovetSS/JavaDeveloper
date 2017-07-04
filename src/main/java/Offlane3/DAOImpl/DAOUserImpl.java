package Offlane3.DAOImpl;

import Offlane3.DAOs.DAOUser;
import Offlane3.Entities.User;

import java.sql.*;

/**
 * Created by MakeMeSm1Le- on 12.06.2017.
 */
public class DAOUserImpl implements DAOUser{
    private  static  final  String READ_SQL="select login,password,"+
            "username,REGISTRATION_DATE from users where  login=?";

    @Override
    public void create(User entity) {

    }

    @Override
    public User read(String key) {
        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL);
            preparedStatement.setString(1,key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

        @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","21031967att");
    }
}
