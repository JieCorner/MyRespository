package com.othersOperation;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MakeTree
{
	//���һ����������ͨ��jframe.add()������ʾ��������
	static public JTree getTree(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��"); //���ڵ�
		DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("�ڵ�"); //�ڵ�
		DefaultMutableTreeNode t1_1= new DefaultMutableTreeNode("Ҷ�ڵ�");
		root.add(t1);
		t1.add(t1_1);
		return new JTree(root);
	}
	
}
