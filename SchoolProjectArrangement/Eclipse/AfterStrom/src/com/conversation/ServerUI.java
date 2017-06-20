package com.conversation;

//��10:�������(һ��һ)��������
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ServerUI extends JFrame {
	JTextArea mainArea;
	JTextArea sendArea;
	JTextField indexArea;
    ServerSvr  server;

	public void setServer(ServerSvr server) {
		this.server = server;
	}

	public ServerUI() {
		super("�������----��������");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("����");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				server.sendMsg(sendArea.getText());
				mainArea.append("����������" + sendArea.getText() + "\n");
				sendArea.setText("");
			}
		});
		JPanel tmpPanel = new JPanel();
		indexArea = new JTextField(2);
		indexArea.setText("0");
		tmpPanel.add(sendBtn);
		tmpPanel.add(indexArea);
		panel.add(tmpPanel, BorderLayout.EAST);
		panel.add(sendArea, BorderLayout.CENTER);
		contain.add(mainAreaP, BorderLayout.CENTER);
		contain.add(panel, BorderLayout.SOUTH);
		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ServerUI ui = new ServerUI();
		ServerSvr server = new ServerSvr(ui);
	}
}

