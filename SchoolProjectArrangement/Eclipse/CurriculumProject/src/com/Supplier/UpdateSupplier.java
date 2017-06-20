package com.Supplier;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.util.JDBCUtil;

public class UpdateSupplier extends JPanel {
	
	private JTextField sName;
	private JTextField sDescribe;
	private JTextField sAddress;
	private JTextField sPostCode;
	private JTextField sTel;
	private JTextField sMail;
	private JTextField id;
	private int sID;
	private String name;
	private String describe;
	private String address;
	private String postcode;
	private String tel;
	private String mail;
	private Date regtime;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings(value = { "all" })
	public UpdateSupplier() {
		setBounds(0, 0, 635, 376);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u540D");
		lblNewLabel.setBounds(160, 79, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u63CF\u8FF0");
		lblNewLabel_1.setBounds(160, 104, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6210\u7ACB\u65F6\u95F4");
		lblNewLabel_2.setBounds(160, 129, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5730\u5740");
		lblNewLabel_3.setBounds(160, 154, 54, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u90AE\u653F\u7F16\u7801");
		lblNewLabel_4.setBounds(160, 179, 54, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setBounds(160, 204, 54, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u90AE\u7BB1");
		lblNewLabel_6.setBounds(160, 229, 54, 15);
		add(lblNewLabel_6);
		
		sName = new JTextField();
		sName.setBounds(224, 76, 178, 21);
		add(sName);
		sName.setColumns(10);
		
		sDescribe = new JTextField();
		sDescribe.setBounds(224, 101, 178, 21);
		add(sDescribe);
		sDescribe.setColumns(10);
		
		sAddress = new JTextField();
		sAddress.setBounds(224, 151, 178, 21);
		add(sAddress);
		sAddress.setColumns(10);
		
		sPostCode = new JTextField();
		sPostCode.setBounds(224, 176, 178, 21);
		add(sPostCode);
		sPostCode.setColumns(10);
		
		sTel = new JTextField();
		sTel.setBounds(224, 201, 178, 21);
		add(sTel);
		sTel.setColumns(10);
		
		sMail = new JTextField();
		sMail.setBounds(224, 226, 178, 21);
		add(sMail);
		sMail.setColumns(10);
		
		final JComboBox y = new JComboBox();
		y.setModel(new DefaultComboBoxModel(new String[] { "2015",
				"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007",
				"2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
				"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991",
				"1990", "1989", "1988", "1987", "1986" }));
		y.setBounds(224, 126, 54, 21);
		add(y);
		
		final JComboBox d = new JComboBox();
		d.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		d.setBounds(401, 126, 54, 21);
		add(d);
		
		
		
		final JComboBox m = new JComboBox();
		m.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		m.setBounds(305, 126, 59, 21);
		add(m);
		
		JLabel label_n = new JLabel("\u5E74");
		label_n.setBounds(284, 129, 17, 15);
		add(label_n);
		
		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(374, 129, 17, 15);
		add(label_1);
		
		JLabel lblNewLabel_9 = new JLabel("\u65E5");
		lblNewLabel_9.setBounds(465, 129, 17, 15);
		add(lblNewLabel_9);
		
		JButton join = new JButton("\u4FEE\u6539");
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection conn = null;
				CallableStatement cs = null;
				
				String year = (String) y.getSelectedItem();
				String month = (String) m.getSelectedItem();
				String day = (String) d.getSelectedItem();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
				long l = 0;
				if (checkReg(sName.getText(), sAddress.getText(),
						sPostCode.getText(), sTel.getText(), sMail.getText())) {
					try {
						l = sFormat.parse(year + "-" + month + "-" + day)
								.getTime();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					Date date = new Date(l);

					try {
						conn = JDBCUtil.getConn();
						cs = conn
								.prepareCall("{call update_s(?,?,?,?,?,?,?,?)}");
						cs.setString(1, sName.getText());
						cs.setString(2, sDescribe.getText());
						cs.setDate(3, date);
						cs.setString(4, sAddress.getText());
						cs.setString(5, sPostCode.getText());
						cs.setString(6, sTel.getText());
						cs.setString(7, sMail.getText());
						cs.setInt(8, sID);

						int i = cs.executeUpdate();
						cs.close();
						conn.close();
						if (i == 1) {
							JOptionPane.showMessageDialog(null, "修改成功");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		join.setBounds(254, 301, 93, 23);
		add(join);
		
		JLabel lblNewLabel_7 = new JLabel("\u88AB\u4FEE\u6539\u4F9B\u5E94\u5546\u7F16\u53F7");
		lblNewLabel_7.setBounds(160, 44, 118, 15);
		add(lblNewLabel_7);
		
		id = new JTextField();
		id.setBounds(281, 41, 83, 21);
		add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sID = Integer.valueOf(id.getText());
				
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				
				try {
					conn = JDBCUtil.getConn();
					ps = conn.prepareStatement("select sName,sDescribe,sAddress,sRegtime,sPostcode,sTel,sMail  from Supplier where sID = ?");
					ps.setInt(1, sID);
					rs = ps.executeQuery();
					rs.next();
					
					name = rs.getString(1);
					describe = rs.getString(2);
					address = rs.getString(3);
					regtime = rs.getDate(4);
					postcode = rs.getString(5);
					tel = rs.getString(6);
					mail = rs.getString(7);
					rs.close();
					ps.close();
					conn.close();
					
					sName.setText(name);
					sDescribe.setText(describe);
					sAddress.setText(address);
					sPostCode.setText(postcode);
					sTel.setText(tel);
					sMail.setText(mail);
					
					SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");				
					String[] y_d_m = sFormat.format(regtime).split("-");
					String year = y_d_m[0];
					String month = y_d_m[1];
					String day = y_d_m[2];
					y.setSelectedItem(year);
					m.setSelectedItem(month);
					d.setSelectedItem(day);
	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(389, 40, 66, 23);
		add(btnNewButton);
	}
	
	public static boolean checkReg(String sName, String sAddress,
			String sPostCode, String sTel, String sMail) {
		String msg = "";	
		
		String sName_regex = ".{1,32}";
		String sAddress_regex = ".{1,100}";
		String sPostCode_regex = "[1-9]\\d{5}(?!\\d)";
		String sTel_regex = "[1][358][0-9]{9}";
		String sMail_regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
		
		boolean sName_flag = sName.matches(sName_regex);
		boolean sAddress_flag = sAddress.matches(sAddress_regex);
		boolean sPostCode_flag = sPostCode.matches(sPostCode_regex);
		boolean sTel_flag = sTel.matches(sTel_regex);
		boolean sMail_flag = sMail.matches(sMail_regex);
		
		if(!sMail_flag) msg += "邮箱,";
		if(!sAddress_flag) msg+="地址,";
		if (!sName_flag) msg += "姓名,";
		if (!sPostCode_flag) msg += "邮政编码,";
		if (!sTel_flag) msg += "电话号码,";
		
		if(!(sName_flag && sAddress_flag  && sPostCode_flag && sTel_flag && sMail_flag )){
			JOptionPane.showMessageDialog(null, msg + "格式不正确");
		}
		

		return (sName_flag && sAddress_flag  && sPostCode_flag && sTel_flag && sMail_flag)?true:false;

	}

}
