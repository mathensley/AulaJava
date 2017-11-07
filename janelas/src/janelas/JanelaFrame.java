package janelas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JanelaFrame(String titulo){
		super(titulo);
		
		setSize(300, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel panelN = new JPanel();
		JPanel panelC = new JPanel();
		panelN.setLayout(new GridLayout());
		panelC.setLayout(new GridLayout(3,3));
		
		c.add(panelN, BorderLayout.NORTH);
		c.add(panelC, BorderLayout.CENTER);
		
		panelN.add(new JTextField());
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton botao1 = new JButton("OK!");
		JButton botao2 = new JButton("Close!");
		
		//botao1.setBounds(20, 340, 60, 20);
		//botao2.setBounds(130, 340, 60, 20);
		
		botao1.setActionCommand("OKAAAAAY!");
		botao2.setActionCommand("F*ck this shit i'm out!");
		
		HeyListen listen = new HeyListen();
		
		botao1.addActionListener(listen);
		botao2.addActionListener(listen);
		
		panelC.add(botao1);
		panelC.add(botao2);
		pack();
	}
}
