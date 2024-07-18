package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SysAndMain.CoffeeShopSys;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveFrame extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox;
	JLabel outputLabel;


	public JLabel getOutputLabel() {
		return outputLabel;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}


	/**
	 * Create the frame.
	 */
	public RemoveFrame(CoffeeShopFrame cf) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(231, 48, 136, 22);
		contentPane.add(comboBox);
		
		outputLabel = new JLabel("");
		outputLabel.setBounds(48, 158, 314, 30);
		contentPane.add(outputLabel);
		
		JLabel lblNewLabel = new JLabel("Select drink from list to remove:");
		lblNewLabel.setBounds(20, 52, 225, 14);
		contentPane.add(lblNewLabel);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoffeeShopSys.removeBeverage(comboBox.getSelectedItem().toString());
				outputLabel.setText(comboBox.getSelectedItem().toString() + " is successfully removed from the basket.");
				getComboBox().setModel(new DefaultComboBoxModel(CoffeeShopSys.getBeverageListItems()));
			}
		});
		removeButton.setBounds(48, 106, 89, 23);
		contentPane.add(removeButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				dispose();
			}
		});
		closeButton.setBounds(253, 106, 89, 23);
		contentPane.add(closeButton);
		
		
	}
}
