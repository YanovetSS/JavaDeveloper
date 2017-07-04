package module022.daoImpl;

import module022.dao.SkillsDAO;
import module022.entities.Customers;
import module022.entities.Skills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.*;
import java.util.Optional;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class SkillsDAOImpl  implements SkillsDAO{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersDAOImpl.class);
    private static final String READ_SQL = "SELECT *FROM skills WHERE SKILLS_DEVELOPERS=?";
    private static final String CREATE_SQL="INSERT INTO skills(SKILLS_DEVELOPERS) VALUES (?)";
    private static final String UPDATE_SQL="UPDATE skills SET SKILLS_DEVELOPERS=? WHERE SKILLS_DEVELOPERS=?";
    private static final String DELETE_SQL= "DELETE FROM skills WHERE SKILLS_DEVELOPERS=?";
    @Override
    public Optional<Skills> read(String key) {
        LOGGER.info("Method READ Skills start work!");
        Skills skills =null;
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(READ_SQL)) {
                preparedStatement.setString(1, key);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    skills=new Skills();
                    while (resultSet.next()){
                        skills.setSkillDeveloper(resultSet.getString("SKILLS_DEVELOPERS"));
                        System.out.println(skills.toString());
                    }
                    return Optional.of(skills);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method READ skills :" + e);
        }
        return Optional.empty();
    }

    @Override
    public void create(Skills entity) {
        LOGGER.info("MEthod CREATE project start work!");
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)){
                preparedStatement.setString(1,entity.getSkillDeveloper());
                preparedStatement.executeUpdate();
                LOGGER.info("Method CREATE on project end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on method CREATE project: "+e);
        }
    }

    @Override
    public void update(Skills entity, String key) {
        LOGGER.info("Method UPDATE project start work!");
        try(Connection connection =getConnection()){
            try(PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_SQL)){
                preparedStatement.setString(1,entity.getSkillDeveloper());
                preparedStatement.setString(2,key);
                preparedStatement.executeUpdate();
                LOGGER.info("Method UPDATE end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exception on UPDATE project: "+e);
        }
    }

    @Override
    public void delete(Skills entity) {
        LOGGER.info("Method DELETE project start work");
        try(Connection connection = getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
                preparedStatement.setString(1,entity.getSkillDeveloper());
                preparedStatement.executeUpdate();
                LOGGER.info("Method DELETE project end good work!");
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception on DELETE project: "+e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "21031967att");
    }
}
