package am.telas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import am.bd.Banco;
import am.main.Despesas;
import am.utils.Utils;

public class PanelCDespesa extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
	Despesas d;
	
	public static int ID = 0;
	
	NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

	JOptionPane p = new JOptionPane();
	
	JLabel head = new JLabel("Cadastrar Despesa:");
	JLabel nome = new JLabel("Nome:");
	JLabel frequencia = new JLabel("Frequência:");
	JLabel valor = new JLabel("Valor:");
	JLabel vencimento = new JLabel("Vencimento:");
	
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JFormattedTextField field = new JFormattedTextField();
	JFormattedTextField tf = new JFormattedTextField();
	
	JButton b1 = new JButton("Cadastrar");
	
	
	public PanelCDespesa(){
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
		frequencia.setForeground(Utils.preto);
		valor.setForeground(Utils.preto);
		vencimento.setForeground(Utils.preto);
		
		nome.setFont(Utils.f1);
		frequencia.setFont(Utils.f1);
		valor.setFont(Utils.f1);
		vencimento.setFont(Utils.f1);
		
		nome.setBounds(150, 80, 93, 43);
		frequencia.setBounds(150, 120, 140, 43);
		valor.setBounds(150, 160, 93, 43);
		vencimento.setBounds(150, 200, 142, 43);
		
		add(nome);
		add(frequencia);
		add(valor);
		add(vencimento);
		
		//Campo Formularios
		t1.setBounds(330, 90, 200, 30);
		t2.setBounds(330, 130, 200, 30);
		//Formatar campo de valor 
		format.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(1.0);
		formatter.setMaximum(1000000.0);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		field = new JFormattedTextField(formatter);
		field.setValue(1.0);
		field.setBounds(330, 170, 200, 30);
		//Formatar campo de vencimento
		try {
			tf = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tf.setBounds(330, 210, 200, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		add(t1);
		add(t2);
		add(field);
		add(tf);
		
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
	public void actionPerformed(ActionEvent e) {
		
		if(!Utils.isVazia(t1.getText()) && !Utils.isVazia(t2.getText()) && !Utils.isVazia(field.getText())
				&& !Utils.isVazia(tf.getText())){
			
			boolean i = true;
			
			d = new Despesas();
			
			d.setNome(t1.getText());
			d.setFrequencia(t2.getText());
			d.setValor(field.getText());
			d.setVencimento(tf.getText());			
			d.setCpf(Banco.selectSindico(con, PanelLogin.log));
			
			do{
				try {
					d.setId(ID);
					Banco.inserir(con, d, "despesas");
					i = false;
				} catch (SQLException e1) {
					ID++;
					i = true;
				}
			}while(i);
			
			try {
				Banco.select(con, "despesas");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(p, "Despesa Cadastrada!");
			
			t1.setText("");
			t2.setText("");
			field.setValue(1.0);
			tf.setText("");
			
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();
		}
		else{
			JOptionPane.showMessageDialog(p, "Erro digite de novo!");
		}
	}
	
}
