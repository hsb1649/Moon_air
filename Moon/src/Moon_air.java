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
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Moon_air extends JFrame {

	private JPanel contentPane;
	private JPanel newPanel[] = new JPanel[6]; //예약, 예약확인, 마이페이지, 관리자의 정보를 나타내는 패널들
	private JPanel rsvPanel = new JPanel(); // 예약패널에 마우스를 올리면 버튼 3개가 나타날 수 있도록....하기 위해서
	private final JPanel panel = new JPanel();
	private JPanel panel_3= new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	ImageIcon icon,icon1,icon2,icon3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;
	
	String driver        = "org.mariadb.jdbc.Driver";
    //String url           = "jdbc:mariadb://103.218.162.26:3306/employees";
    String url           = "jdbc:mariadb://localhost:3307/univ";
    String uId           = "root";
    String uPwd          = "Eshowras1";

    Connection               con;
    PreparedStatement        pstmt;
    Statement        stmt;
    ResultSet                rs;
	
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
		
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, uId, uPwd);

            if( con != null ){ System.out.println("데이터 베이스 접속 성공"); }

        } catch (ClassNotFoundException e) { System.out.println("드라이버 로드 실패");    }
        catch (SQLException e) { System.out.println("데이터 베이스 접속 실패"); }
		
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 200, 1076, 503);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.DARK_GRAY);
		
		table_1 = new JTable();
		table_1.setBounds(165, 88, 779, 320);
		panel_4.add(table_1);
		panel_4.setVisible(false);
		
		
		JPanel Menu_Panel = new JPanel();
		Menu_Panel.setBackground(Color.DARK_GRAY);
		Menu_Panel.setBounds(0, 0, 1076, 703);
		contentPane.add(Menu_Panel);
		Menu_Panel.setLayout(null);
		Menu_Panel.setVisible(false);
		
		
		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(0, 200, 1076, 503);
		Menu_Panel.add(SearchPanel);
		SearchPanel.setLayout(null);
		SearchPanel.setBackground(Color.GRAY);
		SearchPanel.setVisible(false);
		
		table = new JTable();
		table.setBounds(33, 136, 1019, 263);
		SearchPanel.add(table);
		
		JButton reservationBtn = new JButton("\uC608\uC57D");
		reservationBtn.setForeground(new Color(255, 204, 0));
		reservationBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		reservationBtn.setBackground(Color.DARK_GRAY);
		reservationBtn.setBounds(955, 428, 97, 23);
		SearchPanel.add(reservationBtn);
		
		JPanel price_searchPanel = new JPanel();
		price_searchPanel.setLayout(null);
		price_searchPanel.setBackground(new Color(250, 200, 0));
		price_searchPanel.setBounds(41, 21, 630, 80);
		SearchPanel.add(price_searchPanel);
		price_searchPanel.setVisible(false);
		
		JLabel priceLbl = new JLabel("\uCD5C\uC18C\uAC00\uACA9");
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setForeground(Color.DARK_GRAY);
		priceLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		priceLbl.setBounds(49, 24, 68, 30);
		price_searchPanel.add(priceLbl);
		
		JLabel maxLbl = new JLabel("~");
		maxLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maxLbl.setForeground(Color.DARK_GRAY);
		maxLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		maxLbl.setBounds(262, 24, 68, 30);
		price_searchPanel.add(maxLbl);
		
		JButton button_1 = new JButton("\uAC80\uC0C9");
		button_1.setForeground(new Color(255, 204, 0));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(501, 30, 97, 23);
		price_searchPanel.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 31, 116, 21);
		price_searchPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 31, 116, 21);
		price_searchPanel.add(textField_2);
		
		JPanel date_searchPanel = new JPanel();
		date_searchPanel.setBounds(41, 21, 630, 80);
		SearchPanel.add(date_searchPanel);
		date_searchPanel.setLayout(null);
		date_searchPanel.setBackground(new Color(250, 200, 0));
		date_searchPanel.setVisible(false);
		
		JLabel strtdateLbl = new JLabel("\uCD9C\uBC1C\uB0A0\uC9DC");
		strtdateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		strtdateLbl.setForeground(Color.DARK_GRAY);
		strtdateLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		strtdateLbl.setBounds(29, 24, 72, 30);
		date_searchPanel.add(strtdateLbl);
		
		JLabel label_1 = new JLabel("\uB3C4\uCC29\uB0A0\uC9DC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_1.setBounds(265, 24, 71, 30);
		date_searchPanel.add(label_1);
		
		JButton button = new JButton("\uAC80\uC0C9");
		button.setForeground(new Color(255, 204, 0));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(501, 30, 97, 23);
		date_searchPanel.add(button);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(113, 30, 124, 21);
		date_searchPanel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(348, 30, 124, 21);
		date_searchPanel.add(dateChooser_1);
		
		JPanel city_searchPanel = new JPanel();
		city_searchPanel.setBackground(new Color(250, 200, 0));
		city_searchPanel.setBounds(41, 21, 630, 80);
		SearchPanel.add(city_searchPanel);
		city_searchPanel.setLayout(null);
		city_searchPanel.setVisible(false);
		
		JLabel strtLbl = new JLabel("\uCD9C\uBC1C\uC9C0");
		strtLbl.setBounds(31, 24, 57, 30);
		city_searchPanel.add(strtLbl);
		strtLbl.setForeground(Color.DARK_GRAY);
		strtLbl.setHorizontalAlignment(SwingConstants.CENTER);
		strtLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		JComboBox strtBox = new JComboBox();
		strtBox.setBounds(113, 24, 123, 30);
		city_searchPanel.add(strtBox);
		strtBox.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		try{
			   rs = stmt.executeQuery("select city_name from city");
			   while(rs.next())
			    strtBox.addItem(rs.getString(1));
			   
			   
			  System.out.println(strtBox.getSelectedItem());
			  }
			  catch(SQLException e)
			  {
			   e.getMessage();
			  }
		
		JLabel arrvLbl = new JLabel("\uB3C4\uCC29\uC9C0");
		arrvLbl.setBounds(262, 24, 57, 30);
		city_searchPanel.add(arrvLbl);
		arrvLbl.setHorizontalAlignment(SwingConstants.CENTER);
		arrvLbl.setForeground(Color.DARK_GRAY);
		arrvLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(345, 24, 123, 30);
		city_searchPanel.add(comboBox);
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JButton srchBtn = new JButton("\uAC80\uC0C9");
		srchBtn.setBounds(501, 30, 97, 23);
		city_searchPanel.add(srchBtn);
		srchBtn.setBackground(Color.DARK_GRAY);
		srchBtn.setForeground(new Color(255, 204, 0));
		srchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		JButton rsvBtn = new JButton("Reservation");
		rsvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rsvBtn.setBounds(0, 0, 273, 200);
		Menu_Panel.add(rsvBtn);
		rsvBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
			    // 마우스가 버튼위로 올라오면 이 버튼은 사라지고 도시,날짜,가격 검색 버튼이 보이도록 함
					rsvPanel.setVisible(true);
					rsvBtn.setVisible(false);
				}
		});
		rsvBtn.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		rsvBtn.setBackground(new Color(255, 204, 0));
		rsvPanel = new JPanel(); //예약 패널 
		rsvPanel.setBounds(0, 0, 273, 200);
		Menu_Panel.add(rsvPanel);
		rsvPanel.setBackground(new Color(255, 204, 0));
		rsvPanel.setLayout(null);
		rsvPanel.setVisible(false);
		
		JButton reserve1 = new JButton("\uB3C4\uC2DC\r\n\uAC80\uC0C9");
		reserve1.setBounds(0, 0, 91, 200);
		rsvPanel.add(reserve1);
		reserve1.setBackground(new Color(255, 204, 0));
		reserve1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JButton reserve2 = new JButton("\uB0A0\uC9DC\n\uAC80\uC0C9");
		reserve2.setBounds(91, 0, 91, 200);
		rsvPanel.add(reserve2);
		reserve2.setBackground(new Color(255, 204, 0));
		reserve2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JButton reserve3 = new JButton("\uAC00\uACA9\uAC80\uC0C9");
		reserve3.setBounds(182, 0, 91, 200);
		rsvPanel.add(reserve3);
		reserve3.setBackground(new Color(255, 204, 0));
		reserve3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		reserve3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reserve3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭하면 검색하는 Panel을 보여줌. + 가격 검색 Panel도 보여줌
				SearchPanel.setVisible(true);
				price_searchPanel.setVisible(true);
				date_searchPanel.setVisible(false);
				city_searchPanel.setVisible(false);
			}
			public void mouseExited(MouseEvent e) {
				//여기서 빠져나가면 Reservation 버튼 보이도록
				rsvPanel.setVisible(false);
				rsvBtn.setVisible(true);
			}
		});
		reserve2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reserve2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭하면 검색하는 Panel을 보여줌. + 날짜 검색 Panel도 보여줌
				SearchPanel.setVisible(true);
				price_searchPanel.setVisible(false);
				date_searchPanel.setVisible(true);
				city_searchPanel.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//여기서 빠져나가면 Reservation 버튼 보이도록
				rsvPanel.setVisible(false);
				rsvBtn.setVisible(true);
			}
		});
		reserve1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reserve1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭하면 검색하는 Panel을 보여줌. + 도시 검색 Panel도 보여줌
				SearchPanel.setVisible(true);
				price_searchPanel.setVisible(false);
				date_searchPanel.setVisible(false);
				city_searchPanel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//여기서 빠져나가면 Reservation 버튼 보이도록
				rsvPanel.setVisible(false);
				rsvBtn.setVisible(true);
			}
		});
		
		icon3 = new ImageIcon("./Image/탑승권.png");
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 200, 1076, 503);
		Menu_Panel.add(panel_3_1);
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.DARK_GRAY);
		panel_3_1.setVisible(false);
		
		JPanel C_Panel = new JPanel();
		C_Panel.setBounds(414, 136, 561, 220);
		panel_3_1.add(C_Panel);
		C_Panel.setLayout(null);
		C_Panel.setVisible(false);
		JPanel G_Panel = new JPanel() {
			public void paintComponent(Graphics g) {
		  		g.drawImage(icon2.getImage(),0,0,null);
			
		  		setOpaque(false);
		  		super.paintComponent(g);
			}
		};
		G_Panel.setBounds(414, 48, 596, 401);
		panel_3_1.add(G_Panel);
		G_Panel.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setBounds(111, 80, 111, 40);
		G_Panel.add(textField_6);
		textField_6.setColumns(10);
		G_Panel.setVisible(false);
		
		
		
		JPanel Q_Panel = new JPanel();
		Q_Panel.setBounds(414, 136, 561, 220);
		panel_3_1.add(Q_Panel);
		Q_Panel.setLayout(null);
		Q_Panel.setVisible(false); 
		
		textField_3 = new JTextField();
		textField_3.setSize(561, 220);
		C_Panel.add(textField_3);
		textField_3.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_3.setColumns(10);
		JPanel M_Panel = new JPanel() {
				public void paintComponent(Graphics g) {
	  		g.drawImage(icon1.getImage(),0,0,null);
		
	  		setOpaque(false);
	  		super.paintComponent(g);
		}
	};
		
				M_Panel.setBounds(414, 48, 596, 401);
				M_Panel.setLayout(null);
				M_Panel.setVisible(false);
				
					panel_3_1.add(M_Panel);
					
					textField_5 = new JTextField();
					textField_5.setBounds(111, 80, 111, 40);
					M_Panel.add(textField_5);
					textField_5.setHorizontalAlignment(SwingConstants.CENTER);
					textField_5.setText("1234");
					textField_5.setBackground(Color.WHITE);
					textField_5.setColumns(10);
					
					JButton btnNewButton_2 = new JButton("Mileage");
					btnNewButton_2.setBounds(126, 59, 139, 49);
					panel_3_1.add(btnNewButton_2);
					
		
		JButton btnNewButton_3 = new JButton("Grade");
		btnNewButton_3.setBounds(126, 158, 139, 49);
		panel_3_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("1 : 1 Contact");
		btnNewButton_4.setBounds(126, 253, 139, 49);
		panel_3_1.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("Q  &  A");
		btnNewButton_1.setBounds(126, 344, 139, 49);
		panel_3_1.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
				panel_3_1.setVisible(true);
				Q_Panel.setVisible(true);
				C_Panel.setVisible(false);
				M_Panel.setVisible(false);
				G_Panel.setVisible(false);
			}
			
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
				panel_3_1.setVisible(true);
				Q_Panel.setVisible(false);
				C_Panel.setVisible(false);
				M_Panel.setVisible(true);
				G_Panel.setVisible(false);
			}
			
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
				panel_3_1.setVisible(true);
				Q_Panel.setVisible(false);
				C_Panel.setVisible(false);
				M_Panel.setVisible(false);
				G_Panel.setVisible(true);
			}
			
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
				panel_3_1.setVisible(true);
				Q_Panel.setVisible(false);
				C_Panel.setVisible(true);
				M_Panel.setVisible(false);
				G_Panel.setVisible(false);
			}
			
		});
		
		JButton confirm = new JButton("Confirmed");
		confirm.setBounds(273, 0, 273, 200);
		Menu_Panel.add(confirm);
		confirm.setBackground(new Color(255, 204, 0));
		confirm.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirm.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
			    panel_3_1.setVisible(false)
