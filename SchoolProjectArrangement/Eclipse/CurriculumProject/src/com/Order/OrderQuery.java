package com.Order;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.util.JDBCUtil;

public class OrderQuery extends JFrame
{
	private JButton button;
	private JButton button_1 ;
	private JTable table;
	OrderQuery Order=this;
	private JTextField textField;
	public OrderQuery() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u8BA2\u5355\u4FE1\u606F\u7BA1\u7406\u67E5\u8BE2");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 505, 174);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u5546\u54C1", "\u5BA2\u6237\u7F16\u53F7", "\u6570\u91CF", "\u91D1\u989D", "\u8BA2\u5355\u65F6\u95F4"
			}
		));
		scrollPane.setViewportView(table);
		//设置表格列的宽度
		TableColumn setColumn = table.getColumnModel().getColumn(0);
		setColumn.setPreferredWidth(100);
		setColumn = table.getColumnModel().getColumn(3);
		setColumn.setPreferredWidth(30);
		setColumn = table.getColumnModel().getColumn(5);
		setColumn.setPreferredWidth(120);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7\uFF1A");
		label.setBounds(123, 184, 114, 24);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(228, 186, 169, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u6E05\u7A7A");
		button.setBounds(123, 218, 93, 23);
		getContentPane().add(button);
		
		button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(304, 218, 93, 23);
		getContentPane().add(button_1);
		
		button.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				Order.textField.setText("");
				Order.table.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] {
								"\u8BA2\u5355\u53F7", "\u5546\u54C1", "\u5BA2\u6237\u7F16\u53F7", "\u6570\u91CF", "\u91D1\u989D", "\u8BA2\u5355\u65F6\u95F4"
							}
						));
				TableColumn setColumn = table.getColumnModel().getColumn(0);
				setColumn.setPreferredWidth(100);
				setColumn = table.getColumnModel().getColumn(3);
				setColumn.setPreferredWidth(30);
				setColumn = table.getColumnModel().getColumn(5);
				setColumn.setPreferredWidth(120);
			}
		});
		button_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				String str_OQ=Order.textField.getText();
				String str_OQFind="select oID,mID,cID,oNum,oAmount,oTime from OrderInfo where oID=?";
				Connection conn_OQ = JDBCUtil.getConn();
				PreparedStatement Order_OQ;
				CallableStatement cs_O ;
				try
				{
					cs_O= conn_OQ.prepareCall("{call OQ_orexist(?,?)}");
					cs_O.setString(1,str_OQ);
					cs_O.registerOutParameter(2,Types.INTEGER);
					cs_O.execute();
					int row_MQ=cs_O.getInt(2);
					//参数
					if(row_MQ!=0)
					{
						cs_O.close();
						Order_OQ = conn_OQ.prepareStatement(str_OQFind);
						Order_OQ.setString(1, str_OQ);    //传入mID的数值
						ResultSet Ors_OQ=Order_OQ.executeQuery(); //得到结果集
						Order.table.setEnabled(false);  //设置表格不能修改
						DefaultTableModel tableModel = (DefaultTableModel)Order.table.getModel();
						while(Ors_OQ.next())
						{
							tableModel.addRow(new Object[]{Ors_OQ.getObject(1), Ors_OQ.getObject(2), 
									Ors_OQ.getObject(3),Ors_OQ.getObject(4),Ors_OQ.getObject(5)
									,Ors_OQ.getObject(6)});
						}
						JDBCUtil.close(Ors_OQ, Order_OQ, conn_OQ);
					}
					else{
						//查询数据不存在
						//跳出窗口
						JOptionPane.showMessageDialog(null,"所查询订单不存在");
					}

				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		setSize(521, 300);
		setVisible(true);
	}
	
}
