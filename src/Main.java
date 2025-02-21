import java.sql.*;

import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        //          Connection con =DriverManager.getConnection(HotelReservationSystem.url, HotelReservationSystem.username, HotelReservationSystem.password);


        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username= "root";
        String password = "@EnterYourMysqlPassword";
//        String query ="select * from employess";
//        String query ="insert into employess(Id,name,job_title,salary) values (4,'Aditya','React Developer',8000.5)";
        String query = "delete from employess where Id=3";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Divers loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
            int rowseffected = stmt.executeUpdate(query);
            if (rowseffected>0){
//                System.out.println("Insert successful " + rowseffected + "rows affected");
                System.out.println("Deletion successful " + rowseffected + "rows affected");
            }else {
                System.out.println("Deletion failed");
            }
//            while (rs.next()){
//                int id = rs.getInt("Id");
//                String name = rs.getString("name");
//                String job_title = rs.getString("job_title");
//                double salary = rs.getDouble("salary");
//                System.out.println();
//                System.out.println("==============================");
//                System.out.println("ID " + id);
//                System.out.println("Name " + name);
//                System.out.println("Job Title " + job_title);
//                System.out.println("Salary " + salary);
//            }
            con.close();
            stmt.close();
//            rs.close();
            System.out.println();
            System.out.println("Connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
