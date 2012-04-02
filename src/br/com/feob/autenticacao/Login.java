package br.com.feob.autenticacao;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.feob.compras.Compras;

/**
 * 
 * Classe para login do sistema
 * 
 * @author Osvaldo
 * @author Paola
 * @author Lucas
 * 
 * 
 * */
public class Login extends JFrame {
	
	private JLabel lbUsuario = new JLabel("Usuario");
	private JLabel lbSenha = new JLabel("Senha");
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnEntrar = new JButton("Entrar");
	private JButton btnSair = new JButton("Sair");

	public Login() {
		super("Login - Simulador de Compras");

		txtUsuario = new JTextField(20);
		txtSenha = new JPasswordField(20);
		txtSenha.setEchoChar('*');
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(350, 150);
		this.setLocation((640-(this.getWidth()/2)), (400-this.getHeight()/2));

		JPanel window = new JPanel();
		window.setLayout(new GridLayout(3,2));
		window.add(lbUsuario);
		window.add(txtUsuario);
		window.add(lbSenha);
		window.add(txtSenha);
		window.add(btnEntrar);
		window.add(btnSair);
		
		this.add(window);
		
		txtSenha.getPassword().toString();

		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin(txtUsuario.getText(), new String(txtSenha.getPassword()));
			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	protected void doLogin(String usuario, String senha) {

		if (usuario.equals("admin") && senha.equals("admin")) {
			new Compras("Simulador de compras");
		} else if (usuario.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Todos os campos devem ser preenchidos");
		} else {
			JOptionPane.showMessageDialog(null, "Usu‡rio e/ou Senha inv‡lidos");
		}
	}
}
