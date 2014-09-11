package com.sagomilk;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class QQLogin implements ActionListener{
	JFrame w;
	JTextField txtUser;
	JTextField txtPassword;
	JButton btnLogin;
	JButton btnReg;
	JButton btnCancel;
	
	public QQLogin() {
		w = new JFrame();
		w.setTitle("登录");
		w.setLayout(new BorderLayout());
		w.setBounds(400, 300, 0, 0);
		w.setSize(250, 125);
		
		JLabel labUser = new JLabel(" username: ");
		JLabel labPassword = new JLabel(" password:");
		
		txtUser = new JTextField();
		txtPassword = new JTextField();
		
		JPanel panInput = new JPanel();
		panInput.setLayout(new GridLayout(2, 2));
		panInput.add(labUser);
		panInput.add(txtUser);
		panInput.add(labPassword);
		panInput.add(txtPassword);
		
		JButton btnLogin = new JButton("登录");
		JButton btnReg = new JButton("注册");
		JButton btnCancel = new JButton("取消");
		
		JPanel panButton = new JPanel();
		panButton.setLayout(new FlowLayout());
		panButton.add(btnLogin);
		panButton.add(btnReg);
		panButton.add(btnCancel);
		
		w.add(panInput, BorderLayout.CENTER);
		w.add(panButton, BorderLayout.SOUTH);
		
		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	public void setVisible(boolean visible) {
		w.setVisible(visible);
	}

	
	public static void main(String[] args) {		
		QQLogin login = new QQLogin();
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		String username = txtUser.getText();
		String password = txtPassword.getText();
		if (username.equals(password)) {
			System.out.println("OK "+username);
		}else {
			System.out.println(username);
			System.out.println(password);
		}
		
		System.out.println(e.getActionCommand());
	}
	
}
