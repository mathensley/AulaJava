package am.telas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import am.main.Atividades;
import am.main.Cadastro;
import am.main.Despesas;
import am.utils.Utils;


public class FrameApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	
	JButton b1,b2,b3,b4, refresh, refresh1, refresh2, cadS, listS, del, del1, del2, edit;
	
	
	//public static PanelApp panelA = new PanelApp(Utils.branco, Utils.branco, Utils.branco, Utils.laranjaClaro,
	//		Utils.laranjaClaro, Utils.laranjaClaro);
	
	
	Connection c;
	
	//JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JTabbedPane tabbed;
	
	public FrameApp(){
		super("ApartManager");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		//UIManager.put("TabbedPane.unselectedForeground", Utils.branco);
		UIManager.put("TabbedPane.selectedForeground", Utils.branco);
		UIManager.put("TabbedPane.selectHighlight", Utils.branco);
		UIManager.put("TabbedPane.selected", Utils.laranjaClaro);
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
		UIManager.put("TabbedPane.focus", Utils.laranjaClaro);
		
		
		tabbed = createTabbed();
		
		tabbed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	JPanel sp;
            	int selectedIndex = tabbed.getSelectedIndex();
            	boolean bIsVisible = tabbed.isEnabledAt(selectedIndex);
            	sp = (JPanel) tabbed.getComponentAt(selectedIndex);
            	if ( bIsVisible ) {
            		sp.repaint();
            	}

            }
        });
		
		add(tabbed);	
		
		    
		pack();
		/*JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelA.setBounds(0, 0, 900, 700);
		panel.add(panelA);
		panel.setVisible(true);*/
	}

	public JTabbedPane createTabbed(){
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setPreferredSize(new Dimension(800, 600));
		tabbedPane.setBackground(Utils.branco);
		tabbedPane.setFont(Utils.f1);
		
		JPanel panel1 = createPane1();
        JPanel panel2 = createPane2();
        JPanel panel3 = createPane3();
        JPanel panel5 = createPane5();
        
        tabbedPane.addTab("Cond�minos", null, panel1);
        tabbedPane.addTab("Resumo", null, panel2);
        tabbedPane.addTab("Gerenciar", null, panel3);
        tabbedPane.addTab("Op��es", null, panel5);
        
        return tabbedPane;
	}
	
	private JPanel criarBase(String h1, int x){
		JPanel panel = new JPanel();
        panel.setBackground(Utils.branco);
        panel.setLayout(null);
		
        JPanel panelCima = new JPanel();
		panelCima.setBounds(0, 0, 800, 40);
		panelCima.setBackground(Utils.laranjaClaro);
		panel.add(panelCima);
		panelCima.setLayout(null);
		
		JLabel head = new JLabel(h1);
		head.setForeground(Utils.branco);
		head.setFont(Utils.f2);
		head.setBounds(x, 0, 250, 43);
		panelCima.add(head);
		
		return panel;
	}
	
	private JPanel createPane1() {
        //panel.add(new JScrollPane(createTextArea(10, 40)));
		JPanel panel = criarBase("Lista de Cond�minos", 260);
		
		List<Cadastro> lista = new ArrayList<Cadastro>();
		
		String column[] = {"NOME", "EMAIL", "CPF", "FONE", "APTO"};
		
		lista = Utils.mostrarCondominos(c);
		Object[][] a = new Object[lista.size()][];
		int i = 0;
		
		for(Cadastro ca : lista){
			a[i++] = new Object[] {ca.getNome(), ca.getEmail(), ca.getCpf(), ca.getFone(), ca.getApto()};
		}
		
		JTable jt = new JTable(a, column);
	    
		jt.setCellSelectionEnabled(false);
		
		JScrollPane sp = new JScrollPane(jt);		
		sp.setBounds(100, 150, 600, 300);
		
		panel.add(sp);
		
		del2 = new JButton("Deletar");
		del2.setBackground(Utils.laranjaClaro);
		del2.setForeground(Utils.branco);
		del2.setFont(Utils.f1);
		del2.setBounds(100, 450, 130, 30);
		del2.addActionListener(this);
		
		refresh1 = new JButton("Atualizar");
		refresh1.setBackground(Utils.laranjaClaro);
		refresh1.setForeground(Utils.branco);
		refresh1.setFont(Utils.f1);
		refresh1.setBounds(569, 450, 130, 30);
		refresh1.addActionListener(this);
		
		panel.add(refresh1);
		panel.add(del2);
		
        return panel;
    }
	
	private JPanel createPane2(){
		JPanel panel = criarBase("Atividades", 340);
		
		List<Atividades> lista = new ArrayList<Atividades>();
		
		String column[]={"ID", "NOME", "DATA", "STATUS"};
		
		lista = Utils.mostrarAtividades(c, PanelLogin.sind);
		Object[][] a = new Object[lista.size()][];
		int i = 0;
		
		for(Atividades at : lista){
			a[i++] = new Object[] {at.getId(), at.getNome(), at.getData(), at.getStatus()};
		}
		
		JTable jt = new JTable(a, column);
	    
	    jt.setCellSelectionEnabled(false);
		
		JScrollPane sp = new JScrollPane(jt);		
		sp.setBounds(100, 80, 600, 300);
		
		panel.add(sp);
		
		b4 = new JButton("+ Adicionar atividade");
		b4.setBackground(Utils.laranjaClaro);
		b4.setForeground(Utils.branco);
		b4.setFont(Utils.f1);
		b4.setBounds(280, 430, 230, 50);
		b4.addActionListener(this);
		
		refresh2 = new JButton("Atualizar");
		refresh2.setBackground(Utils.laranjaClaro);
		refresh2.setForeground(Utils.branco);
		refresh2.setFont(Utils.f1);
		refresh2.setBounds(463, 380, 130, 30);
		refresh2.addActionListener(this);
		
		edit = new JButton("Editar");
		edit.setBackground(Utils.laranjaClaro);
		edit.setForeground(Utils.branco);
		edit.setFont(Utils.f1);
		edit.setBounds(193, 380, 130, 30);
		edit.addActionListener(this);
		
		del1 = new JButton("Deletar");
		del1.setBackground(Utils.laranjaClaro);
		del1.setForeground(Utils.branco);
		del1.setFont(Utils.f1);
		del1.setBounds(328, 380, 130, 30);
		del1.addActionListener(this);
		
		panel.add(b4);
		panel.add(refresh2);
		panel.add(edit);
		panel.add(del1);
		
		return panel;
	}
	
	private JPanel createPane3(){
		JPanel panel = criarBase("Despesas", 340);
		
		List<Despesas> lista = new ArrayList<Despesas>();
		
		String column[]={"ID", "NOME", "FREQU�NCIA", "VALOR", "VENCIMENTO"};
		
		lista = Utils.mostrarDespesas(c, PanelLogin.sind);
		Object[][] a = new Object[lista.size()][];
		int i = 0;
		
		for(Despesas de : lista){
			a[i++] = new Object[] {de.getId(), de.getNome(), de.getFrequencia(), de.getValor(), de.getVencimento()};
		}
		
		JTable jt = new JTable(a, column);
	    
		jt.setCellSelectionEnabled(false);
		
		JScrollPane sp = new JScrollPane(jt);		
		sp.setBounds(100, 80, 600, 300);
		
		panel.add(sp);
		
		b3 = new JButton("+ Adicionar despesa");
		b3.setBackground(Utils.laranjaClaro);
		b3.setForeground(Utils.branco);
		b3.setFont(Utils.f1);
		b3.setBounds(280, 430, 230, 50);
		b3.addActionListener(this);
		
		del = new JButton("Deletar");
		del.setBackground(Utils.laranjaClaro);
		del.setForeground(Utils.branco);
		del.setFont(Utils.f1);
		del.setBounds(100, 380, 130, 30);
		del.addActionListener(this);
		
		refresh = new JButton("Atualizar");
		refresh.setBackground(Utils.laranjaClaro);
		refresh.setForeground(Utils.branco);
		refresh.setFont(Utils.f1);
		refresh.setBounds(570, 380, 130, 30);
		refresh.addActionListener(this);
		
		panel.add(b3);
		panel.add(refresh);
		panel.add(del);
		
		return panel;
	}
	
	private JPanel createPane5(){
		JPanel panel = criarBase("Configura��es", 310);
		
		b1 = new JButton("Sair");
		b1.setBackground(Utils.laranjaClaro);
		b1.setForeground(Utils.branco);
		b1.setFont(Utils.f1);
		b1.setBounds(690, 520, 70, 30);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("Cadastrar novo cond�mino");
		b2.setBackground(Utils.laranjaClaro);
		b2.setForeground(Utils.branco);
		b2.setFont(Utils.f1);
		b2.setBounds(270, 90, 260, 50);
		b2.addActionListener(this);
		panel.add(b2);
		
		cadS = new JButton("Cadastrar novo s�ndico");
		cadS.setBackground(Utils.laranjaClaro);
		cadS.setForeground(Utils.branco);
		cadS.setFont(Utils.f1);
		cadS.setBounds(270, 160, 260, 50);
		cadS.addActionListener(this);
		panel.add(cadS);
		
		listS = new JButton("Listar s�ndicos");
		listS.setBackground(Utils.laranjaClaro);
		listS.setForeground(Utils.branco);
		listS.setFont(Utils.f1);
		listS.setBounds(270, 220, 260, 50);
		listS.addActionListener(this);
		panel.add(listS);
		
		return panel;
	}
	
	private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setForeground(Color.BLUE);
        return ta;
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1){
			new FrameLogin();
			this.dispose();
		}
		if(e.getSource() == b2){
			String tipos[] = {"Cond�mino"};
			new FrameCadastro(tipos);
		}
		if(e.getSource() == cadS){
			String tipos[] = {"S�ndico"};
			new FrameCadastro(tipos);
		}
		if(e.getSource() == listS){
			new FrameLS();
		}
		if(e.getSource() == b3){
			new FrameCDespesa();
		}
		if(e.getSource() == b4){
			new FrameCAtividade();
		}
		if(e.getSource() == del){
			new FrameDeletar();
		}
		if(e.getSource() == del1){
			new FrameDeletar("REMOVER ATIVIDADE", "Digite o ID:", "atividades", "id", false);
		}
		if(e.getSource() == del2){
			new FrameDeletar("REMOVER COND�MINO", "Digite o CPF:", "cadastro", "cpf", true);
		}
		if(e.getSource() == refresh){
			this.dispose();
			new FrameApp();
		}
		if(e.getSource() == refresh1){
			this.dispose();
			new FrameApp();
		}
		if(e.getSource() == refresh2){
			this.dispose();
			new FrameApp();
		}
		if(e.getSource() == edit){
			new FrameEdit();
		}
	}
}
