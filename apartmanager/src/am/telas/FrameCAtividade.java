package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Frame para cadastro de atividades
public class FrameCAtividade extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static PanelCAtividade panelCA = new PanelCAtividade();
	
	public FrameCAtividade(){
		super("ApartManager-CadastrarAtividade");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelCA.setBounds(0, 0, 700, 700);
		panel.add(panelCA);
		panel.setVisible(true);
	}
}
