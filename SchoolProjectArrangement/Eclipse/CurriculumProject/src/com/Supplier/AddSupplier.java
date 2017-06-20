package com.Supplier;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.util.JDBCUtil;
import com.util.Regex;

public class AddSupplier extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1072625780223831296L;
	private JTextField sName;
	private JTextField sDescribe;
	private JTextField sAddress;
	private JTextField sPostCode;
	private JTextField sTel;
	private JTextField sMail;
	private JTextField sLoginName;
	private JPasswordField sPassword;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings(value = { "all" })
	public AddSupplier() {
		setBounds(0, 0, 635, 376);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u540D");
		lblNewLabel.setBounds(160, 45, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u63CF\u8FF0");
		lblNewLabel_1.setBounds(160, 70, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6210\u7ACB\u65F6\u95F4");
		lblNewLabel_2.setBounds(160, 95, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5730\u5740");
		lblNewLabel_3.setBounds(160, 120, 54, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u90AE\u653F\u7F16\u7801");
		lblNewLabel_4.setBounds(160, 145, 54, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setBounds(160, 170, 54, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u90AE\u7BB1");
		lblNewLabel_6.setBounds(160, 195, 54, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u6CE8\u518C\u540D");
		lblNewLabel_7.setBounds(160, 220, 54, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u5BC6\u7801");
		lblNewLabel_8.setBounds(160, 245, 54, 15);
		add(lblNewLabel_8);
		
		sName = new JTextField();
		sName.setBounds(224, 42, 178, 21);
		add(sName);
		sName.setColumns(10);
		
		sDescribe = new JTextField();
		sDescribe.setBounds(224, 67, 178, 21);
		add(sDescribe);
		sDescribe.setColumns(10);
		
		sAddress = new JTextField();
		sAddress.setBounds(224, 117, 178, 21);
		add(sAddress);
		sAddress.setColumns(10);
		
		sPostCode = new JTextField();
		sPostCode.setBounds(224, 142, 178, 21);
		add(sPostCode);
		sPostCode.setColumns(10);
		
		sTel = new JTextField();
		sTel.setBounds(224, 167, 178, 21);
		add(sTel);
		sTel.setColumns(10);
		
		sMail = new JTextField();
		sMail.setBounds(224, 192, 178, 21);
		add(sMail);
		sMail.setColumns(10);
		
		sLoginName = new JTextField();
		sLoginName.setBounds(224, 217, 178, 21);
		add(sLoginName);
		sLoginName.setColumns(10);
		
		sPassword = new JPasswordField();
		sPassword.setBounds(224, 242, 178, 21);
		add(sPassword);
		
		final JComboBox y = new JComboBox();
		y.setModel(new DefaultComboBoxModel(new String[] { "2015",
				"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007",
				"2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
				"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991",
				"1990", "1989", "1988", "1987", "1986" }));
		y.setBounds(224, 92, 54, 21);
		add(y);
		
		final JComboBox d = new JComboBox();
		d.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		d.setBounds(401, 92, 54, 21);
		add(d);
		
		
		
		final JComboBox m = new JComboBox();
		m.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		m.setBounds(305, 92, 59, 21);
		add(m);
		
		JLabel label_n = new JLabel("\u5E74");
		label_n.setBounds(284, 95, 17, 15);
		add(label_n);
		
		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(374, 95, 17, 15);
		add(label_1);
		
		JLabel lblNewLabel_9 = new JLabel("\u65E5");
		lblNewLabel_9.setBounds(465, 95, 17, 15);
		add(lblNewLabel_9);
		
		JButton join = new JButton("\u6DFB\u52A0");
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = sName.getText();
				String describe = sDescribe.getText();
				String address = sAddress.getText();
				String postcode = sPostCode.getText();
				String tel = sTel.getText();
				String mail = sMail.getText();
				String loginname = sLoginName.getText();
				String password = new String(sPassword.getPassword());
				String year = (String) y.getSelectedItem();
				String month = (String) m.getSelectedItem();
				String day = (String) d.getSelectedItem();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
				long l = 0;
				try {
					l = sFormat.parse(year + "-" + month + "-" + day).getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Date date = new Date(l);
				boolean flag = Regex.checkReg(name, address, postcode, tel, mail, loginname, password);
				
				if(flag){
					Connection conn = JDBCUtil.getConn();
					CallableStatement cs;
					
					try {
						cs = conn.prepareCall("{call new_s(?,?,?,?,?,?,?,?,?)}");
						cs.setString(1, name);
						cs.setString(2, describe);
						cs.setDate(3, date);
						cs.setString(4, address);
						cs.setString(5, postcode);
						cs.setString(6, tel);
						cs.setString(7, mail);
						cs.setString(8, loginname);
						cs.setString(9, password);
						int i = cs.executeUpdate();
						cs.close();
						conn.close();
						if(i == 1){
							JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
							sName.setText("");
							sDescribe.setText("");
							sAddress.setText("");
							sPostCode.setText("");
							sTel.setText("");
							sMail.setText("");
							sLoginName.setText("");
							sPassword.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		join.setBounds(160, 300, 93, 23);
		add(join);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sName.setText("");
				sDescribe.setText("");
				sAddress.setText("");
				sPostCode.setText("");
				sTel.setText("");
				sMail.setText("");
				sLoginName.setText("");
				sPassword.setText("");
			}
		});
		reset.setBounds(309, 300, 93, 23);
		add(reset);
	}
	
	
}
