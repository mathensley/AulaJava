package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Frame para cadastro de condominos e sindicos
public class FrameCadastro extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static String tipos[] = {"Síndico", "Condômino"};
	
	
	//Construtor padrão para cadastro com opção de sindico e condomino
	public FrameCadastro(){
		super("ApartManager-Cadastro");
		
		PanelCadastro panelC = new PanelCadastro(tipos);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelC.setBounds(0, 0, 700, 700);
		panel.add(panelC);
		panel.setVisible(true);
	}
	
	//Sobrecarga para escolher o tipo a ser exibido
	public FrameCadastro(String tipo[]){
		super("ApartManager-Cadastro");
		
		PanelCadastro panelC = new PanelCadastro(tipo);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelC.setBounds(0, 0, 700, 700);
		panel.add(panelC);
		panel.setVisible(true);
	}
}
