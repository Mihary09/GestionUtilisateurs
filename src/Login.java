import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPasswordField;

public class Login extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
                login.setLocationRelativeTo(null); // Centre la fenêtre
            }
        });
    }

    /**
     * Constructeur principal : création de l'interface utilisateur
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application en cas de sortie
        setBounds(100, 100, 487, 394); // Dimensions de la fenêtre
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Utilisation d'un layout libre
        setContentPane(contentPane);

        // Titre principal
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(198, 11, 111, 45);
        lblNewLabel.setOpaque(true);
        contentPane.add(lblNewLabel);

        // Bouton réduire
        JLabel lblMinimize = new JLabel("-");
        lblMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblMinimize.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
                lblMinimize.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblMinimize.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                lblMinimize.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Login.this.setState(JFrame.ICONIFIED);
            }
        });
        lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinimize.setBounds(427, 2, 18, 14);
        contentPane.add(lblMinimize);

        // Bouton fermer
        JLabel lblClose = new JLabel("X");
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblClose.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
                lblClose.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblClose.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                lblClose.setForeground(Color.black);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        lblClose.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblClose.setHorizontalAlignment(SwingConstants.CENTER);
        lblClose.setBounds(445, 2, 26, 14);
        contentPane.add(lblClose);

        // Panel pour le titre
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(128, 0, 64));
        panelLogin.setBounds(0, 2, 471, 79);
        contentPane.add(panelLogin);

        // Champs pour le nom d'utilisateur
        JLabel lblNewLabel_3 = new JLabel("Username :");
        lblNewLabel_3.setForeground(new Color(128, 128, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(37, 102, 81, 14);
        contentPane.add(lblNewLabel_3);

        txtUsername = new JTextField();
        txtUsername.setBounds(117, 89, 272, 40);
        contentPane.add(txtUsername);

        // Champs pour le mot de passe
        JLabel lblNewLabel_4 = new JLabel("Password :");
        lblNewLabel_4.setForeground(new Color(128, 128, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(40, 160, 67, 15);
        contentPane.add(lblNewLabel_4);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(117, 148, 272, 40);
        contentPane.add(txtPassword);

        // Bouton Login
        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(191, 64, 64));
        Color originalColor = btnLogin.getBackground();
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(120, 0, 0));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(originalColor);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your username and your password", "Missing Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    String username = txtUsername.getText();
                    String password = txtPassword.getText();
                    String query = "SELECT name, username, image FROM users WHERE username=? AND password=?";
                    try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(query)) {
                        ps.setString(1, username);
                        ps.setString(2, password);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Welcome " + rs.getString("name"));
                        } else {
                            JOptionPane.showMessageDialog(null, "No user with this username or password", "Incorrect data", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Connection with DB failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.setBounds(42, 213, 347, 40);
        contentPane.add(btnLogin);

        // Créer un compte si aucun utilisateur n'existe
        JLabel lblRegister = new JLabel(">> No Account ? Create One");
        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Register register = new Register();
                register.setVisible(true);
                register.setLocationRelativeTo(null);
                Login.this.dispose();
            }
        });
        lblRegister.setForeground(new Color(255, 0, 0));
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setBounds(102, 282, 226, 20);
        contentPane.add(lblRegister);
    }
}
