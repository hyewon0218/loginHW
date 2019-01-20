package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginController extends WindowAdapter implements ActionListener{

	private LoginView lv;
	private SignUpView suv;
	
	public LoginController(LoginView lv) {
		this.lv=lv;
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		lv.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lv.getJbSingUp())
			
			new SignUpView(lv);
			
			
			
		if(!checkIDEmpty() && !checkPassEmpty()) {
			JTextField jtf=lv.getJtfId();
			JPasswordField jpf=lv.getJpfPw();
			
			String id=jtf.getText().trim();
			String pass=new String(jpf.getPassword());
			
			
			LoginVO lvo=new LoginVO(id, pass);
			String adminName=login(lvo);
			
			if(adminName.equals("")) {
				JOptionPane.showMessageDialog(lv, "아이디나 비밀번호를 확인하세요.");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			}else {

				lv.dispose();
			}//end else
		}//end if              
	}                                     
	private boolean checkIDEmpty() {
		boolean flag=false;
		JTextField jtfId=lv.getJtfId();
		if(jtfId.getText().trim().equals("")) {
			jtfId.setText("");
			jtfId.requestFocus();
			flag=true;
		}
		return flag;
	}//checkID
	
	private boolean checkPassEmpty() {
		boolean flag=false;
		JPasswordField jpfPass=lv.getJpfPw();
		String pass=new String(jpfPass.getPassword());
		
		if(pass.trim().equals("")) {
			jpfPass.setText("");
			jpfPass.requestFocus();
			flag=true;
		}//end if
		
		return flag;
	}//checkPass
	
	private String login(LoginVO lvo) {
		String adminName="";
		
		LoginDVO l_dao=LoginDVO.getInstance();
		try {
			adminName=l_dao.login(lvo);//로그인성공
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lv, "DB에서 문제가 발생했습니다.");
			e.printStackTrace();
		}//end catch
		
		
		return adminName;
	}
	public void signUp() {
		
	}
}
