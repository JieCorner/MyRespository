package com.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.util.JDBCUtil;

public class SelectCustomer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7864808347634068053L;
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public SelectCustomer() {
		createJP();
	}
	
	public SelectCustomer(int i) {
		createJP2(i);
	}
	
	public void createJP(){
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 635, 396);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "姓名", "性别", "地址", "邮政编码", "电话"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement("select * from Customer");
			rs = ps.executeQuery();
			while(rs.next()){
				tableModel.addRow(new Object[]{rs.getObject(1), rs.getObject(2), rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6)});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createJP2(int i ){
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 635, 319);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "姓名", "性别", "地址", "邮政编码", "电话"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement("select * from Customer where cID = ?");
			ps.setInt(1, i);
			rs = ps.executeQuery();
			while(rs.next()){
				tableModel.addRow(new Object[]{rs.getObject(1), rs.getObject(2), rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6)});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
