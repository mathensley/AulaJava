package am.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import am.main.Cadastro;
import am.utils.Utils;

//Frame onde mostra todos os sindicos cadastrados
public class FrameLS extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Connection c = null;
	
	JPanel panelPrincipal = new JPanel();
	
	JButton b1 = new JButton("Remover");
	
	
	public FrameLS(){
		super("ApartManager-Lista");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		panelPrincipal.setBounds(0, 0, 600, 600);
		panelPrincipal = createPane();
		
		add(panelPrincipal);
	}
	
	//Criar o panel principal
	private JPanel createPane(){
		JPanel panel =  new JPanel();
		JLabel head = new JLabel("Lista de Síndicos");
		JPanel panelCima = new JPanel();
		
		//Cor do background principal
		panel.setBackground(Utils.branco);
		panel.setSize(600, 600);
		panel.setLayout(null);
		panel.setVisible(true);
		
		//Head
		panelCima.setBounds(0, 0, 600, 60);
		panelCima.setBackground(Utils.laranjaClaro);
		panel.add(panelCima);
		panelCima.setLayout(null);
		panelCima.setVisible(true);
		
		//Titulo
		head.setForeground(Utils.branco);
		head.setFont(Utils.f2);
		head.setBounds(190, 4, 240, 43);
		panelCima.add(head);
		
		//JTable para mostrar sindicos cadastrados
		List<Cadastro> lista = new ArrayList<Cadastro>();
		
		String column[] = {"NOME", "EMAIL", "CPF", "FONE", "APTO"};
		
		lista = Utils.mostrarSindicos(c);
		Object[][] a = new Object[lista.size()][];
		int i = 0;
		
		for(Cadastro ca : lista){
			a[i++] = new Object[] {ca.getNome(), ca.getEmail(), ca.getCpf(), ca.getFone(), ca.getApto()};
		}
		
		JTable jt = new JTable(a, column);
	    
		jt.setCellSelectionEnabled(false);
		
		JScrollPane sp = new JScrollPane(jt);		
		sp.setBounds(50, 150, 500, 300);
		
		add(sp);
		
		//Botão
		b1.setBounds(395, 450, 154, 30);
		b1.setBackground(Utils.laranjaClaro);
		b1.setForeground(Utils.branco);
		b1.setFont(Utils.f1);
		b1.addActionListener(this);
		panel.add(b1);
		
		return panel;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		new FrameDeletar("REMOVER SÍNDICO", "Digite o CPF:", "cadastro", "cpf", true);
	}
	
}
