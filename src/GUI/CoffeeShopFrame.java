package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Classes.Customer;
import SysAndMain.CoffeeShopSys;


import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class CoffeeShopFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	ButtonGroup buttonGroup;
	
	RemoveFrame removeFrame = null;
	JComboBox comboBox;
	JComboBox comboBox1;
	JLabel nameSurnameLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeShopFrame frame = new CoffeeShopFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public CoffeeShopFrame() {
		CoffeeShopFrame cs = this;
		 
		 removeFrame = new RemoveFrame(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 224, 421, 132);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JLabel lblNewLabel = new JLabel("Customer Name and Surname:");
		lblNewLabel.setBounds(23, 23, 177, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(210, 20, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Choose beverage:");
		lblNewLabel_1.setBounds(23, 68, 145, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Select from beverages:");
		lblNewLabel_2.setBounds(23, 111, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		

		comboBox = new JComboBox();
		comboBox.setSelectedItem(null);
	    comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				
			}	
				}
			);
			comboBox.setBounds(210, 107, 93, 22);
	        contentPane.add(comboBox);

	        comboBox1 = new JComboBox();
			comboBox1.setBounds(210, 147, 38, 22);
			contentPane.add(comboBox1);
			comboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5","6","7","8","9","10"}));
			comboBox1.getSelectedItem();
	   
		
		
		JRadioButton rdbtnCoffee = new JRadioButton("Coffee");
		rdbtnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.removeAllItems();
				comboBox.addItem("Filter");
				comboBox.addItem("Latte");
				comboBox.addItem("Espresso");
				comboBox.addItem("Mocha");
		
					
			}});
		
		rdbtnCoffee.setBounds(210, 69, 76, 20);
		contentPane.add(rdbtnCoffee);
		
		JRadioButton rdbtnTea = new JRadioButton("Tea");
		rdbtnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				comboBox.addItem("Green Tea");
				comboBox.addItem("Earl Grey");
				
			}
		});
		rdbtnTea.setBounds(288, 68, 53, 23);
		contentPane.add(rdbtnTea);
		
		JRadioButton rdbtnSoftDrink = new JRadioButton("Soft Drink");
		rdbtnSoftDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				comboBox.addItem("Coke");
				comboBox.addItem("Sparkling");
				comboBox.addItem("Water");
				
				comboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5","6","7","8","9","10"}));
				comboBox1.getSelectedItem();

			}
		});
		rdbtnSoftDrink.setBounds(356, 68, 93, 23);
		contentPane.add(rdbtnSoftDrink);
		
		
		
		    buttonGroup = new ButtonGroup();
	        buttonGroup.add(rdbtnCoffee);
	        buttonGroup.add(rdbtnTea);
	        buttonGroup.add(rdbtnSoftDrink);




	    
		     JButton btnAdd = new JButton("Add Selection to Basket");
		     btnAdd.setBounds(407, 104, 228, 28);
		     btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				 if (comboBox.getSelectedItem() == null || comboBox.getSelectedItem().toString().isEmpty() || comboBox1.getSelectedItem().toString().isEmpty()) {
						textArea.setText("You did not enter customer name, select type of beverage or count of beverage");
					} else {
						if(textField != null && !textField.getText().isEmpty()) {
						CoffeeShopSys.addBeverage(comboBox.getSelectedItem().toString(),Integer.parseInt(comboBox1.getSelectedItem().toString()));
						textArea.setText("Selection is added");
						nameSurnameLabel.setText(textField.getText());
						textField.setVisible(false);
						textField = null;
						}
						else {
							textArea.setText(CoffeeShopSys.addBeverage(comboBox.getSelectedItem().toString(),
									Integer.parseInt(comboBox1.getSelectedItem().toString())));
							textArea.setText("Selection is added");
						}
					}
					clear();

			}
		});
		contentPane.add(btnAdd);
		
		
		
		
		JButton btnRemove = new JButton("Remove Selection from Basket");
		btnRemove.setBounds(407, 144, 228, 28);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!CoffeeShopSys.getBeverageList().isEmpty()) {
				removeFrame.getComboBox().setModel(new DefaultComboBoxModel(CoffeeShopSys.getBeverageListItems()));
				removeFrame.getOutputLabel().setText("");
				removeFrame.setVisible(true);
				setVisible(false);
				}
				else
					textArea.setText("Basket is empty!");
			}
		});
		contentPane.add(btnRemove);
		

				
			
		JButton btnDisplay = new JButton("Display Basket");
		btnDisplay.setBounds(191, 368, 119, 36);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField != null) {
					if(textField.getText().isEmpty())
						textArea.setText("Please enter customer name first.");
					else {
						nameSurnameLabel.setText(textField.getText());
						textField.setVisible(false);
						textField = null;
					}
				}
				if(!nameSurnameLabel.getText().isEmpty()) {
				if(CoffeeShopSys.getBeverageList().isEmpty())
					textArea.setText("There is no customer basket in the system!");
				else
					textArea.setText(CoffeeShopSys.getBeverageListDetail(nameSurnameLabel.getText()));
				}
			}}
		);
		contentPane.add(btnDisplay);
		
		
		
		JButton btnCalculateBasket = new JButton("Calculate Basket");
		btnCalculateBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField != null) {
					if(textField.getText().isEmpty())
						textArea.setText("Please enter customer name first.");
					else {
						nameSurnameLabel.setText(textField.getText());
						textField.setVisible(false);
						textField = null;
					}
				}
				if(!nameSurnameLabel.getText().isEmpty()) {
				if(CoffeeShopSys.getBeverageList().isEmpty())
					textArea.setText("There is no customer basket in the system!");
				else
					textArea.setText(CoffeeShopSys.calculatePrice(nameSurnameLabel.getText()));
				}
			}
				
			});
		btnCalculateBasket.setBounds(337, 368, 131, 36);
		contentPane.add(btnCalculateBasket);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Selected beverage count:");
		lblNewLabel_3.setBounds(22, 151, 163, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("CLEAR SELECTION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setBounds(147, 190, 162, 23);
		contentPane.add(btnNewButton);
		
		nameSurnameLabel = new JLabel("");
		nameSurnameLabel.setBounds(214, 23, 173, 14);
		contentPane.add(nameSurnameLabel);
		
		
		
		
		
		
	}
		public void clear() {
		buttonGroup.clearSelection();
		comboBox.removeAllItems();
		comboBox1.setSelectedIndex(0);
		}
		
		

		JTextArea gettextArea() {
			return textArea;
		}
	}

