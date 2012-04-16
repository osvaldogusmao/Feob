package br.com.feob.compras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.text.NumberFormat;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Frame com os componentes para simula��o de compras
 * 
 * @author Osvaldo
 * 
 * */
public class Compras extends JFrame {

	/**
	 * 
	 * Panel para alocar os componentes
	 * 
	 * */
	private JPanel panelComponentes = new JPanel();
	private JPanel panelProdutos = new JPanel();
	private JPanel panelPrecos = new JPanel();
	private JPanel panelQuantidade = new JPanel();

	/**
	 * 
	 * Label de descri��o dos panel
	 * 
	 * */

	private JLabel lbProdutos = new JLabel("Produtos");
	private JLabel lbPrecos = new JLabel("Pre�os", JLabel.RIGHT);
	private JLabel lbQuantidade = new JLabel("Quantidade");

	/**
	 * 
	 * Componentes : JCheckBox
	 * 
	 * */
	private JCheckBox chbRapadura = new JCheckBox("Rapadura", false);
	private JCheckBox chbInhame = new JCheckBox("Inhame", false);
	private JCheckBox chbCupuacu = new JCheckBox("Cupua�u", false);
	private JCheckBox chbSandalias = new JCheckBox("Sand�lias", false);
	private JCheckBox chbBolacha = new JCheckBox("Bolacha", false);
	private JCheckBox chbSabao = new JCheckBox("Sab�o", false);
	private JCheckBox chbPinico = new JCheckBox("Pinico", false);

	/**
	 * 
	 * Componentes: Label - Pre�os
	 * 
	 * */
	private String lbCifrao = "R$";
	private JLabel lbRapadura = new JLabel("1.50", JLabel.RIGHT);
	private JLabel lbInhame = new JLabel("3.00", JLabel.RIGHT);
	private JLabel lbCupuacu = new JLabel("1.10", JLabel.RIGHT);
	private JLabel lbSandalias = new JLabel("12.35", JLabel.RIGHT);
	private JLabel lbBolacha = new JLabel("1.85", JLabel.RIGHT);
	private JLabel lbSabao = new JLabel("0.80", JLabel.RIGHT);
	private JLabel lbPinico = new JLabel("11.17", JLabel.RIGHT);

	/**
	 * 
	 * Componentes: TextFiedl - Qauntidade
	 * 
	 * */
	private JTextField txtRapadura = new JTextField("0", 5);
	private JTextField txtInhame = new JTextField("0", 5);
	private JTextField txtCupuacu = new JTextField("0", 5);
	private JTextField txtSandalias = new JTextField("0", 5);
	private JTextField txtBolacha = new JTextField("0", 5);
	private JTextField txtSabao = new JTextField("0", 5);
	private JTextField txtPinico = new JTextField("0", 5);

	/**
	 * 
	 * Componente: Bot�o - Calcular
	 * 
	 * */
	private JButton btnCalcular = new JButton("Calcular");

	/**
	 * 
	 * Componentes: Grid Layouts
	 * 
	 * */
	private GridLayout glProdutos = new GridLayout(8, 1, 10, 1);
	private GridLayout glPrecos = new GridLayout(8, 2, 10, 1);
	private GridLayout glQuantidade = new GridLayout(8, 1, 10, 1);
	private GridLayout glPanel = new GridLayout(1,3, 10,1);

