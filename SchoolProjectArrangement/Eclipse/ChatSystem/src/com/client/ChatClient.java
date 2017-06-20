package com.client;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JCheckBox;


/**
 * @author jie
 * @action:
 * @time:2015年12月22日
 */
public class ChatClient extends JFrame
{
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextArea textArea;
	private JComboBox comboBox_1;
	private JCheckBox checkBox;
	private JComboBox comboBox;
	String UserName_cli;
	ClientReceive clientreceive;
	ChatClient ClientUI=this;
	String port_server="8898";
	String ip_server="127.0.0.1";
	public ChatClient() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setFont(new Font("新宋体", Font.PLAIN, 12));
			setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\ChatSystem\\src\\120.png"));
			setTitle("\u804A\u5929\u5BA4\u5BA2\u6237\u5668");
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnv = new JMenu("\u64CD\u4F5C(O)");
			mnv.setFont(new Font("新宋体", Font.PLAIN, 12));
			menuBar.add(mnv);
			
			JMenu mnc = new JMenu("\u8BBE\u7F6E(C)");
			mnc.setFont(new Font("新宋体", Font.PLAIN, 12));
			menuBar.add(mnc);
			
			JMenu mnh = new JMenu("\u5E2E\u52A9(H)");
			mnh.setFont(new Font("新宋体", Font.PLAIN, 12));
			menuBar.add(mnh);
			getContentPane().setLayout(null);
			
