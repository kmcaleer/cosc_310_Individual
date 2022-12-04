package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class deleteTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteTransaction frame = new deleteTransaction();
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
	public deleteTransaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(18, 34, 132, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Transaction Date");
		lblNewLabel_1.setBounds(18, 104, 122, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Transaction Quantity");
		lblNewLabel_2.setBounds(18, 169, 132, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(175, 29, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 99, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 164, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db app = new db();
				try {
					app.connect();
					int y = Integer.parseInt(textField_2.getText());
					app.deleteTransaction(textField.getText(), textField_1.getText(), y);;
					JOptionPane.showMessageDialog(null, "Successfull");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				} catch (SQLException e1) {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null, "Enter Transaction details again", "Incorrect details or no such records", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(55, 218, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
		});
		btnNewButton_1.setBounds(250, 218, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
