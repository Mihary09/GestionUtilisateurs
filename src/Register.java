import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Register extends JFrame {
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtUsername;
    private JPasswordField txtPassword; 
    private JPasswordField txtConfirmPassword;
    private JTextField txtPhone;
    private JTextField txtMail;
    private JLabel lblImagePath; 
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
           
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    
    public Register() {
    	
    	  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 446, 561);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Utilisation de null layout
        setContentPane(contentPane);
        
        // Ajout du JLabel lblImagePath avant l'utilisation
        lblImagePath = new JLabel("Image path");
        lblImagePath.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagePath.setBounds(30, 409, 357, 14);
        contentPane.add(lblImagePath);
        
        

        
        
        
     // Initialiser les boutons radio avant de les ajouter à contentPane
        JRadioButton rbMale = new JRadioButton("Male");
        JRadioButton rbFemale = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        rbMale.setBounds(133, 334, 109, 23);
        rbFemale.setBounds(267, 334, 109, 23);
        contentPane.add(rbMale);
        contentPane.add(rbFemale);
        
        
        
        
        
        // LABEL LOGIN (DES PETIts)
        JLabel lblNewLabel = new JLabel("Register");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 0, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(159, 11, 83, 35);
        lblNewLabel.setOpaque(true); // Ajoutez ceci pour rendre le JLabel opaque pour que le background prenne la couleur
        contentPane.add(lblNewLabel);

        
        // MINIMIZE
        JLabel lblMinimize1 = new JLabel("-");
        lblMinimize1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// chagement de couleur 
        		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        		lblMinimize1.setBorder(borderLabel);
        		lblMinimize1.setForeground(Color.white);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		// retour couleur d'origine
        		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        		lblMinimize1.setBorder(borderLabel);
        		lblMinimize1.setForeground(Color.black);
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// mettre la page sur le bureau
        		Register.this.setState(JFrame.ICONIFIED);
        	}
        });
        lblMinimize1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblMinimize1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinimize1.setBounds(391, 0, 18, 14);
        contentPane.add(lblMinimize1);
        
        
        // CLOSE
        JLabel lblClose2 = new JLabel("X");
        lblClose2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// changement de couleur 
        		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        		lblClose2.setBorder(borderLabel);
        		lblClose2.setForeground(Color.white);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		// retour couleur d'origine
        		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        		lblClose2.setBorder(borderLabel);
        		lblClose2.setForeground(Color.black);
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// Quitter le contenu
        		System.exit(0);
        	}
        });
        lblClose2.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblClose2.setHorizontalAlignment(SwingConstants.CENTER);
        lblClose2.setBounds(413, 3, 18, 14);
        contentPane.add(lblClose2);
        
       //
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 64, 0));
        panel.setBounds(1, 0, 430, 62);
        contentPane.add(panel);
        
        JLabel lblName = new JLabel("Name :");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(67, 79, 46, 14);
        contentPane.add(lblName);
        
        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setBounds(44, 116, 69, 14);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(44, 162, 69, 14);
        contentPane.add(lblPassword);
        
        JLabel lblConfirmPassword = new JLabel("Confirm Password :");
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmPassword.setBounds(1, 211, 112, 14);
        contentPane.add(lblConfirmPassword);
        
        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setBounds(67, 254, 46, 14);
        contentPane.add(lblPhone);
        
        JLabel lblMail = new JLabel("Mail :");
        lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMail.setHorizontalAlignment(SwingConstants.CENTER);
        lblMail.setBounds(75, 294, 38, 14);
        contentPane.add(lblMail);
        
        JLabel lblGender = new JLabel("Gender :");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblGender.setBounds(51, 338, 64, 14);
        contentPane.add(lblGender);
        
        JLabel lblImage = new JLabel("Image :");
        lblImage.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setBounds(67, 384, 46, 14);
        contentPane.add(lblImage);
        
     // la bordure pour les deux         
        Border txtFieldBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black);
        
        txtName = new JTextField();
        txtName.setBounds(133, 76, 276, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);
        txtName.setBorder(txtFieldBorder);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(133, 113, 276, 20);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);
        txtUsername.setBorder(txtFieldBorder);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(133, 159, 276, 20);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);
        txtPassword.setBorder(txtFieldBorder);
        
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(133, 208, 276, 20);
        contentPane.add(txtConfirmPassword);
        txtConfirmPassword.setColumns(10);
        txtConfirmPassword.setBorder(txtFieldBorder);
        
        // PHONE
        txtPhone = new JTextField();
        txtPhone.addKeyListener(new KeyAdapter() {
        	@Override
        	// Modification du texte phone pour qu'on ne puisse écrire que des chiffres
        	public void keyTyped(KeyEvent e ) {
        		char key = e.getKeyChar();
        		if(!Character.isDigit(key))
        			e.consume();
        	}
        });
        txtPhone.setBounds(133, 251, 276, 20);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);
        txtPhone.setBorder(txtFieldBorder);
        
        txtMail = new JTextField();
        txtMail.setBounds(133, 291, 276, 20);
        contentPane.add(txtMail);
        txtMail.setColumns(10);
        txtMail.setBorder(txtFieldBorder);
        
        

     // J RADIO BUTTON si la personne est du genre :
     // MASCULIN  
     JRadioButton RadioButtonMale = new JRadioButton("Male");
     RadioButtonMale.setBounds(133, 334, 109, 23);
     contentPane.add(RadioButtonMale);

     // ou
     // FEMININ
     JRadioButton RadioButtonFemale = new JRadioButton("Female");
     RadioButtonFemale.setBounds(267, 334, 109, 23);
     contentPane.add(RadioButtonFemale);

     ButtonGroup genderGroup1 = new ButtonGroup();
     genderGroup1.add(RadioButtonMale);
     genderGroup1.add(RadioButtonFemale);

    
        
        // J BUTTON REGISTER
        JButton btnRegister = new JButton("Register");
        
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkEmptyFields()) {
                    JOptionPane.showMessageDialog(null, "Please make sure to enter all your information", "Missing data", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = txtName.getText();
                    String username = txtUsername.getText();
                    String password = new String(txtPassword.getPassword());
                    String confirmPassword = new String(txtConfirmPassword.getPassword());
                    String phone = txtPhone.getText();
                    String mail = txtMail.getText();
                    String gender = "Male";

                    if (rbFemale.isSelected()) {
                        gender = "Female";
                    }

                    if (!matchingPasswords(password, confirmPassword)) {
                        JOptionPane.showMessageDialog(null, "The passwords don't match", "Passwords!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (!checkUser()) {
                            PreparedStatement ps;
                            String query = "INSERT INTO users (name, username, password, phone, mail, gender, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
                            try {
                                ps = getConnection().prepareStatement(query);
                                ps.setString(1, name);
                                ps.setString(2, username);
                                ps.setString(3, password);
                                ps.setString(4, phone);
                                ps.setString(5, mail);
                                ps.setString(6, gender);
                                try {
                                    FileInputStream image = new FileInputStream(new File(lblImagePath.getText()));
                                    ps.setBlob(7, image);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "The account image has not been copied to the db", "Error", JOptionPane.PLAIN_MESSAGE);
                                }
                                if (ps.executeUpdate() != 0) {
                                    JOptionPane.showMessageDialog(null, "Your account has been created", "Success", JOptionPane.PLAIN_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Your account has not been created", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException ex) {
                                System.out.println("SQL operation failed.");
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "SQL operation failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (Exception ex) {
                                System.out.println("No connection to the db.");
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "No connection to the db: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        });



        btnRegister.setBackground(new Color(0, 20, 204));
        
        // Sauvegarde la couleur d'origine
        Color originalColor = btnRegister.getBackground();
        
        btnRegister.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		// quand tu passes devant login la couleur change
        		btnRegister.setBackground(new Color(0, 255, 204));
        		
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		// Reviens à la couleur d'origine quand las souris quitte
        		btnRegister.setBackground(new Color(0, 0, 204));
        	}
        });
        
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRegister.setBounds(30, 434, 357, 30);
        contentPane.add(btnRegister);
        
        JLabel lblNewLabel_1 = new JLabel(">>  Already have an account ? Login");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// retour sur la fenetre de connexion LOGIN
        		Login login = new Login ();
        		login.setVisible(true);
        		login.setLocationRelativeTo(null);
        		Register.this.dispose();
        	}
        });
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(30, 475, 357, 14);
        contentPane.add(lblNewLabel_1);
        
        
      
        
        JButton btnNewButton = new JButton("Select image");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser chooser = new JFileChooser ("." +  "./Images/PDP");
        		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpeg","jpg", "png");
        		chooser.addChoosableFileFilter(filter);	
        		chooser.setDialogTitle("Choose your image");
        		int fileState = chooser.showDialog(null, "OK");
        		if(fileState == JFileChooser.APPROVE_OPTION) {
        			File selectedImage = chooser.getSelectedFile();
        			String path = selectedImage .getAbsolutePath();
        			lblImagePath.setText(path); // Utilisation de lbl Image path
        		}
        	}
        });
        btnNewButton.setBounds(153, 380, 112, 23);
        contentPane.add(btnNewButton);
    }

      
        // Méthode checkEmptyFields placée ici, en dehors du constructeur Register()
        private boolean checkEmptyFields() {
            if (txtName.getText().equals("") ||
                txtUsername.getText().equals("") ||
                new String(txtPassword.getPassword()).equals("") ||
                new String(txtConfirmPassword.getPassword()).equals("") ||
                txtPhone.getText().equals("") ||
                txtMail.getText().equals("") ||
                lblImagePath.getText().equals("Image path")) {
                return true;
            } else {
                return false;
            }
        }
        
        private boolean matchingPasswords(String p1, String p2) {
        	return (p1.equals(p2));
        }
        
        private boolean checkUser() {
            PreparedStatement ps;
            ResultSet rs;
            boolean userExist = false;
            String query = "SELECT username FROM users WHERE username = ?";
            try {
                ps = getConnection().prepareStatement(query);
                ps.setString(1, txtUsername.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    userExist = true;
                    JOptionPane.showMessageDialog(null, "The username is already taken, choose another one", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No connection to the db", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return userExist;
        }

        
        
        
    }
