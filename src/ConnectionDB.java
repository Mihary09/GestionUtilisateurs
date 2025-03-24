import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectionDB {

    // D�finition de l'URL, du nom d'utilisateur et du mot de passe pour se connecter � la base de donn�es MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USER = "root";  // Nom d'utilisateur de la base de donn�es
    private static final String PASSWORD = "";  // Mot de passe de la base de donn�es (vide ici)

    // M�thode pour obtenir une connexion � la base de donn�es
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Charger le driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // �tablir la connexion � la base de donn�es avec les informations fournies
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Gestion d'erreur si le driver JDBC MySQL n'est pas trouv�
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Gestion d'erreur si la connexion �choue
            System.out.println("Connection failed.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection; // Retourne la connexion si elle a r�ussi
    }

    // M�thode principale pour ex�cuter le programme
    public static void main(String[] args) {
        // Appel � la m�thode pour obtenir une connexion
        Connection connection = getConnection();
        if (connection != null) {
            try {
                // Cr�ation d'un objet Statement pour ex�cuter les requ�tes SQL
                Statement statement = connection.createStatement();
                
                // Requ�te SQL pour r�cup�rer les donn�es de la table "users"
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                
                if (resultSet.next()) {
                    // Si des donn�es sont trouv�es, affiche le premier enregistrement
                    String userData = "name: " + resultSet.getString("name") +
                                      ", username: " + resultSet.getString("username") +
                                      ", email: " + resultSet.getString("mail");
                    
                    // Affiche les donn�es r�cup�r�es dans la console et dans une fen�tre de dialogue
                    System.out.println("Query successful: " + userData);
                    JOptionPane.showMessageDialog(null, "Query successful: " + userData, "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    // Si aucune donn�e n'est trouv�e dans la table
                    System.out.println("No data found in the table.");
                    JOptionPane.showMessageDialog(null, "No data found in the table.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                // Gestion d'erreur pour les op�rations SQL
                System.out.println("SQL operation failed.");
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL operation failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    // Fermeture de la connexion � la base de donn�es pour lib�rer les ressources
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Affichage d'une erreur si la connexion a �chou�
            JOptionPane.showMessageDialog(null, "Failed to create account", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
