package login;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpView extends JDialog{
	
	private JTextField jtfId, jtfTel1, jtfTel2, jtfTel3, jtfEmail1,jtfEmail2;
	private JPasswordField jpfPw1,jpfPw2;
	private JButton jbSingUp, jbCancel;
	private JComboBox<String> jcbEmail;
	private static LoginView lv;
	
	public SignUpView(LoginView lv) {
		super(lv,"Sign up",true);
		JLabel jlTitle=new JLabel("회원가입");
		jlTitle.setFont(new Font("SanseSerif", Font.BOLD, 18));
		JLabel jlId=new JLabel("아이디");
		JLabel jlPw=new JLabel("비밀번호");
		JLabel jlPw2=new JLabel("비밀번호 확인");
		JLabel jlPhone=new JLabel("핸드폰");
		JLabel jlEmail=new JLabel("이메일");
		JLabel jlAt=new JLabel("@");
		jlAt.setFont(new Font("SanseSerif", Font.PLAIN, 10));
		
		jtfId=new JTextField();
		jpfPw1=new JPasswordField();
		jpfPw2=new JPasswordField();
		jtfTel1=new JTextField();
		jtfTel2=new JTextField();
		jtfTel3=new JTextField();
		jtfEmail1=new JTextField();
		jtfEmail2=new JTextField();
		String[] email= {"NAVER","DAUM","GOOGLE","직접입력"};
		jcbEmail=new JComboBox<String>(email);
		jcbEmail.setFont(new Font("SanseSerif", Font.PLAIN, 10));
		jbSingUp=new JButton("회원가입");
		jbCancel=new JButton("취소");
		
		setLayout(null);
		
		jlTitle.setBounds(130, 10, 200, 30);
		jlId.setBounds(43, 55, 50, 20);
		jlPw.setBounds(30, 80, 80, 20);
		jlPw2.setBounds(3, 105, 83, 20);
		jlPhone.setBounds(43, 130, 80, 20);
		jlEmail.setBounds(43, 155, 80, 20);
		jlAt.setBounds(155, 155, 10, 20);
		
		jtfId.setBounds(100, 55, 190, 20);
		jpfPw1.setBounds(100, 80, 190, 20);
		jpfPw2.setBounds(100, 105, 190, 20);
		jtfTel1.setBounds(100, 130, 50, 20);
		jtfTel2.setBounds(170, 130, 50, 20);
		jtfTel3.setBounds(240, 130, 50, 20);
		
		jtfEmail1.setBounds(100, 155, 50, 20);
		jtfEmail2.setBounds(175, 155, 50, 20);
		jcbEmail.setBounds(230, 155, 60, 20);
		
		jbSingUp.setBounds(100, 200, 90, 20);
		jbCancel.setBounds(200, 200, 90, 20);
		
		add(jlTitle);
		add(jlId);
		add(jlPw);
		add(jlPw2);
		add(jlPhone);
		add(jlEmail);
		add(jlAt);
		add(jtfId);
		add(jpfPw1);
		add(jpfPw2);
		add(jtfTel1);
		add(jtfTel2);
		add(jtfTel3);
		add(jtfEmail1);
		add(jtfEmail2);
		add(jcbEmail);
		add(jbSingUp);
		add(jbCancel);
		
		SignUpController suc=new  SignUpController(this);
		addWindowListener(suc);
		jtfEmail2.addActionListener(suc);
		jcbEmail.addActionListener(suc);
		jbSingUp.addActionListener(suc);
		jbCancel.addActionListener(suc);
		
		setBounds(200, 100, 350, 500);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SignUpView(lv);
	}
	public JTextField getJtfId() {
		return jtfId;
	}
	public JTextField getJtfTel1() {
		return jtfTel1;
	}
	public JTextField getJtfTel2() {
		return jtfTel2;
	}
	public JTextField getJtfTel3() {
		return jtfTel3;
	}
	public JTextField getJtfEmail1() {
		return jtfEmail1;
	}
	public JTextField getJtfEmail2() {
		return jtfEmail2;
	}
	public JPasswordField getJpfPw1() {
		return jpfPw1;
	}
	public JPasswordField getJpfPw2() {
		return jpfPw2;
	}
	public JButton getJbSingUp() {
		return jbSingUp;
	}
	public JButton getJbCancel() {
		return jbCancel;
	}
	public JComboBox<String> getJcbEmail() {
		return jcbEmail;
	}
	public static LoginView getLv() {
		return lv;
	}
	
}
