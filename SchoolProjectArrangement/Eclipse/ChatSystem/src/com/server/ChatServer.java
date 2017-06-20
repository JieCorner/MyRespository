package com.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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

/**
 * @author jie
 * @action:
 * @time:2015年12月22日
 */
public class ChatServer extends JFrame
{
	private JTextField textField;
	private JButton btnNewButton; 
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JComboBox comboBox;
	
	static private ServerLink serverlink;
	private ServerReceive serverreceive;
	ChatServer chatserver=this;
	int port=8898;
	
	ChatServer serverUI=this;
	public ChatServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("新宋体", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\ChatSystem\\src\\120.png"));
		setTitle("\u804A\u5929\u5BA4\u670D\u52A1\u5668");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnv = new JMenu("\u670D\u52A1(v)");
		mnv.setFont(new Font("新宋体", Font.PLAIN, 12));
		menuBar.add(mnv);
		
		JMenu mnh = new JMenu("\u5E2E\u52A9(h)");
		mnh.setFont(new Font("新宋体", Font.PLAIN, 12));
		menuBar.add(mnh);
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("\u7AEF\u53E3\u8BBE\u7F6E");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 10, 93, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter()        //设置端口
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				String port_str=JOptionPane.showInputDialog("请输入端口号:");
				port= Integer.parseInt(port_str);
				JOptionPane.showMessageDialog(null,"端口设置成功");
			}
		});
		button = new JButton("\u542F\u52A8\u670D\u52A1");
		button.setFont(new Font("新宋体", Font.PLAIN, 12));
		button.setBounds(129, 10, 88, 23);
		getContentPane().add(button);
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				chatserver.serverlink=new ServerLink(port,chatserver);
				
				serverlink.start();//接受连接
				
				new ServerListen(serverlink).start();
				
			}
		});
		button_1 = new JButton("\u505C\u6B62\u670D\u52A1");
		button_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		button_1.setBounds(227, 10, 93, 23);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(serverlink==null)
				{
					JOptionPane.showMessageDialog(null,"服务器未启动");
				}
				else
				{
					serverlink.interrupt();
					if(serverlink.isInterrupted())
					{
						button.setEnabled(true);
						JOptionPane.showMessageDialog(null,"服务器已经关闭");
					}
				}
				
			}
		});
		button_2 = new JButton("\u9000\u51FA");
		button_2.setFont(new Font("新宋体", Font.PLAIN, 12));
		button_2.setBounds(342, 10, 67, 23);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener()   
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		label = new JLabel("\u53D1 \u9001 \u81F3\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 12));
		label.setBounds(10, 353, 67, 28);
		getContentPane().add(label);
		
		label_1 = new JLabel("\u53D1\u9001\u6D88\u606F\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		label_1.setBounds(10, 385, 67, 23);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(69, 385, 277, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		button_3 = new JButton("\u53D1\u9001");
		button_3.setFont(new Font("新宋体", Font.PLAIN, 12));
		button_3.setBounds(359, 385, 65, 23);
		getContentPane().add(button_3);
		button_3.addActionListener(new ActionListener()    //发送消息             
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				String msg=chatserver.getTextField().getText();
				serverlink.chatserver.getTextArea().append("【服务器】" +msg + "\n");
				serverlink.chatserver.getTextField().setText("");
				for(Socket socket:serverlink.userlinklist.getUserlinklist())
				{
						try
						{
							new PrintWriter(socket.getOutputStream(), true).println("【服务器】" + msg);
						} catch (IOException e1)
						{
							e1.printStackTrace();
						};
				}
			}
		});
		lblNewLabel = new JLabel("\u5728\u7EBF\u7528\u62370\u4EBA");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(10, 418, 125, 15);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 434, 309);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("新宋体", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6240\u6709"}));
		comboBox.setBounds(71, 357, 104, 21);
		getContentPane().add(comboBox);
		setSize(449, 504);
		setVisible(true);
	}
	public JButton getButton()
	{
		return button;
	}
	public JTextArea getTextArea()
	{
		return textArea;
	}
	public JTextField getTextField()
	{
		return textField;
	}
	public JComboBox getComboBox()
	{
		return comboBox;
	}
	public JLabel getLblNewLabel()
	{
		return lblNewLabel;
	}
	public static void main(String[] args)
	{
		ChatServer s=new ChatServer();

	}
}
