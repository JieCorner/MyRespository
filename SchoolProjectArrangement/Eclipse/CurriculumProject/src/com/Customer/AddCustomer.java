package com.Customer;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.util.JDBCUtil;
import com.util.Regex;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AddCustomer extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8342698145622949899L;
	private JTextField cName;
	private JTextField cAddress;
	private JTextField cPostCode;
	private JTextField cTel;
	private JTextField cLoginName;
	private JPasswordField cPassword;

	/**
	 * Create the panel.
	 */
	public AddCustomer() {
		setBounds(0, 0, 635, 376);
		setLayout(null);
		
		cName = new JTextField();
		cName.setBounds(298, 32, 139, 21);
		add(cName);
		cName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(187, 35, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setBounds(187, 60, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5730\u5740");
		lblNewLabel_2.setBounds(187, 85, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE\u653F\u7F16\u7801");
		lblNewLabel_3.setBounds(187, 110, 54, 15);
		add(lblNewLabel_3);
		
		final JRadioButton boy = new JRadioButton("\u7537",true);
		boy.setBounds(298, 56, 61, 23);
		final JRadioButton girl = new JRadioButton("\u5973");
		girl.setBounds(361, 56, 61, 23);	
		ButtonGroup sex = new ButtonGroup();
		sex.add(boy);
		sex.add(girl);
		add(boy);
		add(girl);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD");
		lblNewLabel_4.setBounds(187, 135, 54, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6CE8\u518C\u540D");
		lblNewLabel_5.setBounds(187, 160, 54, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5BC6\u7801");
		lblNewLabel_6.setBounds(187, 185, 54, 15);
		add(lblNewLabel_6);
		
		cAddress = new JTextField();
		cAddress.setBounds(298, 82, 139, 21);
		add(cAddress);
		cAddress.setColumns(10);
		
		cPostCode = new JTextField();
		cPostCode.setBounds(298, 107, 139, 21);
		add(cPostCode);
		cPostCode.setColumns(10);
		
		cTel = new JTextField();
		cTel.setBounds(298, 132, 139, 21);
		add(cTel);
		cTel.setColumns(10);
		
		cLoginName = new JTextField();
		cLoginName.setBounds(298, 157, 139, 21);
		add(cLoginName);
		cLoginName.setColumns(10);
		
		cPassword = new JPasswordField();
		cPassword.setBounds(298, 182, 139, 21);
		add(cPassword);
		
		JButton join = new JButton("\u6CE8\u518C");
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag = false;
				String sex = "";
				sex = (boy.isSelected())? "男" :  "女";
				String name = cName.getText();
				String address = cAddress.getText();
				String postcode = cPostCode.getText();
				String tel = cTel.getText();
				String loginname = cLoginName.getText();
				String password = new String(cPassword.getPassword());
				flag = Regex.checkReg(name, postcode, tel, loginname, password);
				
				if(flag){
					Connection conn = JDBCUtil.getConn();
					CallableStatement cs;
					try {
						cs = conn.prepareCall("{call new_c(?,?,?,?,?,?,?)}");
						cs.setString(1, name);
						cs.setString(2, sex);
						cs.setString(3, address);
						cs.setString(4, postcode);
						cs.setString(5, tel);
						cs.setString(6, loginname);
						cs.setString(7, password);
						int i = cs.executeUpdate();
						cs.close();
						conn.close();
						if(i == 1){
							JOptionPane.showMessageDialog(null, "添加成功");
							cName.setText("");
							cAddress.setText("");
							cPostCode.setText("");
							cTel.setText("");
							cLoginName.setText("");
							cPassword.setText("");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
			}
		});
		join.setBounds(187, 263, 93, 23);
		add(join);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cName.setText("");
				cAddress.setText("");
				cPostCode.setText("");
				cTel.setText("");
				cLoginName.setText("");
				cPassword.setText("");
				girl.setSelected(false);
				boy.setSelected(true);
			}
		});
		reset.setBounds(344, 263, 93, 23);
		add(reset);

	}
	
	
	
	

}
