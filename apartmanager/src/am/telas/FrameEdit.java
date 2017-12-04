package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEdit extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static PanelEdit panelE = new PanelEdit();
	
	
	public FrameEdit(){
		super("ApartManager-Edit");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelE.setBounds(0, 0, 400, 400);
		panel.add(panelE);
		panel.setVisible(true);
	}
}
