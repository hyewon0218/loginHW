package login;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame{

	private JTextField jtfId;
	private JPasswordField jpfPw;
	private JButton jbLogin,jbSingUp;
	private JLabel jlForgotPass;
	
	public LoginView() {
		super("Simple Login");
		JLabel jlTitle=new JLabel("Simple Login");
		jlTitle.setFont(new Font("SanseSerif", Font.BOLD, 18));
		JLabel jlId=new JLabel("���̵�");
		JLabel jlPw=new JLabel("��й�ȣ");
		jtfId=new JTextField();
		jpfPw=new JPasswordField();
		jbLogin=new JButton("�α���");
		jbSingUp=new JButton("ȸ������");
		jlForgotPass=new JLabel("��й�ȣ ã��");
		
		setLayout(null);
		
		jlTitle.setBounds(130, 10, 200, 30);
		jlId.setBounds(43, 55, 50, 20);
		jlPw.setBounds(30, 80, 80, 20);
		jtfId.setBounds(100, 55, 190, 20);
		jpfPw.setBounds(100, 80, 190, 20);
		jbLogin.setBounds(100, 110, 190, 20);
		jbSingUp.setBounds(100, 135, 190, 20);
		jlForgotPass.setBounds(150, 160, 100, 20);
		
		add(jlTitle);
		add(jlId);
		add(jlPw);
		add(jtfId);
		add(jpfPw);
		add(jbLogin);
		add(jbSingUp);
		add(jlForgotPass);
		
		LoginController lc=new LoginController(this);
		addWindowListener(lc);
		jtfId.addActionListener(lc);
		jpfPw.addActionListener(lc);
		jbLogin.addActionListener(lc);
		jbSingUp.addActionListener(lc);
		
		
		setBounds(200, 100, 350, 230);
		setResizable(false);
		setVisible(true);
		
		jtfId.requestFocus();
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JButton getJbLogin() {
		return jbLogin;
	}

	public JButton getJbSingUp() {
		return jbSingUp;
	}

	public JLabel getJlForgotPass() {
		return jlForgotPass;
	}
	
	
}
