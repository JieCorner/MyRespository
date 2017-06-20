package com.Order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
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

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderManager extends JFrame {
	private JTable table;
	OrderManager OrderMan = this;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private String[] Mstr_oup = null;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	public OrderManager() {
		Connection conn_oup = JDBCUtil.getConn();
		Statement Mstate_oup;
		try {
			Mstate_oup = conn_oup.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet Mrs_oup = Mstate_oup.executeQuery("select cID from Customer");
			Mrs_oup.last();
			int Mrow = Mrs_oup.getRow();
			Mrs_oup.first();
			Mrs_oup.previous();
			this.Mstr_oup = new String[Mrow + 1];
			this.Mstr_oup[0] = "所有";
			for (int i = 1; i < Mrow + 1; i++) {
				if (Mrs_oup.next()) {
					this.Mstr_oup[i] = Mrs_oup.getString("cID");
				}
			}
			JDBCUtil.close(Mrs_oup, Mstate_oup, conn_oup);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u8BA2\u5355\u4FE1\u606F\u7BA1\u7406");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 505, 174);
		getContentPane().add(scrollPane);

		table = new JTable();
		onloadOrderData("所有");

		scrollPane.setViewportView(table);

		JLabel label = new JLabel("\u5BA2\u6237\u7F16\u53F7\uFF1A");
		label.setBounds(10, 184, 77, 25);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\u6570\u91CF\uFF1A");
		label_1.setBounds(189, 186, 54, 20);
		getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(231, 186, 54, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u8BA2\u5355\u65F6\u95F4\uFF1A");
		label_2.setBounds(308, 184, 70, 25);
		getContentPane().add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(376, 186, 119, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		button = new JButton("\u8BBE\u7F6E");
		button.setBounds(10, 228, 93, 23);
		getContentPane().add(button);

		button_1 = new JButton("\u6E05\u7A7A");
		button_1.setBounds(133, 228, 93, 23);
		getContentPane().add(button_1);

		button_2 = new JButton("\u5237\u65B0");
		button_2.setBounds(270, 228, 93, 23);
		getContentPane().add(button_2);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onloadOrderData((String)comboBox.getSelectedItem());
			}
		});
		comboBox.setBounds(71, 186, 93, 23);
		comboBox.setModel(new DefaultComboBoxModel(Mstr_oup));
		getContentPane().add(comboBox);
		
		JButton button_3 = new JButton("\u589E\u52A0");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new NewOrder();
			}
		});
		button_3.setBounds(403, 228, 93, 23);
		getContentPane().add(button_3);
		// 设置按钮
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectRows_oup = OrderMan.table.getSelectedRows().length;// 取得用户所选行的行数
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				if (selectRows_oup == 1) {
					// 进行相关处理
					int selectedRowIndex = table.getSelectedRow(); // 取得用户所选单行

					Object upOrder_oID = table.getValueAt(selectedRowIndex, 0);
					Object upOrder_oNum = textField_1.getText();
					Object upOrder_oTime = textField_2.getText();
					Object upOrder_cID = (String) comboBox.getSelectedItem();
					Object upOrder_mID = table.getValueAt(selectedRowIndex, 1); // 商品ID号

					if (("".equals(upOrder_oNum)) && ("".equals(upOrder_oTime))) {
						JOptionPane.showMessageDialog(null, "请至少输入一个修改的内容");
					} else {
						if ("".equals(upOrder_oNum)) {
							upOrder_oNum = table
									.getValueAt(selectedRowIndex, 3);
							
						}
						if ("".equals(upOrder_oTime)) {
							upOrder_oTime = table.getValueAt(selectedRowIndex,
									5);
							upOrder_oTime = upOrder_oTime.toString().substring(
									0, 10);
							
						}
						// 判断单价
						Pattern p_oup = Pattern.compile("^-?\\d+$");
						Matcher m_oup = p_oup.matcher(upOrder_oNum.toString());
						boolean b_oup = m_oup.matches();
						// 判断日期
						Pattern p_oup_time = Pattern
								.compile("([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-"
										+ "(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]"
										+ "|[1][0-9]|2[0-8])))");
						Matcher m_oup_time = p_oup_time.matcher(upOrder_oTime
								.toString());
						boolean b_oup_time = m_oup_time.matches();

						if (b_oup && b_oup_time) {
							// 更新数据
							Connection conn__oup = JDBCUtil.getConn();
							CallableStatement cs__oup;
							try {
								cs__oup = conn__oup
										.prepareCall("{call OQ_updateOrder(?,?,?,?,?)}");
								cs__oup.setObject(1, upOrder_oID);
								cs__oup.setObject(2, upOrder_oNum);
								cs__oup.setObject(3, upOrder_oTime);
								cs__oup.setObject(4, upOrder_cID);
								cs__oup.setObject(5, upOrder_mID);

								cs__oup.execute();

								cs__oup.close();
								JDBCUtil.close(conn__oup);
								JOptionPane.showMessageDialog(null, "修改数据成功！");
							} catch (SQLException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "修改数据失败！");
							}
							;
						}
						if (b_oup_time == false) {
							JOptionPane.showMessageDialog(null,
									"请确保日期为数字，且满足yyyy-mm-dd格式");
						}
						if (b_oup == false) {
							JOptionPane.showMessageDialog(null, "请确保单价为整数");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "请在订单列表中选择订单");
				}
			}
		});
		// 清空按钮
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				OrderMan.textField_1.setText("");
				OrderMan.textField_2.setText("");
			}
		});
		// 刷新按钮
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				onloadOrderData((String)comboBox.getSelectedItem());
			}
		});

		// 设置表格列的宽度
		TableColumn setColumn = table.getColumnModel().getColumn(0);
		setColumn.setPreferredWidth(100);
		setColumn = table.getColumnModel().getColumn(3);
		setColumn.setPreferredWidth(30);
		setColumn = table.getColumnModel().getColumn(5);
		setColumn.setPreferredWidth(120);
		setSize(522, 300);
		setVisible(true);
	}

	
	private void onloadOrderData(String cID) {
		Connection conn_o2 = JDBCUtil.getConn();
		PreparedStatement Mstate_o2;
		try {
			
			if(cID.equals("所有")){
				Mstate_o2 = conn_o2.prepareStatement("select oID,mID,cID,oNum,oAmount,oTime from OrderInfo");	
			}else {
				Mstate_o2 = conn_o2.prepareStatement("select oID,mID,cID,oNum,oAmount,oTime from OrderInfo where cID = ?");
				Mstate_o2.setInt(1, Integer.valueOf(cID));
			}
			
//			Mstate_o2 = conn_o2.createStatement();
			
			ResultSet Mrs_o2 = Mstate_o2.executeQuery();
			OrderMan.table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "\u8BA2\u5355\u53F7", "\u5546\u54C1",
							"\u5BA2\u6237\u7F16\u53F7", "\u6570\u91CF",
							"\u91D1\u989D", "\u8BA2\u5355\u65F6\u95F4" }));
			DefaultTableModel tableModel = (DefaultTableModel) OrderMan.table
					.getModel();
			while (Mrs_o2.next()) {
				tableModel.addRow(new Object[] { Mrs_o2.getObject(1),
						Mrs_o2.getObject(2), Mrs_o2.getObject(3),
						Mrs_o2.getObject(4), Mrs_o2.getObject(5),
						Mrs_o2.getObject(6) });
			}
			JDBCUtil.close(Mrs_o2, Mstate_o2, conn_o2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 设置表格列的宽度
		TableColumn setColumn = table.getColumnModel().getColumn(0);
		setColumn.setPreferredWidth(100);
		setColumn = table.getColumnModel().getColumn(3);
		setColumn.setPreferredWidth(30);
		setColumn = table.getColumnModel().getColumn(5);
		setColumn.setPreferredWidth(120);
	}
}
