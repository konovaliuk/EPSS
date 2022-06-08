package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    public static IUserDao createUserDao (Connection connection) throws SQLException {
        return new UserDaoImpl(connection);
    }

    public static IDisciplineDao createDisciplineDao (Connection connection) throws SQLException {
        return new DisciplineDaoImpl(connection);
    }

    public static IUserDisciplineDao createUserDisciplineDao (Connection connection) throws SQLException {
        return new UserDisciplineDaoImpl(connection);
    }

    public static IMarksDao createMarksDao (Connection connection) throws SQLException {
        return new MarksDaoImpl(connection);
    }

}
