package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HeyListen implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botaoClicado = (JButton) e.getSource();
		
		JOptionPane.showMessageDialog(null, botaoClicado.getActionCommand());
	}

}
