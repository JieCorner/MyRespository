package com.CurriculumProject;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JScrollPane;

import com.Customer.AddCustomer;
import com.Customer.SelectCustomer;
import com.Customer.UpdateCustomer;
import com.MerchoInfo.MerchInfoManager;
import com.MerchoInfo.MerchInfoQuery;
import com.Order.OrderManager;
import com.Order.OrderQuery;
import com.Supplier.AddSupplier;
import com.Supplier.SelectSupplier;
import com.Supplier.UpdateSupplier;
import com.util.JDBCUtil;

public class SupermarketInfo extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu sysman, cusman, supman, merman, ordman, cus_sel, sup_sel;
	private JMenuItem sys_changeps, sys_exit, cus_up, cus_del, sup_add, sup_up, sup_del,
			mer_type, mer_sel, ord_man, oed_sel, cus_selall, mntm4_2, sup_selall, sup_selid;
	private JPanel panel_1 = new JPanel();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SupermarketInfo() {
		setBackground(new Color(100, 149, 237));
		//setAutoRequestFocus(false);
		setTitle("网上超市信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 442);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel.add(panel_1);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 635, 28);
		panel.add(menuBar);

		sysman = new JMenu("系统管理");
		menuBar.add(sysman);

		sys_changeps = new JMenuItem("密码修改");
		sys_changeps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ResetPass c = new ResetPass();
				c.setVisible(true);
			}
		});
		
		sysman.add(sys_changeps);

		sys_exit = new JMenuItem("退出");
		sys_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		sysman.add(sys_exit);

		cusman = new JMenu("客户信息管理");
		menuBar.add(cusman);

		JMenuItem cus_add = new JMenuItem("增加客户");
		cus_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new AddCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new AddCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				panel_1.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		cusman.add(cus_add);

		cus_up = new JMenuItem("修改客户");
		cus_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new UpdateCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new UpdateCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				panel_1.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		cusman.add(cus_up);

		cus_del = new JMenuItem("删除客户");
		cus_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int cid;
				String in = JOptionPane.showInputDialog("请输入要删除的编号");
				cid = Integer.valueOf(in);
				Connection conn = null;
				CallableStatement cs = null;
				try {
					conn = JDBCUtil.getConn();					
					cs = conn.prepareCall("{call delete_customer(?)}");
					cs.setInt(1, cid);
					cs.execute();
					cs.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cusman.add(cus_del);

		cus_sel = new JMenu("查询客户");
		cusman.add(cus_sel);

		cus_selall = new JMenuItem("查询所有客户");
		cus_selall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new SelectCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new SelectCustomer();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				
			}
		});
		cus_sel.add(cus_selall);

		mntm4_2 = new JMenuItem("按编号查询客户");
		mntm4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int cid;
				String in = JOptionPane.showInputDialog("请输入要查询的编号");
				cid = Integer.valueOf(in);
				if(panel_1 == null){
					panel_1 = new SelectCustomer(cid);
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new SelectCustomer(cid);
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
			}
		});
		cus_sel.add(mntm4_2);

		supman = new JMenu("供应商信息管理");
		menuBar.add(supman);

		sup_add = new JMenuItem("供应商信息增加");
		sup_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new AddSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new AddSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				panel_1.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		supman.add(sup_add);

		sup_up = new JMenuItem("供应商信息修改");
		sup_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new UpdateSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new UpdateSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				panel_1.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		supman.add(sup_up);

		sup_del = new JMenuItem("供应商信息删除");
		sup_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int sid;
				String in = JOptionPane.showInputDialog("请输入要删除的编号");
				sid = Integer.valueOf(in);
				Connection conn = null;
				CallableStatement cs = null;
				try {
					conn = JDBCUtil.getConn();					
					cs = conn.prepareCall("{call delete_supplier(?)}");
					cs.setInt(1, sid);
					cs.execute();
					cs.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		supman.add(sup_del);

		sup_sel = new JMenu("查询供应商信息");
		supman.add(sup_sel);

		sup_selall = new JMenuItem("查询所有供应商");
		sup_selall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(panel_1 == null){
					panel_1 = new SelectSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new SelectSupplier();
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
				
			}
		});
		sup_sel.add(sup_selall);

		sup_selid = new JMenuItem("按编号查询供应商");
		sup_selid.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int sid;
				String in = JOptionPane.showInputDialog("请输入要查询的编号");
				sid = Integer.valueOf(in);
				if(panel_1 == null){
					panel_1 = new SelectSupplier(sid);
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}else {
					panel_1.setVisible(false);
					panel_1 = new SelectSupplier(sid);
					panel_1.setBounds(0, 27, 635, 376);
					panel_1.setVisible(true);
					panel.add(panel_1);
				}
			}
			
			
		});
		sup_sel.add(sup_selid);

		merman = new JMenu("商品信息管理");
		menuBar.add(merman);

		mer_type = new JMenuItem("商品类别管理");
		mer_type.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new MerchInfoManager();
			}
		});
		merman.add(mer_type);

		mer_sel = new JMenuItem("商品信息查询");
		mer_sel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new MerchInfoQuery();
			}
		});
		merman.add(mer_sel);

		ordman = new JMenu("订单信息管理");
		menuBar.add(ordman);

		ord_man = new JMenuItem("订单管理");
		ord_man.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new OrderManager();
			}
		});
		ordman.add(ord_man);

		oed_sel = new JMenuItem("订单管理信息查询");
		oed_sel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new OrderQuery();
			}
		});
		ordman.add(oed_sel);

		
		
		
		
	}
}
