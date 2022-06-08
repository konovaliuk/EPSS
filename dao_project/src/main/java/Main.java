import connection.ConnectionPool;
import dao.*;
import entities.Discipline;
import entities.Marks;
import entities.User;
import entities.UserDiscipline;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String arg[]){

        System.out.println("\n");
        testUserDao();
        System.out.println("\n");
        testDisciplineDao();
        System.out.println("\n");
        testUserDisciplineDao();
        System.out.println("\n");
        testMarksDao();
    }


//------------------------------------start of UserDaoTesting---------------------------------------------------------

    private static void testUserDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------UserDao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IUserDao userDao = DaoFactory.createUserDao(conn);

            System.out.println("Find ALl---");
            printAll(userDao.findAll());

            System.out.println("Find by id---");
            System.out.println(userDao.findById(1).toString());

            System.out.println("save---");
            User user1 = new User("andyuyube@gmail.com", "aapas321word", "student", "aan312ame", "aasur312name");
            userDao.save(user1);


            System.out.println("update---");
            userDao.update(17, user1 );

            System.out.println("delete---");
            userDao.delete(28);
            printAll(userDao.findAll());

            pool.returnConnection(conn);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of UserDaoTesting---------------------------------------------------------

//-------------------------------------start of DisciplineDaoTesting---------------------------------------------------------

    private static void testDisciplineDao(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String dbUrl = resource.getString("dbUrl");
        String dbUser = resource.getString("dbUser");
        String dbPassword = resource.getString("dbPassword");
        System.out.println("--------------------------------------Discipline Dao testing-----------------------------------------------------------");
        Connection conn;
        ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
        try{
            conn = pool.getConnection();
            IDisciplineDao disciplineDao = DaoFactory.createDisciplineDao(conn);

            System.out.println("Find ALl---");
            printAll(disciplineDao.findAll());

            System.out.println("Find by id---");
            System.out.println(disciplineDao.findById(1).toString());

            System.out.println("save---");
            Discipline discipline1 = new Discipline("iq");
            disciplineDao.save(discipline1);


            System.out.println("update---");
            disciplineDao.update(6, discipline1 );

            System.out.println("delete---");
            disciplineDao.delete(13);
            printAll(disciplineDao.findAll());
            pool.returnConnection(conn);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//------------------------------------end of DisciplineDaoTesting---------------------------------------------------------

//-------------------------------------start of UserDisciplineDaoTesting---------------------------------------------------------
    private static void testUserDisciplineDao(){
    ResourceBundle resource = ResourceBundle.getBundle("database");
    String dbUrl = resource.getString("dbUrl");
    String dbUser = resource.getString("dbUser");
    String dbPassword = resource.getString("dbPassword");
    System.out.println("--------------------------------------UserDiscipline Dao testing-----------------------------------------------------------");
    Connection conn;
    ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
    try{
        conn = pool.getConnection();
        IUserDisciplineDao userDisciplineDao = DaoFactory.createUserDisciplineDao(conn);

      System.out.println("\n Find ALl---");
        printAll(userDisciplineDao.findAll());
        System.out.println("\n Find ALl NO DIGITS---");
        printAll(userDisciplineDao.findAllNoDigits());
        System.out.println("\n Find ALl USERS DISCIPLINES---");
        printAll(userDisciplineDao.findAllUserDisciplines(16));
        System.out.println("\n Find ALl DISCIPLINE USERS---");
        printAll(userDisciplineDao.findAllDisciplineUsers(1));
        System.out.println("\n Find BY ID---");
        printAll(userDisciplineDao.findById(5));
        System.out.println("\n Find BY ID NO DIGITS---");
        printAll(userDisciplineDao.findByIdNoDigits(5));
        System.out.println("\n save---");
        UserDiscipline userDiscipline = new UserDiscipline(17, 1);
        userDisciplineDao.save(userDiscipline);
        System.out.println("\n update---");
        userDisciplineDao.update(6, userDiscipline );


        System.out.println("delete---");
        userDisciplineDao.delete(7);
        printAll(userDisciplineDao.findAll());
        pool.returnConnection(conn);

    } catch (SQLException e){
        e.printStackTrace();
    }
}
//-------------------------------------end of UserDisciplineDaoTesting---------------------------------------------------------

//-------------------------------------start of MarksDaoTesting---------------------------------------------------------
private static void testMarksDao() {
    ResourceBundle resource = ResourceBundle.getBundle("database");
    String dbUrl = resource.getString("dbUrl");
    String dbUser = resource.getString("dbUser");
    String dbPassword = resource.getString("dbPassword");
    System.out.println("--------------------------------------Marks Dao testing-----------------------------------------------------------");
    Connection conn;
    ConnectionPool pool =new ConnectionPool(dbUrl, dbUser, dbPassword, 10);
    try{
        conn = pool.getConnection();
        IMarksDao MarksDao = DaoFactory.createMarksDao(conn);
        System.out.println("\n Find ALl---");
        printAll(MarksDao.findAll());
        System.out.println("\n Find ALl NO DIGITS---");
        printAll(MarksDao.findAllNoDigits());
        System.out.println("\n Find ALl USER MARKS---");
        printAll(MarksDao.findAllUserMarks(1));
        System.out.println("\n Find ALl DISCIPLINE MARKS---");
        printAll(MarksDao.findAllDisciplineMarks(9));
        System.out.println("\n Find BY ID---");
        printAll(MarksDao.findById(2));
        System.out.println("\n Find BY ID NO DIGITS---");
        printAll(MarksDao.findByIdNoDigits(2));
        System.out.println("\n save---");
        Marks mark = new Marks(10, "homework", "gj", 16, 1, 9);
        MarksDao.save(mark);
        System.out.println("\n update---");
        MarksDao.update(3, mark );
        System.out.println("delete---");
        MarksDao.delete(2);
        printAll(MarksDao.findAll());
        pool.returnConnection(conn);

    } catch (SQLException e){
        e.printStackTrace();
    }
}
//-------------------------------------end of MarksDaoTesting---------------------------------------------------------


    private static void printAll(List resultList){
        resultList.forEach((result) -> {
            System.out.println(result.toString());
        });

    }


}

