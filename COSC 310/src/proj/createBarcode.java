package proj;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.sourceforge.barbecue.*;
import net.sourceforge.barbecue.linear.upc.UPCABarcode;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;

public class createBarcode extends JFrame{
    
    public static String pname = null;
    public static String num = "0000000000";
    public static Barcode barcode = null;
    public static File png = null;
    private JPanel contentPane;

    /**
	 * Launch the application.
	 */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createBarcode frame = new createBarcode();
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
	public createBarcode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Generate Barcode");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBounds(105, 6, 299, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(70, 67, 108, 16);
		contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Barcode Number");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setBounds(70, 105, 108, 16);
		contentPane.add(lblNewLabel_2);
				
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(186, 62, 155, 26);
		contentPane.add(formattedTextField);

        JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(186, 100, 155, 26);
		contentPane.add(formattedTextField_1);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 db app =new db();
                 try {
					pname = formattedTextField.getText();
                    num = formattedTextField_1.getText();
                    try{
                    // Get a Barcode from the BarcodeFactory
                   barcode = BarcodeFactory.createUPCA(num);

                } catch (BarcodeException e2){
                    formattedTextField.setText("");
					 JOptionPane.showMessageDialog(null, "Enter barcode info again (must be 11 dgits)", "Incorrect Types", JOptionPane.ERROR_MESSAGE);
                }
                 //Convert Barcode to png
                 png = new File(pname + ".png");
                 try{
                 BarcodeImageHandler.savePNG(barcode, png);
                 }catch (OutputException e3){
                     e3.printStackTrace();
                 }
					app.connect();
					app.addBarcode(pname, png);
					JOptionPane.showMessageDialog(null,"Successful");
					formattedTextField.setText("");
                
                
                } catch (SQLException e1) {
					formattedTextField.setText("");
					JOptionPane.showMessageDialog(null, "Enter product name again", "Incorrect Types", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(59, 199, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.main(null);
			}
		});
		btnNewButton_1.setBounds(244, 199, 117, 29);
		contentPane.add(btnNewButton_1);
		
	}








//     public void drawingBarcodeDirectToGraphics() throws BarcodeException, OutputException {
//     // Always get a Barcode from the BarcodeFactory
//     Barcode barcode = BarcodeFactory.createUPCA("My Barcode");

//     // We are created an image from scratch here, but for printing in Java, your
//     // print renderer should have a Graphics internally anyway
//     BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_BYTE_GRAY);
//     // We need to cast the Graphics from the Image to a Graphics2D - this is OK
//     Graphics2D g = (Graphics2D) image.getGraphics();

//     // Barcode supports a direct draw method to Graphics2D that lets you position the
//     // barcode on the canvas
//     barcode.draw(g, 10, 56);
// }


}
