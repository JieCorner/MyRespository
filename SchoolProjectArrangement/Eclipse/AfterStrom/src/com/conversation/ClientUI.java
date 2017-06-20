package com.conversation;

//��10:�������(һ��һ)�ͻ���
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//�û�����ClientUI
public class ClientUI extends JFrame {
	JTextArea mainArea;

	JTextArea sendArea;

	ClientSvr client;

	JTextField ipArea;

	JButton btnLink;

	public void setClient(ClientSvr client) {
		this.client = client;
	}

	public ClientUI() {
		super("�������----�ͻ���");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);// Ϊ�ı�����ӹ�����

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("����");

		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				client.sendMsg(sendArea.getText());
				mainArea.append("���ͻ��ˡ�" + sendArea.getText() + "\n");
				sendArea.setText("");
			}
		});

		JPanel ipPanel = new JPanel();
		ipPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		ipPanel.add(new JLabel("��������"));
		ipArea = new JTextField(12);
		ipArea.setText("127.0.0.1");
		ipPanel.add(ipArea);
		btnLink = new JButton("����");
		ipPanel.add(btnLink);

		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				client = new ClientSvr(ipArea.getText(), 2345, ClientUI.this);
				ClientUI.this.setClient(client);
			}
		});

		panel.add(sendBtn, BorderLayout.EAST);
		panel.add(sendArea, BorderLayout.CENTER);

		contain.add(ipPanel, BorderLayout.NORTH);
		contain.add(mainAreaP, BorderLayout.CENTER);
		contain.add(panel, BorderLayout.SOUTH);
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ClientUI ui = new ClientUI();
	}
}

