package com.fbaron.user.data;

import com.fbaron.user.business.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Ferney Estupinan Baron
 * @since 2/13/2024
 */
public class UserDAO {

    Map<String, String> envVariables = System.getenv();

    public UserDAO() {
        initializeDatabase();
    }

    public Connection getConnection() {
        String url = envVariables.get("JDBC_URL");
        String username = envVariables.get("JDBC_USERNAME");
        String password = envVariables.get("JDBC_PASSWORD");
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeDatabase() {
        Connection connection = null;
        PreparedStatement statement = null;
        System.out.println("Initializing database...");
        String query = """
                CREATE TABLE IF NOT EXISTS user
                (id BIGINT AUTO_INCREMENT PRIMARY KEY,
                username VARCHAR(100) NOT NULL,
                password VARCHAR(100) NOT NULL,
                UNIQUE KEY user_UN (username))
                """;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public User insert(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO user (username, password) VALUES (?, ?)";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "SELECT * FROM user";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = mapResultSetToUser(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Optional<User> selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "SELECT * FROM user WHERE id = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.empty();
    }

    public Optional<User> selectByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "SELECT * FROM user WHERE username = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.empty();
    }

    public User update(int id, User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "UPDATE user SET password = ? WHERE id = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getPassword());
            statement.setInt(2, id);
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "DELETE FROM user WHERE id = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
