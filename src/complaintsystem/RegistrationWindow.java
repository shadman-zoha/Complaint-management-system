package complaintsystem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class RegistrationWindow extends javax.swing.JFrame {

    /**
     * Creates new form RegisterationWindow
     */
    public RegistrationWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        firstNameField = new javax.swing.JTextField();
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        lastNameField = new javax.swing.JTextField();
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        matricNoField = new javax.swing.JTextField();
        matricNoField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField = new javax.swing.JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        saveButton = new javax.swing.JButton();
        saveButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(usernameField.getText().isEmpty()||firstNameField.getText().isEmpty()||lastNameField.getText().isEmpty()
        				||matricNoField.getText().isEmpty()||emailField.getText().isEmpty()||passwordField.getText().isEmpty()
        				||securityQuestionField.getText().isEmpty()||answerField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nothing can be null!","Error!",JOptionPane.ERROR_MESSAGE);
				}
        		else {
	        		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cms"
		                        ,"root","");
						PreparedStatement insertUser=con.prepareStatement("insert into `students`(`username`"
					            + ",`first_name`,`last_name`,`matric_no`,`email`,`password`,`security_question`,`answer`) values(?,?,?,?,?,?,?,?)");
						insertUser.setString(1,usernameField.getText());
						insertUser.setString(2,firstNameField.getText());
						insertUser.setString(3,lastNameField.getText());
						insertUser.setString(4,matricNoField.getText());
						insertUser.setString(5,emailField.getText());
						insertUser.setString(6,passwordField.getText());
						insertUser.setString(7,securityQuestionField.getText());
						insertUser.setString(8,answerField.getText());
					    int result=insertUser.executeUpdate();
					    if(result!=0) {
					    	JOptionPane.showMessageDialog(null,"Student Registered!\n","Success!",JOptionPane.INFORMATION_MESSAGE);
					    	LoginPage loginPage=new LoginPage();
					    	loginPage.setVisible(true);
					    	setVisible(false);
					    }
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Error Occured!\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
					}
        		}
                
        	}
        });
        cancelButton = new javax.swing.JButton();
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginWindow loginWindow=new LoginWindow();
        		loginWindow.setVisible(true);
        		setVisible(false);
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Registration Page");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registration System"));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Matric No");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("E-mail");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Password");
       
        

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setText("Save");

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelButton.setText("Cancel");
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        lblSecurityQuestion = new JLabel("Security Question");
        lblSecurityQuestion.setFont(new Font("Arial", Font.BOLD, 18));
        
        securityQuestionField = new JTextField();
        securityQuestionField.setFont(new Font("Arial", Font.PLAIN, 14));
        securityQuestionField.setColumns(10);
        
        lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Arial", Font.BOLD, 18));
        
        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 14));
        answerField.setColumns(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(133)
        			.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        			.addGap(68)
        			.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(329, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(28)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(jLabel3)
        									.addComponent(jLabel4)
        									.addComponent(jLabel5)
        									.addComponent(jLabel6))
        								.addGap(67))
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(jLabel7))
        							.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
        						.addPreferredGap(ComponentPlacement.RELATED))
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(lblSecurityQuestion, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
        						.addGap(57)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(lblAnswer)
        					.addGap(170)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(answerField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(securityQuestionField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(usernameField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(firstNameField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(lastNameField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(matricNoField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        				.addComponent(emailField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
        			.addGap(53))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(36)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        				.addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        			.addGap(8)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(matricNoField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSecurityQuestion)
        				.addComponent(securityQuestionField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAnswer)
        				.addComponent(answerField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGap(22)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        			.addGap(8))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
        					.addGap(162))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton saveButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField matricNoField;
    private javax.swing.JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel lblSecurityQuestion;
    private JTextField securityQuestionField;
    private JLabel lblAnswer;
    private JTextField answerField;
}
