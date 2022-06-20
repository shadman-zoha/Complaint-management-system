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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ComboItem{
	private String id;
	private String officeId;
	 public ComboItem(String officeId, String id)
	    {
	        this.officeId = officeId;
	        this.id = id;
	    }

	    @Override
	    public String toString()
	    {
	        return officeId;
	    }

	    public String getKey()
	    {
	        return officeId;
	    }

	    public String getValue()
	    {
	        return id;
	    }
}
public class AddStaff extends JFrame {

	private JPanel contentPane;
	private JTextField staffNameField;
	private JTextField phoneField;
	private JTextField staffIdField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff frame = new AddStaff();
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
	public AddStaff() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddStaff = new JLabel("Add Staff");
		lblAddStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStaff.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setText("Staff Name");
		jLabel4.setFont(new Font("Arial", Font.BOLD, 18));
		
		staffNameField = new JTextField();
		staffNameField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("Phone");
		jLabel5.setFont(new Font("Arial", Font.BOLD, 18));
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel jLabel6 = new JLabel();
		jLabel6.setText("Office ID");
		jLabel6.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel lblStaffId = new JLabel();
		lblStaffId.setText("Staff ID");
		lblStaffId.setFont(new Font("Arial", Font.BOLD, 18));
		
		staffIdField = new JTextField();
		staffIdField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JComboBox officeIdComboBox = new JComboBox();
		
		JLabel jLabel7_1 = new JLabel();
		jLabel7_1.setText("Password");
		jLabel7_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(staffIdField.getText().isEmpty()||staffNameField.getText().isEmpty()||phoneField.getText().isEmpty()||passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nothing can be null!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
		                        ,"root","");
						PreparedStatement insertStaff=con.prepareStatement("insert into `staffs`(`staff_id`"
					            + ",`staff_name`,`phone`,`office_id`,`password`) values(?,?,?,?,?)");
						insertStaff.setString(1,staffIdField.getText());
						insertStaff.setString(2,staffNameField.getText());
						insertStaff.setString(3,phoneField.getText());
						Object item = officeIdComboBox.getSelectedItem();
						String office_id = ((ComboItem)item).getValue();
						insertStaff.setString(4,office_id);
						insertStaff.setString(5,passwordField.getText());
					    int result=insertStaff.executeUpdate();
					    if(result!=0) {
					    	JOptionPane.showMessageDialog(null,"Staff Registered!\n","Success!",JOptionPane.INFORMATION_MESSAGE);
					    	staffIdField.setText("");
					    	staffNameField.setText("");
					    	phoneField.setText("");
					    	passwordField.setText("");
					    }
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Error Occured!\n"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		saveButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
                    ,"root","");
			PreparedStatement offices=con.prepareStatement("select * from `offices`");
			ResultSet rs=offices.executeQuery();
			while(rs.next()) {
				officeIdComboBox.addItem(new ComboItem(rs.getString("office_id"),rs.getString("id")));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error Occured!\n"+e,"Error!",JOptionPane.ERROR_MESSAGE);
		}
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMenu adminMenu= new AdminMenu();
				adminMenu.setVisible(true);
				setVisible(false);
			}
		});
		cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblStaffId, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(officeIdComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(staffIdField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
									.addComponent(staffNameField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
									.addComponent(phoneField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(280)
							.addComponent(lblAddStaff, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddStaff, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(staffIdField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStaffId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(staffNameField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(officeIdComboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel7_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
