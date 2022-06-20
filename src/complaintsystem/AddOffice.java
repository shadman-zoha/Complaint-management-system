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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddOffice extends JFrame {

	private JPanel contentPane;
	private JTextField officeIdField;
	private JTextField addressField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOffice frame = new AddOffice();
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
	public AddOffice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddOffice = new JLabel();
		lblAddOffice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddOffice.setText("Add Office");
		lblAddOffice.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblOfficeId = new JLabel();
		lblOfficeId.setText("Office ID");
		lblOfficeId.setFont(new Font("Arial", Font.BOLD, 18));
		
		officeIdField = new JTextField();
		officeIdField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel();
		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 18));
		
		addressField = new JTextField();
		addressField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(officeIdField.getText().isEmpty()||addressField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nothing can be null!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
		                        ,"root","");
						PreparedStatement insertOffice=con.prepareStatement("insert into `offices`(`office_id`"
					            + ",`address`) values(?,?)");
						insertOffice.setString(1,officeIdField.getText());
						insertOffice.setString(2,addressField.getText());
					    int result=insertOffice.executeUpdate();
					    if(result!=0) {
					    	JOptionPane.showMessageDialog(null,"Office Added!\n","Success!",JOptionPane.INFORMATION_MESSAGE);
					    	officeIdField.setText("");
					    	addressField.setText("");
					    }
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Error Occured!\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		saveButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu adminMenu=new AdminMenu();
		    	adminMenu.setVisible(true);
		    	setVisible(false);
			}
		});
		cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblAddOffice, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOfficeId, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(officeIdField)
								.addComponent(addressField, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
								.addComponent(cancelButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(281, Short.MAX_VALUE)
					.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblAddOffice, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOfficeId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(officeIdField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
