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
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddRoom extends JFrame {

	private JPanel contentPane;
	private JTextField roomIdField;
	private JTextField blockIdField;
	private JTextField locationField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoom frame = new AddRoom();
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
	public AddRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddOffice = new JLabel();
		lblAddOffice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddOffice.setText("Add Room");
		lblAddOffice.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblOfficeId = new JLabel();
		lblOfficeId.setText("Room ID");
		lblOfficeId.setFont(new Font("Arial", Font.BOLD, 18));
		
		roomIdField = new JTextField();
		roomIdField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel();
		lblAddress.setText("Block ID");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 18));
		
		blockIdField = new JTextField();
		blockIdField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(roomIdField.getText().isEmpty()||blockIdField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nothing can be null!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms"
		                        ,"root","");
						PreparedStatement insertRoom=con.prepareStatement("insert into `rooms`(`room_id`"
					            + ",`block_id`,`location`) values(?,?,?)");
						insertRoom.setString(1,roomIdField.getText());
						insertRoom.setString(2,blockIdField.getText());
						insertRoom.setString(3,locationField.getText());
					    int result=insertRoom.executeUpdate();
					    if(result!=0) {
					    	JOptionPane.showMessageDialog(null,"Room Added!\n","Success!",JOptionPane.INFORMATION_MESSAGE);
					    	roomIdField.setText("");
					    	blockIdField.setText("");
					    	locationField.setText("");
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
		
		JLabel lblLocation = new JLabel();
		lblLocation.setText("Location");
		lblLocation.setFont(new Font("Arial", Font.BOLD, 18));
		
		locationField = new JTextField();
		locationField.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblAddOffice, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cancelButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(117))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblLocation, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOfficeId, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(roomIdField)
												.addComponent(blockIdField, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(71)
											.addComponent(locationField, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)))))
							.addGap(287)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblAddOffice, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(roomIdField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOfficeId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(blockIdField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocation, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