	/**
	 * 
	 * Metodo Construtor
	 * 
	 * � o primeiro m�todo a ser chamado quando uma classe � instaciada, ou seja
	 * criada.
	 * 
	 * */
	public Compras(String title) {
		this.setTitle(title);
		
		
		this.setLayout(new FlowLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(300, 300);
		this.setMaximumSize(new Dimension(300,300));
		this.setMinimumSize(new Dimension(300,300));
		
		
		this.setLocation((640-(this.getWidth()/2)), (400-this.getHeight()/2));
		

		//Layout para alocar os panels
		panelComponentes.setLayout(glPanel);
		panelComponentes.setBackground(Color.WHITE);
		
		//Layout para o panel Produto
		panelProdutos.setLayout(glProdutos);
		panelProdutos.setBackground(Color.WHITE);
		
		//Adicionando componentes ao panelProduto
		panelProdutos.add(lbProdutos);
		panelProdutos.add(chbRapadura);
		panelProdutos.add(chbInhame);
		panelProdutos.add(chbCupuacu);
		panelProdutos.add(chbSandalias);
		panelProdutos.add(chbBolacha);
		panelProdutos.add(chbSabao);
		panelProdutos.add(chbPinico);

		//Layout para o panel Pre�o
		panelPrecos.setLayout(glPrecos);
		panelPrecos.setBackground(Color.WHITE);
		
		//Adicionando os componentes ao panelPreco
		panelPrecos.add(lbPrecos);
		panelPrecos.add(new JLabel());
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbRapadura);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbInhame);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbCupuacu);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbSandalias);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbBolacha);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbSabao);
		panelPrecos.add(new JLabel(lbCifrao));
		panelPrecos.add(lbPinico);
		
		
		//Layout para o panel Quantidade
		panelQuantidade.setLayout(glQuantidade);
		panelQuantidade.setBackground(Color.WHITE);
		
		//Adicionando os componentes ao panelQuantidade
		panelQuantidade.add(lbQuantidade);
		panelQuantidade.add(txtRapadura);
		panelQuantidade.add(txtInhame);
		panelQuantidade.add(txtCupuacu);
		panelQuantidade.add(txtSandalias);
		panelQuantidade.add(txtBolacha);
		panelQuantidade.add(txtSabao);
		panelQuantidade.add(txtPinico);
		
		//Adicionando os Paneis de componentes a um panel Mestre
		panelComponentes.add(panelProdutos);
		panelComponentes.add(panelPrecos);
		panelComponentes.add(panelQuantidade);
		
		//Adicionando o panel Mestre ao Frame principal
		this.add(panelComponentes);
		
		//Adicionando o bot�o calcular no centro do Frame Principal
		this.add(btnCalcular, JButton.CENTER_ALIGNMENT);
		
		//Adicionando o clickEvent no bot�o calcular
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				double totalDaCompra = 0;
				String produtosComprados = "Veja os produtos comprados:\n";
				
				if(chbRapadura.isSelected() && Integer.parseInt(txtRapadura.getText()) > 0){
						totalDaCompra = totalDaCompra + (Double.parseDouble(lbRapadura.getText()) * (Integer.parseInt(txtRapadura.getText())));
						produtosComprados += chbRapadura.getText() + "\n";
				}
				
				if (chbInhame.isSelected() && Integer.parseInt(txtInhame.getText()) > 0) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbInhame.getText()) * (Integer.parseInt(txtInhame.getText())));
					produtosComprados += chbInhame.getText() + "\n";
				}
				
				if (chbCupuacu.isSelected() && Integer.parseInt(txtCupuacu.getText()) > 0) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbCupuacu.getText()) * (Integer.parseInt(txtCupuacu.getText())));
					produtosComprados += chbCupuacu.getText() + "\n";
				}
				
				if (chbSandalias.isSelected() && Integer.parseInt(txtSandalias.getText()) > 0 ) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbSandalias.getText()) * (Integer.parseInt(txtSandalias.getText())));
					produtosComprados += chbSandalias.getText() + "\n";
				}
				
				if (chbBolacha.isSelected() && Integer.parseInt(txtBolacha.getText()) > 0) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbBolacha.getText()) * (Integer.parseInt(txtBolacha.getText())));
					produtosComprados += chbBolacha.getText() + "\n";
				}
				
				if (chbSabao.isSelected() && Integer.parseInt(txtSabao.getText()) > 0) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbSabao.getText()) * (Integer.parseInt(txtSabao.getText())));
					produtosComprados += chbSabao.getText() + "\n";
				}
				
				if (chbPinico.isSelected() && Integer.parseInt(txtPinico.getText()) > 0) {
					totalDaCompra = totalDaCompra + (Double.parseDouble(lbPinico.getText()) * (Integer.parseInt(txtPinico.getText())));
					produtosComprados += chbPinico.getText() + "\n";
				}
				
				
				if(totalDaCompra > 0){

					JOptionPane.showMessageDialog(null, produtosComprados + "\n" +
														"Valor da compra : R$ "+ totalDaCompra, "Simulador de compras", JOptionPane.INFORMATION_MESSAGE);
				}else{

					JOptionPane.showMessageDialog(null, "Voc� n�o realizou nenhuma compra", "Simulador de compras", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});	
		
		
		this.setVisible(true);
		
	}	
}