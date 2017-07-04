package module02.daoImpl;

import module02.dao.CompaniesDAO;
import module02.entities.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Optional;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class CompaniesDAOImpl implements CompaniesDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompaniesDAOImpl.class);
    private static final String READ_SQL = "SELECT *FROM companies WHERE COMPANY_NAMES=?";
    private  static final String CREATE_SQL = "INSERT INTO companies(COMPANY_NAMES) VALUES (?)";
    private static final String UPDATE_SQL="UPDATE companies SET COMPANY_NAMES=? WHERE COMPANY_NAMES=?";
    private static final String DELETE_SQL = "DELETE FROM companies WHERE COMPANY_NAMES=?";

    @Override
    public Optional<Company> read(String key) {
        LOGGER.info("Method READ company start work!");
        Company company = null;
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL)) {
                preparedStatement.setString(1, key);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        Optional.empty();
                    }
                    company = new Company();
                    company.setId(resultSet.getInt("ID"));
                    company.setCompanyName(resultSet.getString("COMPANY_NAMES"));
                    System.out.println(company.toString());
                    LOGGER.info("Method READ company end good work!");
                    return Optional.of(company);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception on READ company:  " + e);
        }
        return Optional.empty();
    }

    @Override
    public void create(Company entity) {
        LOGGER.info("Method CREATE start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
                preparedStatement.setString(1,entity.getCompanyName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method CREATE end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on CREATE company method: " +e);
        }
    }

    @Override
    public void update(Company entity, String key) {
        LOGGER.info("Method UPDATE company start work!");
        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
                preparedStatement.setString(1,entity.getCompanyName());
                preparedStatement.setString(2,key);
                preparedStatement.executeUpdate();
                LOGGER.info("Method Update Company end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on UPDATE company method: "+ e);
        }
    }

    @Override
    public void delete(Company entity) {
        LOGGER.info("Method DELETE company start work!");

        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
                preparedStatement.setString(1,entity.getCompanyName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method DELETE on company end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on DELETE company method : "+e);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String login = "root";
        String password = "21031967att";
        return DriverManager.getConnection(url, login, password);
    }
}
