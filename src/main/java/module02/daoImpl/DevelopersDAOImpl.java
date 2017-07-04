package module02.daoImpl;

import module02.dao.DevelopersDAO;
import module02.entities.Developers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;
import java.util.Optional;


/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class DevelopersDAOImpl implements DevelopersDAO {
    private static final String READ_SQL = "SELECT *FROM mydb.developers";
    private static final Logger LOGGER = LoggerFactory.getLogger(DevelopersDAOImpl.class);
    private static final String CREATE_SQL = "INSERT INTO mydb.developers(NAME,SURNAME,salary,projectrs_ID) VALUES (?,?,?,?)";
    private static final String UPDATE_SQL = "UPDATE mydb.developers SET NAME=?,SURNAME=?,salary=?,projectrs_ID=? WHERE NAME=?";
    private static final String DELETE_SQL = "DELETE FROM developers WHERE NAME=?";

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String login = "root";
        String password = "21031967att";
        return DriverManager.getConnection(url, login, password);
    }

    @Override
    public Optional<Developers> read(String key) {
        LOGGER.info("Method READ Developers start work");
        Developers developers = null;
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL)) {
                //preparedStatement.setString(1,key);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        return Optional.empty();
                    }
                    int i=0;
                    developers = new Developers();
                    while (resultSet.next()) {
                        i++;
                        developers.setId(resultSet.getInt("ID"));
                        developers.setName(resultSet.getString("NAME"));
                        developers.setSurName(resultSet.getString("SURNAME"));
                        developers.setSalary(resultSet.getInt("SALARY"));
                        developers.setProjectsId(resultSet.getInt("projectrs_ID"));
                        System.out.println(developers.toString());

                    }
                    LOGGER.info("Method READ Developers end good works!");
                    System.out.println("syshnostey="+i);
                    return Optional.of(developers);
                }
            }

        } catch (SQLException e) {
            LOGGER.info("SQL Exception on method READ Developers: " + e);
        }
        return Optional.empty();
    }

    @Override
    public void create(Developers entity) {
        LOGGER.info("Method create Developers start work");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
                preparedStatement.setString(1, entity.getName());
                preparedStatement.setString(2, entity.getSurName());
                preparedStatement.setInt(3, entity.getSalary());
                preparedStatement.setInt(4, entity.getProjectsId());
                preparedStatement.executeUpdate();
                LOGGER.info("Method CREATE Developers end good works!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method CREATE Developers");
        }
    }

    @Override
    public void update(Developers entity, String key) {
        LOGGER.info("Method update Developers start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
                preparedStatement.setString(1, entity.getName());
                preparedStatement.setString(2, entity.getSurName());
                preparedStatement.setInt(3, entity.getSalary());
                preparedStatement.setInt(4, entity.getProjectsId());
                preparedStatement.setString(5, key);
                preparedStatement.executeUpdate();
                LOGGER.info("Method UPDATE Developers end good works!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method UPDATE Developers");
        }
    }

    @Override
    public void delete(Developers entity) {
        LOGGER.info("Method delete Developers start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
                preparedStatement.setString(1, entity.getName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method DELETE Developers end good works!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on DELETE Developers");
        }
    }
}
