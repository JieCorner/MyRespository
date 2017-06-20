package com.conversation;

//例10:聊天程序(一对一)服务器端
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
		super("聊天程序----服务器端");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("发送");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				server.sendMsg(sendArea.getText());
				mainArea.append("【服务器】" + sendArea.getText() + "\n");
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

