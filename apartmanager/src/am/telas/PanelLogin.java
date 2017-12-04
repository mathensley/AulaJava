package am.telas;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import am.bd.Banco;
import am.utils.Utils;

public class PanelLogin extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage img;
	
	Connection c = null;
	
	JOptionPane p = new JOptionPane();
	
	JButton b1 = new JButton("Entrar");
	JButton b2 = new JButton("Cadastrar");
	
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField();
	
	private String login;
	private String senha;
	
	public static String log;
	public static String sind;
	
	public PanelLogin(){
		//Cor do background principal
		setBackground(Utils.laranjaClaro);
		setSize(400, 500);
		setLayout(null);
		
		//Background dos forms
		JPanel panel1 = new JPanel();
		panel1.setBounds(4, 4, 385, 295);
		panel1.setBackground(Utils.branco);
		add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(true);
		
		//Botoes
		b1.setBounds(98, 184, 174, 52);
		b1.setBackground(Utils.branco);
		b2.setBounds(136, 250, 95, 20);
		b2.setBackground(Utils.branco);
		panel1.add(b1);
		panel1.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		
		//Campo formularios
		t1.setBounds(60, 50, 260, 30);
		t2.setBounds(60, 120, 260, 30);
		panel1.add(t1);
		panel1.add(t2);
		t1.addActionListener(this);
		t2.addActionListener(this);
		
		//Nome formularios
		JLabel login = new JLabel("Login:");
		JLabel senha = new JLabel("Senha:");
		login.setForeground(Utils.preto);
		senha.setForeground(Utils.preto);
		login.setFont(Utils.f1);
		senha.setFont(Utils.f1);
		login.setBounds(45, 16, 93, 43);
		senha.setBounds(45, 88, 93, 43);
		panel1.add(login);
		panel1.add(senha);
		
		
		//
		JPanel panel2 = new JPanel();
		panel2.setBounds(95, 180, 180, 60);
		panel2.setBackground(Utils.laranjaClaro);
		panel1.add(panel2);
		panel2.setLayout(null);
		
		//Imagem do footer
		try {
			img = ImageIO.read(new File("Image//footer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 250, this);            
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1 || e.getSource() == t1 || e.getSource() == t2){
			if(!Utils.isVazia(t1.getText()) && !Utils.isVazia(t2.getPassword())){
				setLogin(t1.getText());
				setSenha(t2.getPassword());
				try {
					if(Banco.selectLogin(c, getLogin(), getSenha(), "Síndico")){
						log = t1.getText();
						
						sind = Banco.selectSindico(c, t1.getText());
						
						t1.setText("");
						t2.setText("");
						
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
						frame.dispose();
						
						new FrameApp();
					}
					else{
						JOptionPane.showMessageDialog(p, "Erro digite de novo!");
						t2.setText("");
					}
				} catch (HeadlessException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(p, "Erro digite de novo!");
			}
		}
		
		if(e.getSource() == b2){
			if(Banco.isSindico(c)){
				String tipos[] = {"Condômino"};
				new FrameCadastro(tipos);
			}
			else
				new FrameCadastro();
				
		}
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(char[] cs) {
		this.senha = String.valueOf(cs);
	}
}
