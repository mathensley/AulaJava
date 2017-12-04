package am.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import am.bd.Banco;
import am.utils.Utils;

public class PanelDeletar extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;


	public static String table;
	public static String coluna;
	public static boolean string;
	
	Connection c = null;
	
	JOptionPane p = new JOptionPane();
	
	JTextField t1 = new JTextField();
	
	JButton b1 = new JButton("Remover");
	
	
	public PanelDeletar(String h1, String h2, String tab, String col, boolean str){
		//Cor do background principal
		setBackground(Utils.laranjaClaro);
		setSize(400, 400);
		setLayout(null);
		
		//Background dos forms
		JPanel panel1 = new JPanel();
		panel1.setBounds(6, 10, 380, 350);
		panel1.setBackground(Utils.branco);
		add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(true);
		
		//Head
		JLabel head = new JLabel(h1);
		head.setForeground(Utils.preto);
		head.setFont(Utils.f1);
		head.setBounds(100, 2, 210, 43);
		panel1.add(head);
		
		//Texto formulario
		JLabel l1 = new JLabel(h2);
		l1.setForeground(Utils.preto);
		l1.setFont(Utils.f1);
		l1.setBounds(10, 120, 150, 43);
		panel1.add(l1);
		
		//Form
		t1.setBounds(150, 126, 200, 30);
		panel1.add(t1);
		
		//Botão
		b1.setBounds(170, 220, 154, 42);
		b1.setBackground(Utils.laranjaClaro);
		b1.setForeground(Utils.branco);
		b1.setFont(Utils.f1);
		b1.addActionListener(this);
		panel1.add(b1);
		
		table = tab;
		coluna = col;
		string = str;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!Utils.isVazia(t1.getText())){
			String id = t1.getText();
			int id1;
			
			if(!string){
				try{
					id1 = Integer.parseInt(id);
					
					try {
						if(Banco.isId(c, id1, table)){
							String cpf = Banco.selectCpf(c, table, id1);
							if(cpf.equals(PanelLogin.sind))
								Banco.delete(c, table, coluna, id1);
							else{
								t1.setText("");
								JOptionPane.showMessageDialog(p, "Digite um valor de acordo com o síndico logado!");
								return;
							}
						}
						else{
							t1.setText("");
							JOptionPane.showMessageDialog(p, "Valor não existe");
							return;
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(p, "Digite um valor válido!");
						t1.setText("");
						return;
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(p, "Digite um valor válido!");
					t1.setText("");
					return;
				}
			}
			else{
				
				try {
					if(Banco.isCpf(c, id, table))
						if(!id.equals(PanelLogin.sind))
							Banco.delete(c, table, coluna, id);
						else{
							t1.setText("");
							JOptionPane.showMessageDialog(p, "Digite um cpf que não seja do síndico logado!");
							return;
						}
					else{
						t1.setText("");
						JOptionPane.showMessageDialog(p, "Valor não existe");
						return;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(p, "Digite um valor válido!");
					t1.setText("");
					//e1.printStackTrace();
					return;
				}
				
			}
			
			JOptionPane.showMessageDialog(p, "Removido com sucesso!");
			
			t1.setText("");
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(p, "Erro digite de novo!");
		}
	}
}
