package com.othersOperation;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChoose
{
	static public Color chooseColor()
	{
		JFrame frame=new JFrame();
		Color newcolor=JColorChooser.showDialog(frame,"��ɫ��",frame.getContentPane().getBackground());
		return newcolor;
	}
}