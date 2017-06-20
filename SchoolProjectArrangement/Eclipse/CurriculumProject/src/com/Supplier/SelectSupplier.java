package com.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.JDBCUtil;

public class SelectSupplier extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public SelectSupplier() {
		createJP();

	}
	
	public SelectSupplier(int i) {
		createJP2(i);

	}
	
	public void createJP(){
		setLayout(null);
		setBounds(0, 0, 635, 376);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 635, 376);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"编号","供应商名称","简介","注册时间","地址","邮政编码","电话","邮箱",
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement("select * from Supplier");
			rs = ps.executeQuery();
			while(rs.next()){
				tableModel.addRow(new Object[]{rs.getObject(1), rs.getObject(2), rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8)});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createJP2(int i){
		setLayout(null);
		setBounds(0, 0, 635, 376);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 635, 319);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"编号","供应商名称","简介","注册时间","地址","邮政编码","电话","邮箱",
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement("select * from Supplier where sID = ?");
			ps.setInt(1, i);
			rs = ps.executeQuery();
			while(rs.next()){
				tableModel.addRow(new Object[]{rs.getObject(1), rs.getObject(2), rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8)});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
