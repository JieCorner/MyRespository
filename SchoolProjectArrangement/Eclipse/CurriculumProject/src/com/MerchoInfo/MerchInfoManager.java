package com.MerchoInfo;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




import com.util.JDBCUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MerchInfoManager extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2497063620270142083L;
	int tablerow=0;
	MerchInfoManager MerInfoM=this;
	private String[] Mstr=null;
	private JTextField textField;          
	private JTextField textField_1;        
	private JTextField textField_2;

	//���
	private JTable table;                     
	private JButton button ;
	private JButton button_1; 
	private JComboBox comboBox;
	private JButton button_2;
	public MerchInfoManager() {
		//���������б�����
		Connection conn = JDBCUtil.getConn();
		Statement Mstate;
		try
		{
			Mstate = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			ResultSet Mrs=Mstate.executeQuery("select sName from Supplier");
			Mrs.last();
			int Mrow = Mrs.getRow();
			Mrs.first();
			Mrs.previous();
			this.Mstr=new String[Mrow + 1 ];
			this.Mstr[0]="����";
			for(int i=1;i<Mrow + 1;i++)
			{
				if(Mrs.next())
				{
					this.Mstr[i]=Mrs.getString("sName");					
				}
			}
			JDBCUtil.close(Mrs, Mstate, conn);
		} 
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		setFont(new Font("������", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 404, 25);
		
		JLabel label = new JLabel("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406");
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 23, 404, 211);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setBounds(32, 252, 66, 15);
		label_1.setFont(new Font("������", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBounds(94, 249, 87, 21);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F9B\u5E94\u5546\uFF1A");
		label_2.setBounds(214, 255, 54, 15);
		label_2.setFont(new Font("������", Font.PLAIN, 12));
		
		JLabel label_3 = new JLabel("\u63CF    \u53D9\uFF1A");
		label_3.setBounds(32, 280, 60, 18);
		label_3.setFont(new Font("������", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 279, 87, 21);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5355\u4EF7\uFF1A");
		label_4.setBounds(214, 283, 54, 15);
		label_4.setFont(new Font("������", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 280, 92, 21);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerInfoM.onloadData((String)comboBox.getSelectedItem());
			}
		});
		comboBox.setBounds(272, 252, 92, 21);
		comboBox.setMaximumRowCount(10);
		comboBox.setModel(new DefaultComboBoxModel(Mstr));
		button = new JButton("\u8BBE\u7F6E");
		button.setBounds(32, 320, 74, 23);
		button_1 = new JButton("\u6E05\u7A7A");
		button_1.setBounds(158, 319, 74, 23);
		button_2 = new JButton("\u5237\u65B0");
		button_2.setBounds(290, 320, 74, 23);
		 //��հ�ť
		button_1.addMouseListener(new MouseAdapter()    
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				MerInfoM.textField.setText("");
				MerInfoM.textField_1.setText("");
			    MerInfoM.textField_2.setText("");
			}
		});
		 //���ð�ť
		button.addMouseListener(new MouseAdapter()    
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				//�޸�����
				int selectRows=MerInfoM.table.getSelectedRows().length;// ȡ���û���ѡ�е�����
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				if(selectRows==1)
				{
				  // ������ش���
				  int selectedRowIndex =table.getSelectedRow(); // ȡ���û���ѡ���� 
				  //System.out.println(table.getValueAt(selectedRowIndex, 0) );   //��ȡ��ѡ�е�mIDֵ
				 //������������
				  Object upInfo_ID=table.getValueAt(selectedRowIndex, 0);
				  Object upInfo_name=textField.getText();
				  String upInfo_describe=textField_1.getText();
				  Object upInfo_price=textField_2.getText();
				  Object upInfo_sname=comboBox.getSelectedItem();
				if("".equals(upInfo_name)&&"".equals(upInfo_describe)&&"".equals(upInfo_price))
				{
						 JOptionPane.showMessageDialog(null,"����������һ���޸ĵ�����");
				}
				else{
				  if("".equals(upInfo_name))
				  {
					  upInfo_name=table.getValueAt(selectedRowIndex, 1);
				  }
				  if("".equals(upInfo_price))
				  {
					  upInfo_price=table.getValueAt(selectedRowIndex, 4);
				  }
				  //��֤����
				  Pattern p = Pattern.compile("^(([0-9]|([1-9][0-9]{0,9}))((\\.[0-9]{1,4})?))$");
				  Matcher m = p.matcher(upInfo_price.toString());
				  boolean b = m.matches();
				 
				  //��������ʱִ�еĸ��Ĳ���

				  if((((String)upInfo_name).length()<=32&&upInfo_describe.length()<=200&&b))
				  {
					  Connection conn_UpInfo = JDBCUtil.getConn();
					  CallableStatement cs_UpInfo;
					try
					{
						cs_UpInfo = conn_UpInfo.prepareCall("{call MQ_updateInfo(?,?,?,?,?)}");
						cs_UpInfo.setObject(1,upInfo_ID);
						cs_UpInfo.setObject(2,upInfo_name);
						cs_UpInfo.setObject(3,upInfo_price);
						cs_UpInfo.setString(4,upInfo_describe);
						cs_UpInfo.setObject(5,upInfo_sname);
						cs_UpInfo.execute();
						cs_UpInfo.close();
						JDBCUtil.close(conn_UpInfo);
						JOptionPane.showMessageDialog(null,"�޸����ݳɹ���");
					} catch (SQLException e1)
					{
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"�޸�����ʧ�ܣ�");
					} ;
				  }
				  if(b==false)
				  {
					  JOptionPane.showMessageDialog(null,"��ȷ��������ĵ���������");
				  }
				  if(((String)upInfo_name).length()>32)
				  {
					  JOptionPane.showMessageDialog(null,"�������Ʒ���Ƴ�����С��32");
				  }
				  if(upInfo_describe.length()>200)
				  {
					  JOptionPane.showMessageDialog(null,"�������Ʒ����������С��200");
				  }  
				}
				}
				//δѡ����Ʒ���
				else
				{
					JOptionPane.showMessageDialog(null,"������Ʒ�б���ѡ����Ʒ");
				}
			}
		});
		
		
		//ˢ�°�ť
		button_2.addMouseListener(new MouseAdapter()    
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
				//��������
				MerInfoM.onloadData((String)comboBox.getSelectedItem());
			}
		});
		
		table = new JTable();
		//�������ݿ�����
		MerInfoM.onloadData("����");
		getContentPane().setLayout(null);
		
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
		getContentPane().add(panel);
		getContentPane().add(textField);
		getContentPane().add(label_1);
		getContentPane().add(label_2);
		getContentPane().add(comboBox);
		getContentPane().add(button);
		getContentPane().add(button_1);
		getContentPane().add(button_2);
		getContentPane().add(label_3);
		getContentPane().add(textField_1);
		getContentPane().add(label_4);
		getContentPane().add(textField_2);
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane()}));	
		
		setSize(420, 400);
		setVisible(true);
	}
	//��������

	
	private void onloadData(String sName)
	{
		Connection conn_b2 = JDBCUtil.getConn();
		PreparedStatement Mstate_b2;
		try
		{
			if(sName.equals("����")){
				Mstate_b2 = conn_b2.prepareStatement("select mID,mName,logo,mType,mPrice from Merchandise");	
			}else {
				Mstate_b2 = conn_b2.prepareStatement("select mID,mName,logo,mType,mPrice from Merchandise where logo = ?");
				Mstate_b2.setString(1, sName);
			}
			
			ResultSet Mrs_b2=Mstate_b2.executeQuery();
			MerInfoM.table.setModel(new DefaultTableModel(
					new Object[][]{},
					new String[] {
						"\u5546\u54C1\u4FE1\u606F", "\u540D\u79F0", "\u7C7B\u522B", "\u578B\u53F7", "\u4EF7\u683C"
					}
				));
			DefaultTableModel tableModel = (DefaultTableModel)MerInfoM.table.getModel();
			while(Mrs_b2.next())
			{
				tableModel.addRow(new Object[]{Mrs_b2.getObject(1), Mrs_b2.getObject(2), 
					Mrs_b2.getObject(3),Mrs_b2.getObject(4),Mrs_b2.getObject(5)});
			}
			JDBCUtil.close(Mrs_b2, Mstate_b2, conn_b2);
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}
