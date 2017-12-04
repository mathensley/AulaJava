package am.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import am.main.Cadastro;
import am.utils.Utils;

public class FrameLS extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Connection c = null;
	
	JPanel panelPrincipal = new JPanel();
	
	
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
	
	private JPanel createPane(){
		JPanel panel =  new JPanel();
		JLabel head = new JLabel("Lista de Síndicos");
		JPanel panelCima = new JPanel();
		
		panel.setBackground(Utils.branco);
		panel.setSize(600, 600);
		panel.setLayout(null);
		panel.setVisible(true);
		
		panelCima.setBounds(0, 0, 600, 60);
		panelCima.setBackground(Utils.laranjaClaro);
		panel.add(panelCima);
		panelCima.setLayout(null);
		panelCima.setVisible(true);
		
		head.setForeground(Utils.branco);
		head.setFont(Utils.f2);
		head.setBounds(190, 4, 240, 43);
		panelCima.add(head);
		
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
		
		return panel;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
