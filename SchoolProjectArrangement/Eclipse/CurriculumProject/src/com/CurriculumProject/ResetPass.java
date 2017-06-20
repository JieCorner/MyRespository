package com.CurriculumProject;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.swing.JTextField;

import com.util.JDBCUtil;

public class ResetPass extends JDialog{
	JPanel panel;
	JPasswordField oldPassword;
	JPasswordField newPassword;	
	private JTextField admint;
	ResetPass resetPass;
	
	public ResetPass() {
		setTitle("\u5BC6\u7801\u4FEE\u6539");
	setBounds(100, 100, 352, 229);
	getContentPane().setLayout(null);
	panel = new JPanel();
	panel.setLayout(null);	
	
	resetPass = this;
	
	JLabel lblNewLabel = new JLabel("旧密码");
	lblNewLabel.setBounds(10, 49, 105, 23);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("新密码");
	lblNewLabel_1.setBounds(10, 82, 105, 23);
	panel.add(lblNewLabel_1);
	
	oldPassword = new JPasswordField();
	oldPassword.setBounds(148, 50, 147, 23);
	panel.add(oldPassword);
	
	newPassword = new JPasswordField();
	newPassword.setBounds(148, 83, 147, 22);
	panel.add(newPassword);
	
	JButton btnNewButton = new JButton("确认");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int flag = 
			resetPass(admint.getText(), new String(oldPassword.getPassword()), new String(newPassword.getPassword()));
			if(flag == 0){
				JOptionPane.showMessageDialog(null, "管理员不存在");
			}else if (flag == 1){
				JOptionPane.showMessageDialog(null, "旧密码错误");
			}else if (flag == 2){
				JOptionPane.showMessageDialog(null, "修改成功");
				resetPass.setVisible(false);
			}
		}
	});
	btnNewButton.setBounds(10, 137, 93, 23);
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("重置");
	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			admint.setText("");
			oldPassword.setText("");
			newPassword.setText("");
		}
	});
	btnNewButton_1.setBounds(202, 137, 93, 23);
	panel.add(btnNewButton_1);
	
	panel.add(oldPassword);
	panel.setBounds(10, 10, 313, 170);
	panel.setVisible(true);
	getContentPane().add(panel);
	
	JLabel admin = new JLabel("\u7BA1\u7406\u5458");
	admin.setBounds(10, 16, 105, 23);
	panel.add(admin);
	
	admint = new JTextField();
	admint.setBounds(148, 19, 147, 21);
	panel.add(admint);
	admint.setColumns(10);
	
	}	
	
	public int  resetPass(String adminname,String oldpass,String newpass){
		int flag = 0;
		Connection conn = null;
		CallableStatement cs = null;
		try {
			conn = JDBCUtil.getConn();
			cs = conn.prepareCall("{call reset_pass(?,?,?,?)}");
			cs.setString(1, adminname);
			cs.setString(2, oldpass);
			cs.setString(3, newpass);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			flag = cs.getInt(4);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{		
			JDBCUtil.close(cs, conn);
		}
		return flag;
			
	}
}
