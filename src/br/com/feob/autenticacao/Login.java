package br.com.feob.autenticacao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		this.setLocation((640 - (this.getWidth() / 2)),
				(400 - this.getHeight() / 2));

		JPanel window = new JPanel();
		window.setLayout(new GridLayout(3, 2));
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
				try {
					doLogin(txtUsuario.getText(), txtSenha.getPassword());
				} catch (IOException evt) {
					evt.printStackTrace();
				}
			}
		});

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	protected static void doLogin(String usuario, char[] senha)
			throws IOException {

		InputStream inputStream = new FileInputStream("users.pwd");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String string = bufferedReader.readLine();
		boolean encontrado = false;

		String newSenha = new String(senha);

		while (string != null) {
			String[] texto = string.split("\\|");
			if (usuario.equals(texto[0]) && newSenha.equals(texto[1])) {
				encontrado = true;
				break;
			}
			string = bufferedReader.readLine();
		}

		if (encontrado == true) {
			new Compras("Simulador de compras");
		} else if (usuario.isEmpty() || newSenha.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Todos os campos devem ser preenchidos");
		} else {
			JOptionPane.showMessageDialog(null, "Usu‡rio e/ou Senha inv‡lidos");
		}
		bufferedReader.close();

	}
}
