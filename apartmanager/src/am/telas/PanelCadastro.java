package am.telas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import am.bd.Banco;
import am.main.Cadastro;
import am.utils.Utils;

//Panel do FrameCadastro
public class PanelCadastro extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
	
	JOptionPane p = new JOptionPane();
	
	JButton b1 = new JButton("Cadastrar");
	
	JLabel head = new JLabel("Cadastramento:");
	JLabel nome = new JLabel("Nome:");
	JLabel email = new JLabel("Email:");
	JLabel senha = new JLabel("Senha:");
	JLabel confSenha = new JLabel("Confirmar Senha:");
	JLabel cpf = new JLabel("CPF:");
	JLabel fone = new JLabel("Fone:");
	JLabel apto = new JLabel("Apartamento:");
	JLabel tipo = new JLabel("Tipo:");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JPasswordField p1 = new JPasswordField();
	JPasswordField p2 = new JPasswordField();
	JTextField t5 = new JTextField();
	JComboBox cb;
	
	Cadastro c = new Cadastro();
	
	
	public PanelCadastro(String tipos[]){
		//Background principal
		setBackground(Utils.laranjaClaro);
		setSize(700, 700);
		setLayout(null);
		
		//Background head
		JPanel panelCima = new JPanel();
		panelCima.setBounds(88, 0, 510, 60);
		panelCima.setBackground(Utils.cinzaClaro);
		add(panelCima);
		panelCima.setLayout(null);
		panelCima.setVisible(true);
		
		//Head		
		head.setForeground(Utils.branco);
		head.setFont(Utils.f2);
		head.setBounds(160, 4, 193, 43);
		panelCima.add(head);
		
		//Nome formularios
		nome.setForeground(Utils.preto);
		email.setForeground(Utils.preto);
		senha.setForeground(Utils.preto);
		confSenha.setForeground(Utils.preto);
		cpf.setForeground(Utils.preto);
		fone.setForeground(Utils.preto);
		apto.setForeground(Utils.preto);
		tipo.setForeground(Utils.preto);
		
		nome.setFont(Utils.f1);
		email.setFont(Utils.f1);
		senha.setFont(Utils.f1);
		confSenha.setFont(Utils.f1);
		cpf.setFont(Utils.f1);
		fone.setFont(Utils.f1);
		apto.setFont(Utils.f1);
		tipo.setFont(Utils.f1);
		
		nome.setBounds(150, 80, 93, 43);
		email.setBounds(150, 120, 93, 43);
		senha.setBounds(150, 160, 93, 43);
		confSenha.setBounds(150, 200, 142, 43);
		cpf.setBounds(150, 240, 93, 43);
		fone.setBounds(150, 280, 93, 43);
		apto.setBounds(150, 320, 142, 43);
		tipo.setBounds(150, 360, 93, 43);
		
		add(nome);
		add(email);
		add(senha);
		add(confSenha);
		add(cpf);
		add(fone);
		add(apto);
		add(tipo);
		
		//Campo Formularios
		cb = new JComboBox(tipos);
		t1.setBounds(330, 90, 200, 30);
		t2.setBounds(330, 130, 200, 30);
		p1.setBounds(330, 170, 200, 30);
		p2.setBounds(330, 210, 200, 30);
		t3.setBounds(330, 250, 200, 30);
		t4.setBounds(330, 290, 200, 30);
		t5.setBounds(330, 330, 200, 30);
		cb.setBounds(330, 370, 200, 30);
		cb.setBackground(Utils.branco);
		
		add(t1);
		add(t2);
		add(p1);
		add(p2);
		add(t3);
		add(t4);
		add(t5);
		add(cb);
		
		//Botao
		b1.setBounds(410, 544, 174, 52);
		b1.setBackground(Utils.branco);
		add(b1);
		b1.addActionListener(this);
		
		//Background botao
		JPanel panelB = new JPanel();
		panelB.setBounds(407, 540, 180, 60);
		panelB.setBackground(Utils.laranjaClaro);
		add(panelB);
		panelB.setLayout(null);
		
		//Imagem footer do panelMeio
		ImageIcon img = new ImageIcon("Image/footerV.png");
		JLabel foot = new JLabel();
		foot.setBounds(88, 470, 160, 140);
		Image imagem = img.getImage().getScaledInstance(foot.getWidth(), foot.getHeight(), Image.SCALE_DEFAULT);
		foot.setIcon(new ImageIcon(imagem));
		add(foot);
		
		//Background formularios
		JPanel panelMeio = new JPanel();
		panelMeio.setBounds(88, 60, 510, 550);
		panelMeio.setBackground(Utils.branco);
		add(panelMeio);
		panelCima.setLayout(null);
		panelCima.setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//Validação e cadastramento dos dados
		if(!Utils.isVazia(t1.getText()) && !Utils.isVazia(t2.getText()) && !Utils.isVazia(t3.getText()) && 
				!Utils.isVazia(t4.getText()) && !Utils.isVazia(t5.getText()) && !Utils.isVazia(p1.getPassword()) && !Utils.isVazia(p2.getPassword())){
			
			c.setNome(t1.getText());
			c.setFone(t4.getText());
			
			if(!Utils.isEmail(con, t2.getText()))
				c.setEmail(t2.getText());
			else{
				JOptionPane.showMessageDialog(p, "Email já existe ou está incorreto");
				t2.setText("");
				return;
			}
			if(Utils.isSenha(p1.getPassword(), p2.getPassword()))
				c.setSenha(p1.getPassword());
			else{
				JOptionPane.showMessageDialog(p, "A senha precisa ter no mínimo 6 caracteres, e pelo menos"
						+ " um número");
				p1.setText("");
				p2.setText("");
				return;
			}
			//if(Utils.isCPF(t3.getText()))
				c.setCpf(t3.getText());
			/*else{
				JOptionPane.showMessageDialog(p, "CPF Inválido");
				t3.setText("");
				return;
			}*/
				
			c.setApto(t5.getText());
			
			c.setTipo((String) cb.getItemAt(cb.getSelectedIndex()));
			
			try {
				Banco.inserir(con, c, "cadastro");
				JOptionPane.showMessageDialog(p, "Cadastro efetuado com sucesso!");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(p, "CPF já existe!");
				t3.setText("");
				return;
			}
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			p1.setText("");
			p2.setText("");
			t5.setText("");
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(p, "Digite os dados corretos!");
		}
	}

}
