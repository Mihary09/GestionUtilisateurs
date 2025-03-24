import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectionDB {

    // Définition de l'URL, du nom d'utilisateur et du mot de passe pour se connecter à la base de données MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USER = "root";  // Nom d'utilisateur de la base de données
    private static final String PASSWORD = "";  // Mot de passe de la base de données (vide ici)

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Charger le driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Établir la connexion à la base de données avec les informations fournies
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Gestion d'erreur si le driver JDBC MySQL n'est pas trouvé
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Gestion d'erreur si la connexion échoue
            System.out.println("Connection failed.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection; // Retourne la connexion si elle a réussi
    }

    // Méthode principale pour exécuter le programme
    public static void main(String[] args) {
        // Appel à la méthode pour obtenir une connexion
        Connection connection = getConnection();
        if (connection != null) {
            try {
                // Création d'un objet Statement pour exécuter les requêtes SQL
                Statement statement = connection.createStatement();
                
                // Requête SQL pour récupérer les données de la table "users"
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                
                if (resultSet.next()) {
                    // Si des données sont trouvées, affiche le premier enregistrement
                    String userData = "name: " + resultSet.getString("name") +
                                      ", username: " + resultSet.getString("username") +
                                      ", email: " + resultSet.getString("mail");
                    
                    // Affiche les données récupérées dans la console et dans une fenêtre de dialogue
                    System.out.println("Query successful: " + userData);
                    JOptionPane.showMessageDialog(null, "Query successful: " + userData, "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    // Si aucune donnée n'est trouvée dans la table
                    System.out.println("No data found in the table.");
                    JOptionPane.showMessageDialog(null, "No data found in the table.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                // Gestion d'erreur pour les opérations SQL
                System.out.println("SQL operation failed.");
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL operation failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    // Fermeture de la connexion à la base de données pour libérer les ressources
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Affichage d'une erreur si la connexion a échoué
            JOptionPane.showMessageDialog(null, "Failed to create account", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
