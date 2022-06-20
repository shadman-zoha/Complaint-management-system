package complaintsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RecoverPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField matricNoField;
	private JTextField securityQuestionField;
	private JTextField answerField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecoverPage frame = new RecoverPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecoverPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Matric No");
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setText("Username");
		jLabel3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setText("New password");
		jLabel4.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("Confirm password");
		jLabel5.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		
		matricNoField = new JTextField();
		
		JButton saveButton = new JButton();
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matricNoField.getText().isEmpty()||answerField.getText().isEmpty()||passwordField.getText().isEmpty()||confirmPasswordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nothing can be null!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else if(!passwordField.getText().equals(confirmPasswordField.getText())) {
					JOptionPane.showMessageDialog(null,"Password and Confirm Password are not matched!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
	        			Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
		                        ,"root","");
						PreparedStatement selectUser=con.prepareStatement("select * from `students` where `matric_no`=?");
						selectUser.setString(1, matricNoField.getText());
						ResultSet rs=selectUser.executeQuery();
						while(rs.next()) {
							if(rs.getString("answer").equals(answerField.getText())) {
								PreparedStatement updateUser=con.prepareStatement("update `students` set `password`=? where `matric_no`=?");
								updateUser.setString(1, passwordField.getText());
								updateUser.setString(2, matricNoField.getText());
								int result=updateUser.executeUpdate();
								if(result!=0) {
									JOptionPane.showMessageDialog(null,"Password Recovered!\n","Success!",JOptionPane.INFORMATION_MESSAGE);
							    	LoginPage loginPage=new LoginPage();
							    	loginPage.setVisible(true);
							    	setVisible(false);
								}
								else {
									JOptionPane.showMessageDialog(null,"Error Occured!\n","Error!",JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"Invalid Answer!\n","Error!",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"Error Occured!\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		saveButton.setText("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton cancelButton = new JButton();
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage=new LoginPage();
		    	loginPage.setVisible(true);
		    	setVisible(false);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("Recover Password Page");
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblSecurityQuestion = new JLabel();
		lblSecurityQuestion.setText("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		securityQuestionField = new JTextField();
		securityQuestionField.setEditable(false);
		
		JLabel jLabel3_2 = new JLabel();
		jLabel3_2.setText("Answer");
		jLabel3_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		answerField = new JTextField();
		
		passwordField = new JPasswordField();
		
		confirmPasswordField = new JPasswordField();
		
		JButton getInfoButton = new JButton("Get Info");
		getInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
        			Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
	                        ,"root","");
					PreparedStatement selectUser=con.prepareStatement("select * from `students` where `matric_no`=?");
					selectUser.setString(1, matricNoField.getText());
					ResultSet rs=selectUser.executeQuery();
					while(rs.next()) {
						usernameField.setText(rs.getString("username"));
						securityQuestionField.setText(rs.getString("security_question"));
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error Occured!\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		getInfoButton.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSecurityQuestion, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(matricNoField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getInfoButton))
								.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordField, Alignment.LEADING)
									.addComponent(answerField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addComponent(securityQuestionField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(matricNoField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(getInfoButton))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSecurityQuestion, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(securityQuestionField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(answerField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
