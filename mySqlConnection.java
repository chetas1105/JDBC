import javax.lang.model.element.Name;
import java.sql.*;
import java.util.Scanner;

public class mySqlConnection {

    public static void main(String[] args) {
            //here combact is database name, root is username and password
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Combat Club database ");
            int choice=0;
            do {
                System.out.println();
                System.out.println("1.Insert");
                System.out.println("2.Update");
                System.out.println("3.Delete");
                System.out.println("4.Display");
                System.out.println("Enter the Operation you want to perform : ");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        //Inserting data
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/combact", "root", "Chetas@11");
                            System.out.println("Inserting records into the table...");
                            System.out.println("Enter the Id :");
                            int id = sc.nextInt();
                            System.out.println("Enter the Name :");
                            String name = sc1.nextLine();
                            System.out.println("Enter the Fees :");
                            int fees = sc.nextInt();
                            String sql = "insert into structure (id,name,fees) values (?,?,?)";
                            PreparedStatement pstmt = con.prepareStatement(sql);
                            pstmt.setInt(1,id);
                            pstmt.setString(2, name);
                            pstmt.setInt(3,fees);
                            pstmt.execute();
//                            pstmt.executeUpdate(sql);
                        }catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        //Updating existing data
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/combact", "root", "Chetas@11");
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("Select * from structure");
                            System.out.println("Updating records into the table...");
                            System.out.println("Data Sheet :");
                            System.out.println();
                            System.out.println("Id   Name   Fees");
                            while(rs.next()){
                                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                            }
                            System.out.print("Enter Id to be updated");
                            int id = sc.nextInt();
                            System.out.println();
                            System.out.print("Edit Name : ");
                            String name = sc1.nextLine();
                            System.out.println();
                            System.out.print("Edit fees : ");
                            int fees = sc.nextInt();
                            System.out.println();
                            String sql = "Update structure set name=?,fees=? where id=?";
                            PreparedStatement pstmt = con.prepareStatement(sql);
                            pstmt.setString(1,name);
                            pstmt.setInt(2,fees);
                            pstmt.setInt(3,id);
                            pstmt.execute();
//                            pstmt.executeQuery(sql);
                            pstmt.close();
                            con.close();
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        //deleting data
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/combact", "root", "Chetas@11");
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("Select * from structure");
                            System.out.println("Deleting records into the table...");
                            System.out.println("Data Sheet :");
                            System.out.println();
                            System.out.println("Id   Name   Fees");
                            while(rs.next()){
                                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                            }
                            System.out.print("Enter Id to be Deleted");
                            int id = sc.nextInt();
                            System.out.println();
                            String sql = "Delete from structure where id=?";
                            PreparedStatement pstmt = con.prepareStatement(sql);
                            pstmt.setInt(1,id);
                            pstmt.execute();
                            pstmt.close();
                            con.close();
//                            pstmt.executeQuery(sql);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        //Fetching displaying data
                        try{
                            System.out.println("Combat Database ");
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/combact", "root", "Chetas@11");
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("Select * from structure");
                            System.out.println("Data Sheet :");
                            System.out.println();
                            System.out.println("Id   Name   Fees");
                            while(rs.next()){
                                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        System.exit(0);
                        break;
                }

            }while (choice!=5);
    }
    }


