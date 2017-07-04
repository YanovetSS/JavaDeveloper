package module02.daoImpl;

import module02.dao.CustomersDAO;
import module02.entities.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;
import java.util.Optional;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class CustomersDAOImpl implements CustomersDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersDAOImpl.class);
    private static final String READ_SQL = "SELECT *FROM customers WHERE CUSTOMERS_NAME=?";
    private static final String CREATE_SQL="INSERT INTO customers(CUSTOMERS_NAME) VALUES (?)";
    private static final String UPDATE_SQL="UPDATE customers SET CUSTOMERS_NAME=? WHERE CUSTOMERS_NAME=?";
    private static final String DELETE_SQL= "DELETE FROM customers WHERE CUSTOMERS_NAME=?";

    @Override
    public Optional<Customers> read(String key) {
        LOGGER.info("Method READ Customers start work!");
        Customers customers = null;
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL)) {
                preparedStatement.setString(1, key);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        Optional.empty();
                    }
                    customers = new Customers();
                    customers.setId(resultSet.getInt("ID"));
                    customers.setCustumerName(resultSet.getString("CUSTOMERS_NAME"));
                    LOGGER.info("Method READ customers end good work!");
                    System.out.println(customers.toString());
                    return Optional.of(customers);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method READ custumers :" + e);
        }
        return Optional.empty();
    }

    @Override
    public void create(Customers entity) {
        LOGGER.info("MEthod CREATE customers start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)){
                preparedStatement.setString(1,entity.getCustumerName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method CREATE on customers end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method CREATE customers: "+e);
        }
    }

    @Override
    public void update(Customers entity, String key) {
        LOGGER.info("Method UPDATE customers start work!");
        try(Connection connection =getConnection()){
            try(PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_SQL)){
                preparedStatement.setString(1,entity.getCustumerName());
                preparedStatement.setString(2,key);
                preparedStatement.executeUpdate();
                LOGGER.info("Method UPDATE end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on UPDATE customers: "+e);
        }
    }

    @Override
    public void delete(Customers entity) {
        LOGGER.info("Method DELETE Customers start work");
        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
                preparedStatement.setString(1,entity.getCustumerName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method DELETE customers end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception on DELETE customers: "+e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "21031967att");
    }
}
