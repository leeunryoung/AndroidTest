package kkk2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import j230616.MemberDAO;

//import j230616.MemberDTO;
//import j230616.Member_List;

import j230616.MemberDTO;
import DAO.MemberLoginDAO;
//import DAO.MemberLoginDao;

public class LoginFrame extends JFrame{
	  private JPanel contentPane;
      private JTextField tfId, tfPassword;
      private JButton loginBtn, joinBtn;

      /**
       * Launch the application.
       */
      public static void main(String[] args) {
             EventQueue.invokeLater(new Runnable() {
                    public void run() {
                         try {
                                 LoginFrame frame = new LoginFrame();                              
                          } catch (Exception e) {
                                 e.printStackTrace();
                          }
                    }
             });
      }
    /**
   * Create the frame.
       */
      public LoginFrame() {
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setSize(400, 300);

             setLocationRelativeTo(null);
             contentPane = new JPanel();
             contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
             setContentPane(contentPane);
             contentPane.setLayout(null);
         

             JLabel lblLogin = new JLabel("ID");
             lblLogin.setBounds(41, 52, 69, 35);
             contentPane.add(lblLogin);

             JLabel lblPassword = new JLabel("Password");
             lblPassword.setBounds(41, 103, 69, 35);
             contentPane.add(lblPassword);

             tfId = new JTextField();
             tfId.setBounds(157, 52, 176, 35);

             contentPane.add(tfId);
             tfId.setColumns(10);
           
             joinBtn = new JButton("회원가입");
             joinBtn.setBounds(229, 154, 104, 29);
             contentPane.add(joinBtn);
       
             loginBtn = new JButton("로그인");
             loginBtn.setBounds(108, 154, 106, 29);
             contentPane.add(loginBtn);
             tfPassword = new JTextField();
             tfPassword.setColumns(10);
             tfPassword.setBounds(157, 103, 176, 35);
             contentPane.add(tfPassword);

             setVisible(true);

             //회원가입 액션
             joinBtn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                          JoinFrame frame = new JoinFrame();
                 }
             });

             //로그인 액션
             loginBtn.addActionListener(new ActionListener() {
                    @Override
                   public void actionPerformed(ActionEvent e) {
                          String id = tfId.getText();
                     String pwd = tfPassword.getText();
        
                     MemberLoginDao dao = MemberLoginDao.getInstance();
                     int result = dao.findByUsernameAndPassword(id, pwd);
                    if (result == 1) {
                           JOptionPane.showMessageDialog(null, "로그인 성공");
                           dispose();

                     } else {
                           JOptionPane.showMessageDialog(null, "로그인 실패");
                           // setVisible(false); // 기존의 로그인 화면 꺼주기
                                 }
                                 // 새로운 화면 구현
                          }
                    });
   }

}
