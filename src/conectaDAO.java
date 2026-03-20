import java.sql.Connection;
import java.sql.DriverManager;

public class conectaDAO {
    //banco de dados//
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/leiloes";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            System.out.println("Erro conexão: " + e.getMessage());
        }
        
        return conn;
    }
}