package module022.daoImpl;

import module022.dao.ProjectsDAO;
import module022.entities.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Optional;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class ProjectDAOImpl implements ProjectsDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDAOImpl.class);
    private static final String READ_SQL = "SELECT *FROM projectrs WHERE project_NAME=?";
    private static final String CREATE_SQL = "INSERT INTO projectrs(PROJECT_NAME,COST,companies_ID,customers_id) VALUES (?,?,?,?)";
    private static final String UPDATE_SQL = "UPDATE projectrs SET project_NAME=?,COST =?,companies_ID =?,customers_ID=? WHERE project_NAME=?";
    private static final String DELETE_SQL = "DELETE FROM projectrs WHERE project_NAME=?";

    @Override
    public Optional<Project> read(String key) {
        LOGGER.info("Method READ project start work!");
        Project project = null;
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL)) {
                preparedStatement.setString(1, key);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        Optional.empty();
                    }
                    project = new Project();
                    project.setCompanyId(resultSet.getInt("ID"));
                    project.setProjectName(resultSet.getString("PROJECT_NAME"));
                    project.setCost(resultSet.getInt("COST"));
                    project.setCompanyId(resultSet.getInt("companies_ID"));
                    project.setCustumersId(resultSet.getInt("customers_ID"));
                    System.out.println(project.toString());
                    LOGGER.info("Method READ project end good work!");
                    return Optional.of(project);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception on READ project:  " + e);
        }
        return Optional.empty();
    }

    @Override
    public void create(Project entity) {
        LOGGER.info("Method CREATE project start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
                preparedStatement.setString(1,entity.getProjectName());
                preparedStatement.setInt(2,entity.getCost());
                preparedStatement.setInt(3,entity.getCompanyId());
                preparedStatement.setInt(4,entity.getCustumersId());
                preparedStatement.executeUpdate();
                LOGGER.info("Method CREATE project end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on CREATE project method: " +e);
        }
    }

    @Override
    public void update(Project entity, String key) {
        LOGGER.info("Method UPDATE project start work!");
        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
                preparedStatement.setString(1,entity.getProjectName());
                preparedStatement.setInt(2,entity.getCost());
                preparedStatement.setInt(3,entity.getCompanyId());
                preparedStatement.setInt(4,entity.getCustumersId());
                preparedStatement.setString(5,key);
                preparedStatement.executeUpdate();
                LOGGER.info("Method Update Project end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on UPDATE company method: "+ e);
        }
    }

    @Override
    public void delete(Project entity) {
        LOGGER.info("Method DELETE project start work!");

        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
                preparedStatement.setString(1,entity.getProjectName());
                preparedStatement.executeUpdate();
                LOGGER.info("Method DELETE project end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on DELETE project method : "+e);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String login = "root";
        String password = "21031967att";
        return DriverManager.getConnection(url, login, password);
    }
}

