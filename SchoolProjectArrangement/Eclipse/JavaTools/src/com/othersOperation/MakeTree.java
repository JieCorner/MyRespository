package com.othersOperation;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MakeTree
{
	//获得一颗树，可以通过jframe.add()加入显示到窗口中
	static public JTree getTree(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根"); //根节点
		DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("节点"); //节点
		DefaultMutableTreeNode t1_1= new DefaultMutableTreeNode("叶节点");
		root.add(t1);
		t1.add(t1_1);
		return new JTree(root);
	}
	
}
