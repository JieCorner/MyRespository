package com.Customer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.util.JDBCUtil;

public class UpdateCustomer extends JPanel {
	private JTextField cName;
	private JTextField cAddress;
	private JTextField cPostCode;
	private JTextField cTel;
	private JTextField id;
	private int cID;
	private String name;
	private String sex;
	private String address;
	private String postcode;
	private String tel;
	/**
	 * Create thnel.
	 */
	public UpdateCustomer() {
		
		setBounds(0, 0, 635, 376);
		setLayout(null);
		
		cName = new JTextField();
		cName.setBounds(298, 92, 139, 21);
		add(cName);
		cName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(187, 95, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setBounds(187, 120, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5730\u5740");
		lblNewLabel_2.setBounds(187, 145, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE\u653F\u7F16\u7801");
		lblNewLabel_3.setBounds(187, 170, 54, 15);
		add(lblNewLabel_3);
		
		final JRadioButton boy = new JRadioButton("\u7537",true);
		boy.setBounds(298, 116, 61, 23);
		final JRadioButton girl = new JRadioButton("\u5973");
		girl.setBounds(361, 116, 61, 23);	
		ButtonGroup sexG = new ButtonGroup();
		sexG.add(boy);
		sexG.add(girl);
		add(boy);
		add(girl);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD");
		lblNewLabel_4.setBounds(187, 195, 54, 15);
		add(lblNewLabel_4);
		
		cAddress = new JTextField();
		cAddress.setBounds(298, 142, 139, 21);
		add(cAddress);
		cAddress.setColumns(10);
		
		cPostCode = new JTextField();
		cPostCode.setBounds(298, 167, 139, 21);
		add(cPostCode);
		cPostCode.setColumns(10);
		
		cTel = new JTextField();
		cTel.setBounds(298, 192, 139, 21);
		add(cTel);
		cTel.setColumns(10);
		
		JButton update = new JButton("\u4FEE\u6539");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection conn = null;
				CallableStatement cs = null;
				
				String csex = (boy.isSelected())? "男" :  "女";
				
				if(checkReg(cName.getText(),cPostCode.getText(),cTel.getText())){
					try {
						conn = JDBCUtil.getConn();
						cs = conn.prepareCall("{call update_c(?,?,?,?,?,?)}");
						cs.setString(1, cName.getText());
						cs.setString(2, csex);
						cs.setString(3, cAddress.getText());
						cs.setString(4, cPostCode.getText());
						cs.setString(5, cTel.getText());
						cs.setInt(6, cID);
						int i = cs.executeUpdate();
						cs.close();
						conn.close();
						if (i == 1) {
							JOptionPane.showMessageDialog(null, "修改成功");
						}

					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		update.setBounds(266, 264, 93, 23);
		add(update);
		
		JLabel lblNewLabel_5 = new JLabel("\u88AB\u4FEE\u6539\u5BA2\u6237\u7F16\u53F7");
		lblNewLabel_5.setBounds(187, 42, 101, 15);
		add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(298, 39, 54, 21);
		add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cID = Integer.valueOf(id.getText());
				
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					conn = JDBCUtil.getConn();
					ps = conn.prepareStatement("select cName,cSex,cAddress,cPostCode,cTel from Customer where cID = ?");
					ps.setInt(1, cID);
					rs = ps.executeQuery();
					rs.next();
					name = rs.getString(1);	
					sex = rs.getString(2);
					address = rs.getString(3);
					postcode = rs.getString(4);
					tel = rs.getString(5);
					rs.close();
					ps.close();
					conn.close();
					
					cName.setText(name);
					if(sex.equals("男")){
						girl.setSelected(false);
						boy.setSelected(true);
					}else {
						girl.setSelected(true);
						boy.setSelected(false);
					}
					cAddress.setText(address);
					cPostCode.setText(postcode);
					cTel.setText(tel);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(361, 38, 76, 23);
		add(btnNewButton);

	}
	
	public static boolean checkReg(String cName,
			String cPostCode,String cTel){			
		String msg = "";
		
		String cName_regex = "[\u4E00-\u9FA5]{2,8}";		
		String cPostCode_regex = "[1-9]\\d{5}(?!\\d)";	
		String cTel_regex = "[1][358][0-9]{9}";	
		
		boolean cName_flag = cName.matches(cName_regex);
		boolean cPostCode_flag = cPostCode.matches(cPostCode_regex);
		boolean cTel_flag = cTel.matches(cTel_regex);
		
		if (!cName_flag) msg += "姓名,";
		if (!cPostCode_flag) msg += "邮政编码,";
		if (!cTel_flag) msg += "电话号码,";
		
		if(!(cName_flag && cPostCode_flag && cTel_flag)){
			JOptionPane.showMessageDialog(null, msg + "格式不正确");
		}

		return(cName_flag && cPostCode_flag && cTel_flag)? true:false;
	
	}
}
