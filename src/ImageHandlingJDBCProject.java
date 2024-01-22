import java.io.*;
import java.sql.*;
public class ImageHandlingJDBCProject{
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password ="Vinita@123";
        String folder_path = "C:\\Users\\USER\\Pictures\\";
        String query = "Select image_data from image_table where image_id = (?)";


        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded succesfully ");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection establish successfully");
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
               byte[] image_data = resultSet.getBytes("image_data");
               String image_path = folder_path + "extractedImage.jpg";
                OutputStream outputStream = new FileOutputStream(image_path);
                outputStream.write(image_data);
            }
            else{
                System.out.println("Image not found");
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}