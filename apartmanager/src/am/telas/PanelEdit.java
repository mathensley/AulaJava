package am.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import am.bd.Banco;
import am.utils.Utils;

//Panel para a classe FrameEdit
public class PanelEdit extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Connection c = null;
	
	String tipos[] = {"Agendada", "Finalizada"};
	
	JOptionPane p = new JOptionPane();
	
	JTextField t1 = new JTextField();
	JComboBox cb;
	
	JButton b1 = new JButton("Atualizar");
	
	
	public PanelEdit(){
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
		JLabel head = new JLabel("EDITAR STATUS");
		head.setForeground(Utils.preto);
		head.setFont(Utils.f1);
		head.setBounds(120, 2, 210, 43);
		panel1.add(head);
		
		//Texto formulario
		JLabel l1 = new JLabel("Digite o ID:");
		JLabel l2 = new JLabel("Selecione o novo status:");
		l1.setForeground(Utils.preto);
		l2.setForeground(Utils.preto);
		l1.setFont(Utils.f1);
		l2.setFont(Utils.f1);
		l1.setBounds(10, 120, 150, 43);
		l2.setBounds(10, 160, 205, 43);
		panel1.add(l1);
		panel1.add(l2);
		
		//Form
		cb = new JComboBox(tipos);
		cb.setBounds(229, 168, 120, 30);
		cb.setBackground(Utils.branco);
		t1.setBounds(150, 126, 200, 30);
		panel1.add(t1);
		panel1.add(cb);
		
		//Botão
		b1.setBounds(110, 240, 154, 42);
		b1.setBackground(Utils.laranjaClaro);
		b1.setForeground(Utils.branco);
		b1.setFont(Utils.f1);
		b1.addActionListener(this);
		panel1.add(b1);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Validar se o valor digitado esta ligado ao sindico logado no momento
		if(!Utils.isVazia(t1.getText())){
			String id = t1.getText();
			int id1;
			
			try{
				id1 = Integer.parseInt(id);
				
				try {
					if(Banco.isId(c, id1, "atividades")){
						String cpf = Banco.selectCpf(c, "atividades", id1);
						if(cpf.equals(PanelLogin.sind))
							Banco.update(c, id1, (String) cb.getItemAt(cb.getSelectedIndex()));
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
			
			JOptionPane.showMessageDialog(p, "Atualizado com sucesso!");
			
			t1.setText("");
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(p, "Erro digite de novo!");
		}
	}
}
