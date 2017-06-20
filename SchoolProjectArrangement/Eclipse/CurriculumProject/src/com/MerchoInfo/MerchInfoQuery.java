package com.MerchoInfo;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.util.JDBCUtil;

public class MerchInfoQuery extends JFrame
{
	private JTable table;
	private JButton button_1; //查询按钮
	MerchInfoQuery Merch=this;
	private JButton button;   //清空按钮
	private JTextField textField;

	public MerchInfoQuery() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("新宋体", Font.PLAIN, 12));
		setTitle("\u5546\u54C1\u4FE1\u606F\u67E5\u8BE2");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 505, 22);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("\u5546\u54C1\u4FE1\u606F\u67E5\u8BE2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 21, 505, 225);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][]{},
			new String[] {
				"\u5546\u54C1\u540D\u79F0", "\u4F9B\u5E94\u5546\u7F16\u53F7", "\u5546\u6807", "\u5546\u54C1\u578B\u53F7", "\u5546\u54C1\u63CF\u8FF0", "\u5355\u4EF7", "\u5E93\u5B58"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_1.setBounds(124, 256, 119, 22);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(223, 257, 160, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u6E05\u7A7A");
		button.setBounds(124, 287, 93, 23);
		getContentPane().add(button);
		
		button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(290, 288, 93, 23);
		getContentPane().add(button_1);
		
		//清空内容
		button.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Merch.textField.setText("");
				Merch.table.setModel(new DefaultTableModel(
						new Object[][]{
						},
						new String[] {
							"\u5546\u54C1\u540D\u79F0", "\u4F9B\u5E94\u5546\u7F16\u53F7", "\u5546\u6807", "\u5546\u54C1\u578B\u53F7", "\u5546\u54C1\u63CF\u8FF0", "\u5355\u4EF7", "\u5E93\u5B58"
						}
					));
			}
			
		});
		
		//查询数据
		button_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				String str_MQ=Merch.textField.getText();
				String str_MQFind="select mName,sID,logo,mType,mDescribe,mPrice,mNum from Merchandise where mID=?";
				Connection conn_MQ = JDBCUtil.getConn();
				PreparedStatement Mstate_MQ;
				CallableStatement cs ;
				try
				{
					cs= conn_MQ.prepareCall("{call MQ_orexist(?,?)}");
					cs.setString(1,str_MQ);
					cs.registerOutParameter(2,Types.INTEGER);
					cs.execute();
					int row_MQ=cs.getInt(2);
					//参数
					if(row_MQ!=0)
					{
						cs.close();
						Mstate_MQ = conn_MQ.prepareStatement(str_MQFind);
						Mstate_MQ.setString(1, str_MQ);    //传入mID的数值
						ResultSet Mrs_MQ=Mstate_MQ.executeQuery(); //得到结果集
						Merch.table.setEnabled(false);  //设置表格不能修改
						DefaultTableModel tableModel = (DefaultTableModel)Merch.table.getModel();
						while(Mrs_MQ.next())
						{
							tableModel.addRow(new Object[]{Mrs_MQ.getObject(1), Mrs_MQ.getObject(2), 
									Mrs_MQ.getObject(3),Mrs_MQ.getObject(4),Mrs_MQ.getObject(5)
									,Mrs_MQ.getObject(6),Mrs_MQ.getObject(7)});
						}
						JDBCUtil.close(Mrs_MQ, Mstate_MQ, conn_MQ);
					}
					else{
						//查询数据不存在
						//跳出窗口
						JOptionPane.showMessageDialog(null,"所查询商品不存在");
					}
				} catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null,"所查询商品不存在");
				}
				
			}
		});
		setSize(521, 380);
		setVisible(true);
	}
}