;				panel_4.setVisible(true);
				
			}
		});
		
		icon2 = new ImageIcon("./Image/등급.png");
		
		icon1 = new ImageIcon("./Image/마일리지.png");
		
		
		
		JButton my_page = new JButton("My Page");
		my_page.setBounds(546, 0, 273, 200);
		Menu_Panel.add(my_page);
		my_page.setBackground(new Color(255, 204, 0));
		my_page.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		my_page.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		my_page.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPanel.setVisible(false);
				panel_4.setVisible(false);
				panel_3_1.setVisible(true);
				
			}
		});
		
		
		JButton admin = new JButton("Adminsterator");
		admin.setBounds(819, 0, 273, 200);
		Menu_Panel.add(admin);
		admin.setBackground(Color.DARK_GRAY);
		admin.setForeground(new Color(255, 204, 0));
		admin.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				//클릭하면 원하는 정보가 나올 수 있도록 panel을 생성함 
				//버튼을 누르면 다른 패널들이 생성한다는 것을 나타내기 위해서 색깔 임의대로 지정
			}
		});
		
		icon = new ImageIcon("./Image/KakaoTalk_20180518_233005930.png");
		
		JPanel login_Panel = new JPanel();
		login_Panel.setBounds(0, 0, 1076, 703);
		contentPane.add(login_Panel);
		login_Panel.setBackground(new Color(255, 204, 0));
		login_Panel.setLayout(null);
		JPanel panel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
			g.drawImage(icon.getImage(),0,0,null);
			
			setOpaque(false);
			super.paintComponent(g);
			}
		};
		panel_2.setBounds(0, 0, 1076, 467);
		login_Panel.add(panel_2);
		
		textField = new JTextField();
		textField.setBounds(242, 511, 311, 59);
		login_Panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 604, 311, 59);
		login_Panel.add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(636, 511, 197, 59);
		login_Panel.add(btnLogIn);
		btnLogIn.setBackground(new Color(255, 204, 102));
		btnLogIn.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(209, 402, 116, 49);
		login_Panel.add(lblId);
		lblId.setForeground(new Color(255, 204, 102));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setBounds(209, 521, 116, 49);
		login_Panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 204, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(636, 604, 197, 59);
		login_Panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_Panel.setVisible(false);
				Menu_Panel.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		JPanel panel_5 = new JPanel() {
			public void paintComponent(Graphics g) {
		  		g.drawImage(icon3.getImage(),0,0,null);
			
		  		setOpaque(false);
		  		super.paintComponent(g);
			}
		
		};
		panel_5.setBounds(0, 0, 711, 393);
		contentPane.add(panel_5);
		panel_5.setVisible(false);
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
		
		
		
	}
}
