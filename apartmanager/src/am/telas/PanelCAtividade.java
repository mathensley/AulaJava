package am.telas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import am.bd.Banco;
import am.main.Atividades;
import am.utils.Utils;

//Panel do FrameCAtividade
public class PanelCAtividade extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	Atividades a;
	Connection con = null;
	
	public static int IDA = 0;
	
	String tipos[] = {"Agendada", "Finalizada"};
	
	JOptionPane p = new JOptionPane();
	
	JLabel head = new JLabel("Cadastrar Atividade:");
	JLabel nome = new JLabel("Nome:");
	JLabel data = new JLabel("Data:");
	JLabel status = new JLabel("Status:");
	
	JTextField t1 = new JTextField();
	JFormattedTextField tf = new JFormattedTextField();
	JComboBox cb;
	
	JButton b1 = new JButton("Cadastrar");
	
	
	public PanelCAtividade(){
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
		head.setBounds(140, 4, 240, 43);
		panelCima.add(head);
		
		//Nome formularios
		nome.setForeground(Utils.preto);
		data.setForeground(Utils.preto);
		status.setForeground(Utils.preto);
		
		nome.setFont(Utils.f1);
		data.setFont(Utils.f1);
		status.setFont(Utils.f1);
		
		nome.setBounds(150, 80, 93, 43);
		data.setBounds(150, 120, 140, 43);
		status.setBounds(150, 160, 93, 43);
		
		add(nome);
		add(data);
		add(status);
		
		//Campo Formularios
		t1.setBounds(330, 90, 200, 30);
			//Formatar campo de data
		try {
			tf = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tf.setBounds(330, 130, 200, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cb = new JComboBox(tipos);
		cb.setBounds(330, 170, 200, 30);
		cb.setBackground(Utils.branco);
		
		add(t1);
		add(tf);
		add(cb);
		
		//Botao
		b1.setBounds(410, 544, 174, 52);
		b1.setBackground(Utils.branco);
		b1.addActionListener(this);
		add(b1);
		
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
	public void actionPerformed(ActionEvent e){
		
		//Validação e cadastro de atvidade de acordo com o cpf do sindico 
		if(!Utils.isVazia(t1.getText()) && !Utils.isVazia(tf.getText())){
			boolean i = true;
			
			a = new Atividades();
			
			a.setNome(t1.getText());
			a.setData(tf.getText());
			a.setStatus((String) cb.getItemAt(cb.getSelectedIndex()));
			a.setCpf(Banco.selectSindico(con, PanelLogin.log));
			
			do{
				try {
					a.setId(IDA);
					Banco.inserir(con, a, "atividades");
					i = false;
				} catch (SQLException e1) {
					IDA++;
					i = true;
				}
			}while(i);
			
			JOptionPane.showMessageDialog(p, "Atividade Cadastrada!");
			
			t1.setText("");
			tf.setText("");
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(p, "Erro digite de novo!");
		}
	}

}
