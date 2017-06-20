package com.Order;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.util.JDBCUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JComboBox comboBox_1, comboBox;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public NewOrder() {
		setTitle("\u589E\u52A0\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 331, 175);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5BA2\u6237");
		lblNewLabel.setBounds(104, 28, 54, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1");
		lblNewLabel_1.setBounds(104, 53, 54, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u6570\u91CF");
		lblNewLabel_2.setBounds(104, 78, 54, 15);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(168, 75, 83, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(168, 25, 83, 21);
		comboBox.setModel(new DefaultComboBoxModel(load_cID()));
		panel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 50, 83, 21);
		comboBox_1.setModel(new DefaultComboBoxModel(load_mID()));
		panel.add(comboBox_1);

		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 add();
			}
		});
		btnNewButton.setBounds(138, 127, 93, 23);
		panel.add(btnNewButton);
		this.setVisible(true);
	}

	public static String[] load_cID() {
		String Customers[];
		Connection conn;
		Statement stmt;
		String sql = "select cID from Customer";
		try {
			conn = JDBCUtil.getConn();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
			int num_cus = rs.getRow();
			rs.first();
			rs.previous();
			Customers = new String[num_cus];
			for (int i = 0; (i < num_cus) && rs.next(); i++) {
				Customers[i] = rs.getString("cID");
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		return Customers;
	}

	public static String[] load_mID() {
		String Merchandises[];
		Connection conn;
		Statement stmt;
		String sql = "select mID from Merchandise";
		try {
			conn = JDBCUtil.getConn();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
			int num_mer = rs.getRow();
			rs.first();
			rs.previous();
			Merchandises = new String[num_mer];
			for (int i = 0; (i < num_mer) && rs.next(); i++) {
				Merchandises[i] = rs.getString("mID");
			}
			JDBCUtil.close(rs, stmt, conn);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		return Merchandises;
	}

	public static void newOrder(int oNum, int cID, int mID) {
		Connection conn = null;
		CallableStatement cs = null;
		conn = JDBCUtil.getConn();
		try {
			cs = conn.prepareCall("{call new_order(?,?,?,?,?)}");
			String oID = String.valueOf(new java.util.Date().getTime());
			cs.setString(1, oID);
			cs.setInt(2, oNum);
			cs.setDate(3, new Date(System.currentTimeMillis()));
			cs.setInt(4, cID);
			cs.setInt(5, mID);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		newOrder(Integer.valueOf(textField_2.getText()),
				Integer.valueOf((String) comboBox.getSelectedItem()),
				Integer.valueOf((String) comboBox_1.getSelectedItem()));
		JOptionPane.showMessageDialog(null, "添加订单成功");
		this.setVisible(false);
	}
}
