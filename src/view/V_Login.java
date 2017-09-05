package view;

import java.awt.event.MouseListener;

/**
 *
 * @author Ij Lik
 */
public class V_Login extends View {

    public V_Login() {
        initComponents();
    }

    public void addLoginListener(MouseListener e){
        this.loginButton.addMouseListener(e);
    }
    
    public String getUsername(){
        return this.username.getText();
    }
    
    public String getPassword(){
        return this.password.getText();
    }
    
    public void setMessages(String s){
        this.messages.setText(s);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        loginButton = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        messages = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(333, 144));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setBackground(new java.awt.Color(19, 107, 204));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(19, 107, 204));
        username.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setToolTipText("Enter username");
        username.setBorder(null);
        username.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        Login.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 210, 30));
        username.getAccessibleContext().setAccessibleName("");

        usernameLabel.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");
        Login.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");
        Login.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        Login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 226, 10));
        Login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 226, 10));

        loginButton.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Login_button.png"))); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Login-image.png"))); // NOI18N
        Login.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Play", 0, 23)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Welcome");
        Login.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        messages.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        messages.setForeground(new java.awt.Color(255, 255, 255));
        messages.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        messages.setText("Please login ");
        messages.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Login.add(messages, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 270, 20));

        password.setBackground(new java.awt.Color(19, 107, 204));
        password.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setToolTipText("Enter password");
        password.setBorder(null);
        Login.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 210, 30));

        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 300, 310));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Login.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel messages;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void disableMenu() {
        // nothing
    }
}