			JButton btnNewButton = new JButton("\u7528\u6237\u8BBE\u7F6E");
			btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 11));
			btnNewButton.setBounds(10, 7, 81, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					UserName_cli=JOptionPane.showInputDialog("请输入用户名:");
				}
			});
			
			button = new JButton("\u8FDE\u63A5\u8BBE\u7F6E");      //设置连接
			button.setFont(new Font("新宋体", Font.PLAIN, 11));
			button.setBounds(101, 9, 81, 23);
			getContentPane().add(button);
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					ip_server=JOptionPane.showInputDialog("请输入服务器地址:");
					port_server=JOptionPane.showInputDialog("请输入端口号:");
				}
			});
			button_1 = new JButton("\u767B\u9646");
			button_1.setFont(new Font("新宋体", Font.PLAIN, 11));
			button_1.setBounds(204, 9, 67, 23);
			getContentPane().add(button_1);
			button_1.addActionListener(new ActionListener()      //登录
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					// TODO Auto-generated method stub
					clientreceive=new ClientReceive(ClientUI,ClientUI.port_server,ClientUI.ip_server);
					clientreceive.start();
					clientreceive.sendname(UserName_cli);
					ClientUI.button_1.setText("已登录");
					ClientUI.setTitle("聊天室客户端"+"【"+UserName_cli+"】");
					ClientUI.button_1.setEnabled(false);
				}
			});
			
			button_2 = new JButton("\u9000\u51FA");         
			button_2.setFont(new Font("新宋体", Font.PLAIN, 11));
			button_2.setBounds(359, 9, 67, 23);
			getContentPane().add(button_2);
			button_2.addActionListener(new ActionListener()         //退出
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					// TODO Auto-generated method stub
					try
					{
						clientreceive.sendQuit(UserName_cli);
						clientreceive.sc.close();
						System.exit(0);
					} catch (IOException e1)
					{
						JOptionPane.showMessageDialog(null,"还未登录，请直接关闭窗口");
					}catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null,"还未登录，请直接关闭窗口");
					}
				}
			});
			label = new JLabel("\u53D1 \u9001 \u81F3\uFF1A");
			label.setFont(new Font("新宋体", Font.PLAIN, 12));
			label.setBounds(10, 360, 67, 28);
			getContentPane().add(label);
			label_1 = new JLabel("\u53D1\u9001\u6D88\u606F\uFF1A");
			label_1.setFont(new Font("新宋体", Font.PLAIN, 12));
			label_1.setBounds(10, 398, 67, 23);
			getContentPane().add(label_1);
			
			textField = new JTextField();
			textField.setBounds(74, 398, 277, 23);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			button_3 = new JButton("\u53D1\u9001");
			button_3.setFont(new Font("新宋体", Font.PLAIN, 12));
			button_3.setBounds(361, 398, 65, 23);
			getContentPane().add(button_3);
			button_3.addActionListener(new ActionListener()      //发送消息
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String msg=textField.getText();
					if(msg.contains("**@")||msg.contains(":&")||msg.contains(":%"))
					{
						JOptionPane.showMessageDialog(null,"错误,' **@ ',' :& ',' :% '三种符号为限制符号，请勿使用");
					}else{
						try
						{
							clientreceive.sendMsg(msg,(String)comboBox.getSelectedItem());
							
						} catch (Exception e1)
						{
							JOptionPane.showMessageDialog(null,"错误,请确保您已经在登录状态下");
						}
					}
				}
			});
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 41, 434, 309);
			getContentPane().add(scrollPane);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			
			comboBox = new JComboBox();
			comboBox.setFont(new Font("新宋体", Font.PLAIN, 12));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6240\u6709"}));
			comboBox.setBounds(74, 364, 88, 21);
			getContentPane().add(comboBox);
			
			
			button_4 = new JButton("\u6CE8\u9500");            //注销
			button_4.setFont(new Font("新宋体", Font.PLAIN, 11));
			button_4.setBounds(270, 9, 57, 23);
			getContentPane().add(button_4);
			button_4.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						clientreceive.sendQuit(UserName_cli);
						clientreceive.sc.close();
					} catch (IOException e1)
					{
						JOptionPane.showMessageDialog(null,"还未登录，无法注销");
					}catch (Exception e2)
					{
						JOptionPane.showMessageDialog(null,"还未登录，无法注销");
					}
					ClientUI.button_1.setEnabled(true);
					ClientUI.button_1.setText("登录");
				}
			});
			
			label_2 = new JLabel("\u8868\u60C5\uFF1A");
			label_2.setFont(new Font("新宋体", Font.PLAIN, 12));
			label_2.setBounds(182, 367, 54, 15);
			getContentPane().add(label_2);
			
			comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("新宋体", Font.PLAIN, 12));
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u65E0", "\u5FAE\u7B11\u5730", "\u751F\u6C14\u5730", "\u65E0\u8BED\u5730", "\u7231\u5FC3"}));
		comboBox_1.setBounds(214, 364, 67, 21);
			getContentPane().add(comboBox_1);
			comboBox_1.addActionListener(new ActionListener()       //设置表情
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String selectstr=(String)comboBox_1.getSelectedItem();
					if("微笑地".equals(selectstr))
					{
						ClientUI.textField.setText(ClientUI.textField.getText()+"^-^");
					}
					if("生气地".equals(selectstr))
					{
						ClientUI.textField.setText(ClientUI.textField.getText()+"<(－︿－)> ");
					}
					if("无语地".equals(selectstr))
					{
						ClientUI.textField.setText(ClientUI.textField.getText()+"0-0''");
					}
					if("爱心".equals(selectstr))
					{
						ClientUI.textField.setText(ClientUI.textField.getText()+"(*＾-＾*) ");
					}
				}
			});
			checkBox = new JCheckBox("\u6084\u6084\u8BDD");
			checkBox.setFont(new Font("新宋体", Font.PLAIN, 12));
			checkBox.setBounds(353, 363, 81, 23);
			getContentPane().add(checkBox);
			setSize(450, 504);
			setVisible(true);
	}
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public JCheckBox getCheckBox()
	{
		return checkBox;
	}
	public JComboBox getComboBox()
	{
		return comboBox;
	}
	public JTextField getTextField()
	{
		return textField;
	}
	public static void main(String[] args)
	{
		ChatClient c=new ChatClient();
	}
}
