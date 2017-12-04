package am.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Frame do login
public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	public static PanelLogin panelLogin = new PanelLogin();
	
	
	public FrameLogin(){
		super("ApartManager");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		panelLogin.setBounds(0, 0, 400, 500);
		panel.add(panelLogin);
		panel.setVisible(true);		
		
	}
}
