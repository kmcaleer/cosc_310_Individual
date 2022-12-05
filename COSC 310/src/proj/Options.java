package proj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
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
	public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
	//Set up menus GUI
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	
	//Set up menu titles
		JMenu mnNewMenu = new JMenu("Administration");
		JMenu mnNewMenu_1=new JMenu("Prod Options");
		JMenu mnNewMenu_2=new JMenu("Reports");
		JMenu mnNewMenu_3=new JMenu("Communications");
		menuBar.add(mnNewMenu);
		menuBar.add(mnNewMenu_1);
		menuBar.add(mnNewMenu_2);
		menuBar.add(mnNewMenu_3);
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Add.main(null);
			}
		});

	//Set up Admin menu options
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add User");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addUser.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Delete User");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteUser.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Supplier");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addSupplier.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4= new JMenuItem("Delete Supplier");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteSupplier.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
	
		JMenuItem mntmNewMenuItem_5= new JMenuItem("Add Transaction");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					addTransaction.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6= new JMenuItem("Delete Transaction");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteTransaction.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7= new JMenuItem("Get Transaction Rate");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TransactionRate.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Exit");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.exit(ABORT);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_8);


	//Set up Product menu options
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Add Product");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Add.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Remove Product");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Remove.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Update Product Quantity");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					removeQuant.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Create Barcode");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					createBarcode.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);

		//JMenuItem mntmNewMenuItem_12 = new JMenuItem("Print Barcode");
		//mntmNewMenuItem_12.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//			BarcodeUPCA.main(null);
		//	}
	//	});
	//	mnNewMenu_1.add(mntmNewMenuItem_12);

	//Set up Report menu options	
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("List Product Inventory");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Look.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("List Low Stock Items");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					LowList.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("List Suppliers");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListSuppliers.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("List Users");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListUsers.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17= new JMenuItem("List Transactions");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListTransactions.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_17);


	//Set up Communications menu options	
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Send Low Stock Email");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Alert.main(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19= new JMenuItem("Send Order");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//System.exit(ABORT);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_19);

	}


}
