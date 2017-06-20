package com.CurriculumProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.util.JDBCUtil;
import com.util.Regex;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8112432630256977905L;
	private JPanel contentPane;
	private JTextField userName_TF;
	private JButton submit,reset;
	private JPasswordField password_TF;
	LoginFrame lfFrame;
	SupermarketInfo si = new SupermarketInfo();

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("欢迎登陆网上商城管理系统");
		
		lfFrame = this;
		JPanel panel = new JPanel();
		panel.setBounds(39, 10, 277, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userName_LB = new JLabel("\u7528\u6237\u540D:");
		userName_LB.setBounds(10, 10, 82, 20);
		panel.add(userName_LB);
		
		JLabel password_LB = new JLabel("\u5BC6\u7801  :");
		password_LB.setBounds(10, 42, 82, 20);
		panel.add(password_LB);
		
		userName_TF = new JTextField();
		userName_TF.setBounds(102, 8, 161, 20);
		panel.add(userName_TF);
		userName_TF.setColumns(10);
		
		password_TF = new JPasswordField();
		password_TF.setBounds(102, 42, 161, 20);
		panel.add(password_TF);
		
		submit = new JButton("\u63D0\u4EA4");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = lfFrame.getUserName_TF().getText();
				String password = lfFrame.getPassword_TF().getText();
				login(username, password);	
			}
		});
		submit.setBounds(10, 81, 93, 23);
		panel.add(submit);
		
		reset = new JButton("\u91CD\u7F6E");
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lfFrame.getUserName_TF().setText("");
				lfFrame.getPassword_TF().setText("");
			}
		});
		reset.setBounds(170, 81, 93, 23);
		panel.add(reset);
	}

	public  void login(String username,String password){
		if(Regex.checkReg(username,password) == true){
			Connection conn = null;
			CallableStatement cs = null;
			try {
				conn = JDBCUtil.getConn();
				cs = conn.prepareCall("{call loginCheck(?,?,?)}");
				cs.setString(1, username);
				cs.setString(2, password);
				cs.registerOutParameter(3, Types.INTEGER);
				cs.execute();
				if(cs.getInt(3) == 0){
					JOptionPane.showMessageDialog(null, "管理员不存在");
				}else if(cs.getInt(3) == 2){
					this.setVisible(false);
					si.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "密码错误");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "连接失败");
				e.printStackTrace();
			} finally {
				JDBCUtil.close(cs,conn);			
			}		
		}
	}
	
	
	public JTextField getUserName_TF() {
		return userName_TF;
	}



	public JTextField getPassword_TF() {
		return password_TF;
	}



	public JButton getSubmit() {
		return submit;
	}



	public JButton getReset() {
		return reset;
	}
}
