package 유;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Moon_air extends JFrame {

	private JPanel contentPane;
	private JPanel newPanel[] = new JPanel[6]; //예약, 예약확인, 마이페이지, 관리자의 정보를 나타내는 패널들
	private JPanel rsvPanel = new JPanel(); // 예약패널에 마우스를 올리면 버튼 3개가 나타날 수 있도록....하기 위해서
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moon_air ma = new Moon_air();
					ma.logIn();
					ma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Moon_air() {
		logIn();
	}
	
	public void logIn() {
	
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 204, 0));
		panel.setBounds(0, 0, 1076, 390);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(252, 449, 311, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 569, 311, 59);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBackground(new Color(255, 204, 102));
		btnLogIn.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		btnLogIn.setBounds(636, 446, 197, 59);
		contentPane.add(btnLogIn);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 204, 102));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		lblId.setBounds(209, 402, 116, 49);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setForeground(new Color(255, 204, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		lblNewLabel.setBounds(209, 521, 116, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				SecondFrame();
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		btnNewButton.setBounds(636, 566, 197, 59);
		contentPane.add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	//일단 signIn버튼 누르고 두번째 장 시작하는걸로 했어요 
	public void SecondFrame() {
		
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1093, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rsvLabel = new JLabel();
		rsvLabel.setText("Reservation");
		rsvLabel.setVerticalTextPosition(SwingConstants.CENTER);
        rsvPanel = new JPanel(); //예약 패널 
        rsvPanel.add(rsvLabel);
        rsvPanel.setBackground(new Color(255, 204, 0));
        rsvPanel.setBounds(0, 0, 273, 200);
		contentPane.add(rsvPanel);
		rsvPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
		    // 마우스가 패널안에 들어가면 버튼을 누를 수 있게 바뀜
			JPanel rsvPanel = (JPanel)e.getSource();
			rsvPanel.setVisible(false);
	
			JButton reserve1 = new JButton("1");
			reserve1.setBackground(new Color(255, 204, 0));
			reserve1.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			reserve1.setBounds(0, 0, 91, 200);
			contentPane.add(reserve1);
			reserve1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			reserve1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
					//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
					newPanel[0] = new JPanel();
					contentPane.add(newPanel[0]);
					newPanel[0].setBackground(Color.cyan);
					newPanel[0].setBounds(0, 200, 1092, 542);
				}
			});
			
			JButton reserve2 = new JButton("2");
			reserve2.setBackground(new Color(255, 204, 0));
			reserve2.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			reserve2.setBounds(91, 0, 91, 200);
			contentPane.add(reserve2);
			reserve2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			reserve2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
					//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
					newPanel[1] = new JPanel();
					contentPane.add(newPanel[1]);
					newPanel[1].setBackground(Color.WHITE);
					newPanel[1].setBounds(0, 200, 1092, 542);
				}
			});
			
			JButton reserve3 = new JButton("3");
			reserve3.setBackground(new Color(255, 204, 0));
			reserve3.setFont(new Font("맑은 고딕", Font.BOLD, 10));
			reserve3.setBounds(182, 0, 91, 200);
			contentPane.add(reserve3);
			reserve3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			reserve3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
					//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
					newPanel[2] = new JPanel();
					contentPane.add(newPanel[2]);
					newPanel[2].setBackground(Color.orange);
					newPanel[2].setBounds(0, 200, 1092, 542);
				}
			});
			
			}
		});
		
		
		JButton confirm = new JButton("Confirmed");
		confirm.setBackground(new Color(255, 204, 0));
		confirm.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		confirm.setBounds(273, 0, 273, 200);
		contentPane.add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
				//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
				newPanel[3] = new JPanel();
				contentPane.add(newPanel[3]);
				newPanel[3].setBackground(Color.LIGHT_GRAY);
				newPanel[3].setBounds(0, 200, 1092, 542);
			}
		});
		
		JButton my_page = new JButton("My Page");
		my_page.setBackground(new Color(255, 204, 0));
		my_page.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		my_page.setBounds(546, 0,273, 200);
		contentPane.add(my_page);
		my_page.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		my_page.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
				//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
				newPanel[4] = new JPanel();
				contentPane.add(newPanel[4]);
				newPanel[4].setBackground(Color.green);
				newPanel[4].setBounds(0, 200, 1092, 542);
			}
		});
		
		JButton admin = new JButton("Adminsterator");
		admin.setBackground(new Color(255, 204, 0));
		admin.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		admin.setBounds(819, 0, 273, 200);
		contentPane.add(admin);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
				//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
				newPanel[5] = new JPanel();
				contentPane.add(newPanel[5]);
				newPanel[5].setBackground(Color.pink);
				newPanel[5].setBounds(0, 200, 1092, 542);
			}
		});
		
	}
	
}
