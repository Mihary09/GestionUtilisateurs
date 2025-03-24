import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

    // Panel principal de la fenêtre
    private JPanel contentPane;

    // Étiquette pour afficher un message de bienvenue personnalisé
    private JLabel lblWelcome;

    // Étiquette pour afficher une image utilisateur
    private JLabel lblImage;

    /**
     * Point d'entrée de l'application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Initialisation et affichage de la fenêtre Menu
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // Gestion des erreurs
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructeur principal : création de l'interface graphique.
     */
    public Menu() {
        // Configuration de l'opération par défaut à la fermeture de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dimensions de la fenêtre
        setBounds(100, 100, 468, 341);

        // Initialisation du contenu principal (panel)
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure vide pour l'esthétique
        contentPane.setLayout(null); // Pas de gestionnaire de disposition pour positionnement manuel
        setContentPane(contentPane);

        // Label pour le message de bienvenue
        lblWelcome = new JLabel("");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte
        lblWelcome.setBounds(252, 11, 190, 26); // Positionnement et dimensions
        contentPane.add(lblWelcome);

        // Label pour afficher l'image utilisateur
        lblImage = new JLabel(""); // Initialisation de l'étiquette d'image
        lblImage.setBounds(227, 48, 198, 153); // Positionnement et dimensions
        contentPane.add(lblImage);
    }

    /**
     * Méthode pour obtenir l'étiquette du message de bienvenue.
     * @return lblWelcome - Label du message de bienvenue
     */
    public JLabel getlblWelcome() {
        return lblWelcome;
    }

    /**
     * Méthode pour obtenir l'étiquette de l'image utilisateur.
     * @return lblImage - Label pour l'image
     */
    public JLabel getlblImage() {
        return lblImage;
    }
}
