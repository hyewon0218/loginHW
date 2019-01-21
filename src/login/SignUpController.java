package login;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpController extends WindowAdapter implements ActionListener {
	private SignUpView suv;
	private LoginDVO l_dvo;
	private UserInfoVO uivo;

	public SignUpController(SignUpView suv) {
		this.suv = suv;
	}

	public void test() {
//		PASSWORD_CONFIRM �Է� ��ȣ�� ����
//		Email ���Ŀ� �´� �̸��� 
		JTextField jtfId = suv.getJtfId();
		String id = jtfId.getText().trim();

		if (id.equals("")) {
			showMessageDialog(suv, "ID�� �ʼ� �Է��Դϴ�.");
			jtfId.setText("");
			jtfId.requestFocus();
			return;
		} // end if

		boolean flag = true;
		

		JTextField jpfPw = suv.getJpfPw1();
		String password = jpfPw.getText().trim();

		if (password.equals("")) {
			showMessageDialog(suv, "PASSWORD�� �ʼ� �Է��Դϴ�.");
			jtfId.setText("");
			jtfId.requestFocus();
			return;

		} // end if

		JTextField jtfTel1 = suv.getJtfTel1();
		JTextField jtfTel2 = suv.getJtfTel2();
		JTextField jtfTel3 = suv.getJtfTel3();

		String tel1 = jtfTel1.getText().trim();
		String tel2 = jtfTel1.getText().trim();
		String tel3 = jtfTel1.getText().trim();
		
		StringBuilder tel= new StringBuilder();
		tel.append(tel1).append(tel2).append(tel3);
		

		if (tel1.equals("") || tel2.equals("") || tel3.equals("")) {
			showMessageDialog(suv, "��ȭ��ȣ�� �ʼ� �Է��Դϴ�.");
			jtfTel1.setText("");
			jtfTel1.requestFocus();
			return;
		} // end if

		boolean specialKey = false;



		JTextField jpfPw2= suv.getJpfPw2();
		String password_confirm = jpfPw.getText().trim();
	      if( !( password.equals(password_confirm) ) ){
	          JOptionPane.showMessageDialog(suv, "���Է��� ��й�ȣ�� ���� �ʽ��ϴ�.");
	          flag = false ; 
	      }

	      try {
				if (tel1.length() != 3 || !(tel2.length() > 2 && tel2.length() < 5) || (tel3.length() != 4)) {
					JOptionPane.showMessageDialog(suv, "��ȭ��ȣ�� �ڸ����� �߸��Ǿ����ϴ�.");
					return;
				} // end if
				Integer.parseInt(tel1);
				Integer.parseInt(tel2);
				Integer.parseInt(tel3);

			
		} catch (NumberFormatException nfe) {
			showMessageDialog(suv, "��ȭ��ȣ�� ���ڿ��� ����ֽ��ϴ�.");
			return;
		} // end catch
		
		JTextField jtfEmail = suv.getJtfEmail1();
		String email = jtfEmail.getText().trim();
		///
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		suv.dispose();
	}
  
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == suv.getJbSingUp()) {
			test();///
			String id=suv.getJtfId().getText().trim();
			
			String pass=suv.getJpfPw1().getText().trim();
			
			String tel1=suv.getJtfTel1().getText().trim();
			
			String tel2=suv.getJtfTel2().getText().trim();
			
			String tel3=suv.getJtfTel3().getText().trim();
			
			StringBuilder tel=new StringBuilder();
			tel.append(tel1).append("-").append(tel2).append("-").append(tel3);
			
			String email1=suv.getJtfEmail1().getText().trim();

			String email2=suv.getJtfEmail2().getText().trim();
			
			StringBuilder email=new StringBuilder();
			email.append(email1).append("@").append(email2);
			
			
			uivo=new UserInfoVO(id, pass, tel.toString(), email.toString());/////////
					
			try {
				LoginDVO.getInstance().insertLunch(uivo);
				JOptionPane.showMessageDialog(suv, "ȸ�������� �Ǿ����ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ae.getSource() == suv.getJcbEmail()) {
			String email = (String) suv.getJcbEmail().getSelectedItem();
			suv.getJtfEmail2().setText(email);
		}
		if (ae.getSource() == suv.getJbCancel()) {
			suv.dispose();
		}
	}
//	public void signUp() {
//		
//	}
//	public boolean vaildEmail(String ) {
//		
//	}
}
