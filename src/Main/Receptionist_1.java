package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import Receptionists.ReceptionistActivity;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Receptionist_1 extends javax.swing.JFrame {

    PreparedStatement prp = null;
    ResultSet result = null;
    Connection connection = null;
    String username;

    public Receptionist_1() {
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Images/hospital.png"));
        this.setIconImage(ic.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dUser = new javax.swing.JLabel();
        rUserField = new javax.swing.JTextField();
        plbl = new javax.swing.JLabel();
        rPassField = new javax.swing.JPasswordField();
        rExitBtn = new javax.swing.JButton();
        rLoginBtn = new javax.swing.JButton();
        mLabel = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Receptionist");
        setBackground(new java.awt.Color(102, 102, 0));
        setPreferredSize(new java.awt.Dimension(1011, 518));
        setResizable(false);
        getContentPane().setLayout(null);

        dUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dUser.setText("Username :- ");
        getContentPane().add(dUser);
        dUser.setBounds(300, 210, 160, 30);

        rUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rUserFieldActionPerformed(evt);
            }
        });
        getContentPane().add(rUserField);
        rUserField.setBounds(400, 210, 280, 30);

        plbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        plbl.setText(" Password :- ");
        getContentPane().add(plbl);
        plbl.setBounds(300, 250, 160, 29);

        rPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPassFieldActionPerformed(evt);
            }
        });
        getContentPane().add(rPassField);
        rPassField.setBounds(400, 250, 280, 29);

        rExitBtn.setBackground(new java.awt.Color(255, 255, 255));
        rExitBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rExitBtn.setForeground(new java.awt.Color(102, 204, 0));
        rExitBtn.setText("Back");
        rExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rExitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rExitBtn);
        rExitBtn.setBounds(420, 320, 91, 35);

        rLoginBtn.setBackground(new java.awt.Color(255, 255, 255));
        rLoginBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rLoginBtn.setForeground(new java.awt.Color(102, 204, 0));
        rLoginBtn.setText("Login");
        rLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLoginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rLoginBtn);
        rLoginBtn.setBounds(530, 320, 91, 35);

        mLabel.setAlignment(java.awt.Label.CENTER);
        mLabel.setBackground(new java.awt.Color(153, 204, 0));
        mLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        mLabel.setForeground(new java.awt.Color(255, 255, 255));
        mLabel.setText("Hospital Management System");
        getContentPane().add(mLabel);
        mLabel.setBounds(0, 0, 1010, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 1000, 490);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rUserFieldActionPerformed

    private void rPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rPassFieldActionPerformed

    private void rExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rExitBtnActionPerformed
        Hospital hospital = new Hospital();
        hospital.setVisible(true);
        dispose();
    }//GEN-LAST:event_rExitBtnActionPerformed

    private void rLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLoginBtnActionPerformed
        connection = Connector.ConnectDb();
        String user = rUserField.getText();
        String pass = String.valueOf(rPassField.getPassword());
        try {
            String sql = "select username, password from receptionist where username='" + user + "'";
            prp = connection.prepareStatement(sql);
            result = prp.executeQuery();
            result.first();
            if (pass.equals(result.getString("password"))) {
                JOptionPane.showMessageDialog(null, "Login Succesful", "Welcome " + user, JOptionPane.INFORMATION_MESSAGE);
                ReceptionistActivity rActivity = new ReceptionistActivity();
                rActivity.setVisible(true);
                username = user;
                ReceptionistActivity.username = username;
                dispose();
                connection.close();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "User or Password wrong.");
        }
    }//GEN-LAST:event_rLoginBtnActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Receptionist_1().setVisible(true);
            }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dUser;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label mLabel;
    private javax.swing.JLabel plbl;
    private javax.swing.JButton rExitBtn;
    private javax.swing.JButton rLoginBtn;
    private javax.swing.JPasswordField rPassField;
    private javax.swing.JTextField rUserField;
    // End of variables declaration//GEN-END:variables
}
