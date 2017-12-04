package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameCDespesa extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static PanelCDespesa panelCD = new PanelCDespesa();
	
	public FrameCDespesa(){
		super("ApartManager-CadastrarDespesas");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelCD.setBounds(0, 0, 700, 700);
		panel.add(panelCD);
		panel.setVisible(true);
	}
}
