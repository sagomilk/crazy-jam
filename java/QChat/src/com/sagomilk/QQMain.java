package com.sagomilk;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class QQMain {
	public static void main(String[] args) {
		JFrame w = new JFrame();
		w.setSize(300, 400);
		w.setLayout(new BorderLayout());
		
		JTextArea txtContent = new JTextArea();
		JScrollPane spContent = new JScrollPane(txtContent);
		w.add(spContent, BorderLayout.CENTER);
		
		JComboBox cmbUser = new JComboBox();
		JButton btnSend = new JButton("Send");	
		JPanel panSmall = new JPanel();
		panSmall.setLayout(new GridLayout(1, 2));
		panSmall.add(cmbUser);
		panSmall.add(btnSend);
		
		JTextField txtMess = new JTextField();
		JPanel panBig = new JPanel();
		panBig.setLayout(new GridLayout(2, 1));
		panBig.add(txtMess);
		panBig.add(panSmall);
		
		w.add(panBig, BorderLayout.SOUTH);
		
		w.setVisible(true);
	}
}
