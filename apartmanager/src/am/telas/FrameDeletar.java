package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Frame para deletar
public class FrameDeletar extends JFrame {
	private static final long serialVersionUID = 1L;

	private static String h1 = "REMOVER DESPESA";
	private static String h2 = "Digite o ID:";
	private static String tab = "despesas";
	private static String col = "id";
	
	
	//Construtor padrão para tabela despesas e coluna id
	public FrameDeletar(){
		super("ApartManager-Deletar");
		
		PanelDeletar panelDel = new PanelDeletar(h1, h2, tab, col, false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelDel.setBounds(0, 0, 400, 400);
		panel.add(panelDel);
		panel.setVisible(true);
	}
	
	//Sobrecarga para escolher qual tabela e coluna
	public FrameDeletar(String head, String label, String table, String coluna, boolean string){
		super("ApartManager-Deletar");
		
		PanelDeletar panelDel = new PanelDeletar(head, label, table, coluna, string);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelDel.setBounds(0, 0, 400, 400);
		panel.add(panelDel);
		panel.setVisible(true);
	}
	
}
