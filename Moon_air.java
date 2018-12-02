import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.event.KeyEvent;


public class Moon_air extends JFrame {

	private String User="";
	
	private JPanel contentPane;
	private JPanel newPanel[] = new JPanel[6]; //예약, 예약확인, 마이페이지, 관리자의 정보를 나타내는 패널들
	private JPanel rsvPanel = new JPanel(); // 예약패널에 마우스를 올리면 버튼 3개가 나타날 수 있도록....하기 위해서
	private final JPanel panel = new JPanel();
	private JPanel panel_3= new JPanel();
	private JTextField idField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private JTextField minPrice;
	private JTextField maxPrice;
	private JTextField textField_3;

	ImageIcon icon,icon1,icon2,icon3;
	
	String driver        = "org.mariadb.jdbc.Driver";
    String url           = "jdbc:mariadb://localhost:3307/moon_air";
    String uId           = "root";
    String uPwd          = "Eshowras1";

    Connection               con;
    PreparedStatement        pstmt;
    Statement        stmt;
    ResultSet                rs;
    private JTable table;
    JTable rsvtable;
    private JTable table_1;
    private JTable table_2;
    private JTable table_3;
    private JTable table_4;
    private JTable table_5;
    private JTable table_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moon_air ma = new Moon_air();
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
		

		accDB();
		logIn();
		
	}
	

    private void accDB() {
    	try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, uId, uPwd);

            if( con != null ){ System.out.println("데이터 베이스 접속 성공"); }

        } catch (ClassNotFoundException e) { System.out.println("드라이버 로드 실패");    }
        catch (SQLException e) { System.out.println("데이터 베이스 접속 실패"); }

    }
    
	public void logIn() {
		JFrame frame = this;
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel Menu_Panel = new JPanel();
		JPanel MyPage_Panel = new JPanel();
		JPanel confirm_rsv_Panel = new JPanel();
		JPanel Confirm_Panel = new JPanel();
		
		
		Menu_Panel.setBackground(Color.DARK_GRAY);
		Menu_Panel.setBounds(0, 0, 1076, 703);
		contentPane.add(Menu_Panel);
		Menu_Panel.setLayout(null);
		Menu_Panel.setVisible(false);
		

		JPanel psptPanel = new JPanel() {
			public void paintComponent(Graphics g) {
		  		g.drawImage(icon3.getImage(),0,0,null);
			
		  		setOpaque(false);
		  		super.paintComponent(g);
			}
		};
		psptPanel.setBounds(105, 250, 900, 400);
		Menu_Panel.add(psptPanel);
		psptPanel.setBackground(Color.DARK_GRAY);
		psptPanel.setVisible(false);
		psptPanel.setLayout(null);
		
		JLabel pspt_arrv = new JLabel("");
		pspt_arrv.setBackground(Color.ORANGE);
		pspt_arrv.setBounds(499, 110, 300, 50);
		pspt_arrv.setForeground(Color.BLACK);
		pspt_arrv.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 46));
		psptPanel.add(pspt_arrv);
		
		JLabel pspt_strt = new JLabel("");
		pspt_strt.setBackground(Color.ORANGE);
		pspt_strt.setBounds(108, 110, 300, 50);
		pspt_strt.setForeground(Color.BLACK);
		pspt_strt.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 46));
		psptPanel.add(pspt_strt);
		
		JLabel pspt_date = new JLabel("");
		pspt_date.setBackground(Color.ORANGE);
		pspt_date.setBounds(87, 245, 210, 50);
		pspt_date.setForeground(Color.BLACK);
		pspt_date.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 19));
		psptPanel.add(pspt_date);
		
		JLabel pspt_psptNum = new JLabel("");
		pspt_psptNum.setBackground(Color.ORANGE);
		pspt_psptNum.setBounds(521, 213, 210, 50);
		pspt_psptNum.setForeground(Color.BLACK);
		pspt_psptNum.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 16));
		psptPanel.add(pspt_psptNum);
		
		JLabel pspt_resvNum = new JLabel("");
		pspt_resvNum.setBackground(Color.ORANGE);
		pspt_resvNum.setBounds(449, 245, 270, 50);
		pspt_resvNum.setForeground(Color.BLACK);
		pspt_resvNum.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 16));
		psptPanel.add(pspt_resvNum);
		
		JLabel pspt_flight = new JLabel("");
		pspt_flight.setBackground(Color.BLACK);
		pspt_flight.setBounds(116, 322, 210, 50);
		pspt_flight.setForeground(Color.WHITE);
		pspt_flight.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		psptPanel.add(pspt_flight);
	
		Confirm_Panel.setBounds(0, 200, 1076, 503);
		Menu_Panel.add(Confirm_Panel);
		Confirm_Panel.setLayout(null);
		Confirm_Panel.setBackground(Color.DARK_GRAY);
		
		JButton passportBtn = new JButton("\uD45C \uD655\uC778");
		passportBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = rsvtable.getSelectedRow();
				String arrv=(String)rsvtable.getValueAt(select, 0);
				String strt=(String)rsvtable.getValueAt(select, 1);
				String flight=(String)rsvtable.getValueAt(select, 2);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String mydate = format.format(rsvtable.getValueAt(select, 3)).toString();
				String rsv_num = (String)rsvtable.getValueAt(select, 4);
				String pass_num = (String)rsvtable.getValueAt(select, 5);
				
				pspt_arrv.setText(arrv);
				pspt_strt.setText(strt);
				pspt_flight.setText(flight);
				pspt_date.setText(mydate);
				pspt_resvNum.setText(rsv_num);
				pspt_psptNum.setText(pass_num);
				
				psptPanel.setVisible(true);
				Confirm_Panel.setVisible(false);
				
			}
			
		});
		passportBtn.setBackground(new Color(255, 204, 0));
		passportBtn.setFont(new Font("굴림", Font.BOLD, 22));
		passportBtn.setBounds(707, 409, 222, 31);
		Confirm_Panel.add(passportBtn);
		
	
		confirm_rsv_Panel.setBackground(Color.GRAY);
		confirm_rsv_Panel.setBounds(165, 68, 779, 320);
		Confirm_Panel.add(confirm_rsv_Panel);
		confirm_rsv_Panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		confirm_rsv_Panel.add(scrollPane_1, BorderLayout.CENTER);
		
		rsvtable = new JTable();
		rsvtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(rsvtable);
		
		Confirm_Panel.setVisible(false);
		
		JPanel SearchPanel = new JPanel();
		
		
		
		SearchPanel.setBounds(0, 200, 1076, 503);
		Menu_Panel.add(SearchPanel);
		SearchPanel.setLayout(null);
		SearchPanel.setBackground(Color.GRAY);
		SearchPanel.setVisible(false);
		
		JButton reservationBtn = new JButton("\uC608\uC57D");
		reservationBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//table 에서 선택된 행 데이터 받아오기
				int select = table.getSelectedRow();
				
				String arrv_city=(String)table.getValueAt(select, 0);
				Date mydate = (Date)table.getValueAt(select, 1);
				String strt_city=(String)table.getValueAt(select, 2);
				String flight_id=(String)table.getValueAt(select, 3);
				String plane_id=(String)table.getValueAt(select, 4);
				
				//예약된 좌석 수 구해오기. 예약 테이블에서 flight_id 로 예약된 수
				String sql = "select count(*) from reservation where flight_id = ?";			
				
				int rsv_seat=0;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, flight_id);
					
					rs= pstmt.executeQuery();
					
					while(rs.next())
					{
						rsv_seat=rs.getInt(1);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//그 flight의 비행기 모델의 좌석수
				sql ="select total_seats from plane natural join plane_model where plane_id = ?";
				
				int total_seat=0;
				
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,plane_id);
					
					rs=pstmt.executeQuery();
					while(rs.next()) 
					{
						total_seat=rs.getInt(1);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//예약좌석이 총좌석보다 크거나 같으면 예약 안되고 끝남
				if(rsv_seat>=total_seat)
				{
					JOptionPane.showMessageDialog(null, "잔여 좌석이 없습니다.", "예약 실패", JOptionPane.ERROR_MESSAGE);
					return;
				}
								
				
				SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
				String rsv_num=User.concat(format.format(mydate).toString().concat(flight_id));
				
				//아니면 예약에 insert
				sql="insert into reservation values(?,?,?,?,?,?)";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, arrv_city);
					pstmt.setString(2, strt_city);
					pstmt.setString(3,flight_id);
					pstmt.setDate(4,mydate);
					pstmt.setString(5, rsv_num);
					pstmt.setString(6,User);
					
					int i=pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"예약번호"+rsv_num+ "\n예약 완료", "예약 성공", JOptionPane.INFORMATION_MESSAGE);
					
				
					
					
					
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		
		});
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
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector rows = new Vector();
				Vector data = new Vector();
				
				
			try {
				//출발 도시가 인천인 경우 => 도착도시의 가격에 따라
				String sql = "select arrival_city,date,departure_city,flight_id,plane_id from flight join city on flight.arrival_city = city.city_name where city.cost >=? and city.cost<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, minPrice.getText());
				pstmt.setString(2, maxPrice.getText());
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();
				int num=rsmd.getColumnCount();
				for(int i=1;i<=num;i++)
				{
				rows.addElement(rsmd.getColumnName(i));
				}
				while(rs.next())
				{
				Vector vector_col=new Vector();
				vector_col.add(rs.getString(1));
				vector_col.add(rs.getDate(2));
				vector_col.add(rs.getString(3));
				vector_col.add(rs.getString(4));
				vector_col.add(rs.getString(5));
				data.addElement(vector_col);//벡터의 요소로 추가.
				}
				sql = "select arrival_city,date,departure_city,flight_id,plane_id from flight join city on flight.departure_city = city.city_name where city.cost >=? and city.cost<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, minPrice.getText());
				pstmt.setString(2, maxPrice.getText());
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				Vector vector_col=new Vector();
				vector_col.add(rs.getString(1));
				vector_col.add(rs.getDate(2));
				vector_col.add(rs.getString(3));
				vector_col.add(rs.getString(4));
				vector_col.add(rs.getString(5));
				data.addElement(vector_col);//벡터의 요소로 추가.
				}				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 모델 설정 
			DefaultTableModel model = new DefaultTableModel(data, rows); 
			table.setModel(model);
			
			table.repaint();
			}
		});
		button_1.setForeground(new Color(255, 204, 0));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(501, 30, 97, 23);
		price_searchPanel.add(button_1);
		
		minPrice = new JTextField();
		minPrice.setBounds(140, 31, 116, 21);
		price_searchPanel.add(minPrice);
		minPrice.setColumns(10);
		
		maxPrice = new JTextField();
		maxPrice.setColumns(10);
		maxPrice.setBounds(342, 31, 116, 21);
		price_searchPanel.add(maxPrice);
		
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
		
		JDateChooser strt_date = new JDateChooser();
		strt_date.setBounds(113, 30, 124, 21);
		date_searchPanel.add(strt_date);
		
		JDateChooser arrv_date = new JDateChooser();
		arrv_date.setBounds(348, 30, 124, 21);
		date_searchPanel.add(arrv_date);
		
		JButton button = new JButton("\uAC80\uC0C9");
		button.setForeground(new Color(255, 204, 0));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(501, 30, 97, 23);
		date_searchPanel.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Vector rows = new Vector();
				Vector data = new Vector();
				
				//두 날짜 사이에 출발하는 날짜 db 접근해서 받아와 table에 뿌리기
			String sql = "select * from flight where date >= ? and date<=?";
			SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
			String strt=format.format(strt_date.getDate());
			String arrv=format.format(arrv_date.getDate());
			try {
				pstmt                = con.prepareStatement(sql);
				pstmt.setString(1,strt);
				pstmt.setString(2, arrv);
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();
				int num=rsmd.getColumnCount();
				for(int i=1;i<=num;i++)
				{
				rows.addElement(rsmd.getColumnName(i));
				}
				while(rs.next())
				{
				Vector vector_col=new Vector();
				vector_col.add(rs.getString(1));
				vector_col.add(rs.getDate(2));
				vector_col.add(rs.getString(3));
				vector_col.add(rs.getString(4));
				vector_col.add(rs.getString(5));
				data.addElement(vector_col);//벡터의 요소로 추가.
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 모델 설정 
			DefaultTableModel model = new DefaultTableModel(data, rows); 
			table.setModel(model);
			
			table.repaint();
			}
		});
		
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
		
		
		
		JLabel arrvLbl = new JLabel("\uB3C4\uCC29\uC9C0");
		arrvLbl.setBounds(262, 24, 57, 30);
		city_searchPanel.add(arrvLbl);
		arrvLbl.setHorizontalAlignment(SwingConstants.CENTER);
		arrvLbl.setForeground(Color.DARK_GRAY);
		arrvLbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		JComboBox arrvBox = new JComboBox();
		arrvBox.setBounds(345, 24, 123, 30);
		city_searchPanel.add(arrvBox);
		arrvBox.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JButton srchBtn = new JButton("\uAC80\uC0C9");
		srchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vector rows = new Vector();
				Vector data = new Vector();
				
				//출발도시와 도착도시로 db 접근해서 받아와 table에 뿌리기
				String sql = "select * from flight where departure_city = ? and arrival_city=?";
				String strt=strtBox.getSelectedItem().toString();
				String arrv=arrvBox.getSelectedItem().toString();
				try {
					pstmt                = con.prepareStatement(sql);
					pstmt.setString(1,strt);
					pstmt.setString(2, arrv);
					rs = pstmt.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					int num=rsmd.getColumnCount();
					for(int i=1;i<=num;i++)
					{
					rows.addElement(rsmd.getColumnName(i));
					}
					while(rs.next())
					{
					Vector vector_col=new Vector();
					vector_col.add(rs.getString(1));
					vector_col.add(rs.getDate(2));
					vector_col.add(rs.getString(3));
					vector_col.add(rs.getString(4));
					vector_col.add(rs.getString(5));
					data.addElement(vector_col);//벡터의 요소로 추가.
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 모델 설정 
				DefaultTableModel model = new DefaultTableModel(data, rows); 
				table.setModel(model);
				
				table.repaint();
			}
		});
		srchBtn.setBounds(501, 30, 97, 23);
		city_searchPanel.add(srchBtn);
		srchBtn.setBackground(Color.DARK_GRAY);
		srchBtn.setForeground(new Color(255, 204, 0));
		srchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 114, 1003, 304);
		SearchPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		MyPage_Panel.setBounds(0, 200, 1076, 503);
		Menu_Panel.add(MyPage_Panel);
		MyPage_Panel.setLayout(null);
		MyPage_Panel.setBackground(Color.DARK_GRAY);
		MyPage_Panel.setVisible(false);
		
		JPanel C_Panel = new JPanel();
		C_Panel.setBounds(414, 136, 561, 220);
		MyPage_Panel.add(C_Panel);
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
		MyPage_Panel.add(G_Panel);
		G_Panel.setLayout(null);
		G_Panel.setVisible(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(70, 80, 150, 40);
		G_Panel.add(scrollPane_3);
		
		table_6 = new JTable();
		table_6.setBounds(0, 0, 1, 1);
		scrollPane_3.setViewportView(table_6);
		
		
		
		JPanel Q_Panel = new JPanel();
		Q_Panel.setBounds(414, 136, 561, 220);
		MyPage_Panel.add(Q_Panel);
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
		
		MyPage_Panel.add(M_Panel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(40, 80, 200, 40);
		M_Panel.add(scrollPane_2);
		
		table_5 = new JTable();
		table_5.setBounds(111, 80, 111, 40);
		scrollPane_2.setViewportView(table_5);
		
		JButton btnNewButton_2 = new JButton("Mileage");
		btnNewButton_2.setBounds(126, 59, 139, 49);
		MyPage_Panel.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Vector out = new Vector();
				Vector in = new Vector();
				
				String sql = "select passport_number, mileage from passenger where passport_number =?";
		
				
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,User);
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				int num = rsmd.getColumnCount();
				
				for(int i=1;i<=num;i++)
				{
					out.addElement(rsmd.getColumnName(i));
				}
				while(rs.next())
				{
					Vector vector_col=new Vector();
					vector_col.add(rs.getString(1));
					vector_col.add(rs.getString(2));	
					in.addElement(vector_col);
			
			}
			
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
			
			DefaultTableModel model = new DefaultTableModel(in,out); 
			table_5.setModel(model);
			
			table_5.repaint();
		}
	});
		
		JButton btnNewButton_3 = new JButton("Grade");
		btnNewButton_3.setBounds(126, 158, 139, 49);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Vector out = new Vector();
				Vector in = new Vector();
				
				String sql = "select passport_number, grade from passenger where passport_number =?";
		
				
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,User);
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				int num = rsmd.getColumnCount();
				
				for(int i=1;i<=num;i++)
				{
					out.addElement(rsmd.getColumnName(i));
				}
				while(rs.next())
				{
					Vector vector_col=new Vector();
					vector_col.add(rs.getString(1));
					vector_col.add(rs.getString(2));	
					in.addElement(vector_col);
			
			}
			
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
			
			DefaultTableModel model = new DefaultTableModel(in,out); 
			table_6.setModel(model);
			
			table_6.repaint();
		}
	});
		MyPage_Panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("1 : 1 Contact");
		btnNewButton_4.setBounds(126, 253, 139, 49);
		MyPage_Panel.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("Q  &  A");
		btnNewButton_1.setBounds(126, 344, 139, 49);
		MyPage_Panel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				Q_Panel.setVisible(false);
				C_Panel.setVisible(true);
				M_Panel.setVisible(false);
				G_Panel.setVisible(false);
			
			}
			
		});
		
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
				Confirm_Panel.setVisible(false);
				MyPage_Panel.setVisible(false);
				psptPanel.setVisible(false);
				((DefaultTableModel)table.getModel()).setRowCount(0);
				table.repaint();
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
				Confirm_Panel.setVisible(false);
				MyPage_Panel.setVisible(false);
				psptPanel.setVisible(false);
				((DefaultTableModel)table.getModel()).setRowCount(0);
				table.repaint();
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
				Confirm_Panel.setVisible(false);
				MyPage_Panel.setVisible(false);
				psptPanel.setVisible(false);
				city_searchPanel.setVisible(true);
				((DefaultTableModel)table.getModel()).setRowCount(0);
				table.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//여기서 빠져나가면 Reservation 버튼 보이도록
				rsvPanel.setVisible(false);
				rsvBtn.setVisible(true);
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
			    MyPage_Panel.setVisible(false);
			    psptPanel.setVisible(false);
			    Confirm_Panel.setVisible(true);
				
				Vector rows = new Vector();
				Vector data = new Vector();
				
				//지금 갖고있는 User의 passport로 예약을 검색함
				String sql = "select * from reservation where passport_number = ?";
				try {
					pstmt                = con.prepareStatement(sql);
					pstmt.setString(1,User);
					rs = pstmt.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					int num=rsmd.getColumnCount();
					for(int i=1;i<=num;i++)
					{
						rows.addElement(rsmd.getColumnName(i));
					}
					while(rs.next())
					{
						Vector vector_col=new Vector();
						vector_col.add(rs.getString(1));
						vector_col.add(rs.getString(2));
						vector_col.add(rs.getString(3));
						vector_col.add(rs.getDate(4));
						vector_col.add(rs.getString(5));
						vector_col.add(rs.getString(6));
						data.addElement(vector_col);//벡터의 요소로 추가.
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				// 모델 설정 
				DefaultTableModel model = new DefaultTableModel(data, rows); 
				rsvtable.setModel(model);
				rsvtable.getColumnModel().getColumn(4).setPreferredWidth(140);
				
				rsvtable.repaint();
			}
		});
		
		
		
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
				Confirm_Panel.setVisible(false);
				psptPanel.setVisible(false);
				MyPage_Panel.setVisible(true);
				
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
				//User가 관리자가 아니면 에러메시지
				if(!User.equals("admin"))
				{
					JOptionPane.showMessageDialog(null, "관리자 외 접근 불가", "Access Denied", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
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
		
		idField = new JTextField();
		idField.setFont(new Font("굴림", Font.BOLD, 21));
		idField.setBounds(242, 511, 311, 59);
		login_Panel.add(idField);
		idField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.BOLD, 21));
		passwordField.setBounds(242, 604, 311, 59);
		login_Panel.add(passwordField);
		
		JButton btnSignin = new JButton("Sign in");
		btnSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sql = "select passport_number, birth from passenger where passport_number = ?";
				String user_id="";
				String pw="";
				SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,idField.getText());
					
					rs = pstmt.executeQuery();
					
					while(rs.next())
					{
						user_id=rs.getString(1);
						pw=format.format(rs.getDate(2)).toString();						
					}
					if((!idField.getText().equals("admin"))&&(!pw.equals(String.valueOf(passwordField.getPassword()))))
					{
						JOptionPane.showMessageDialog(null,"로그인 실패하였습니다.", "Sign in Failed", JOptionPane.ERROR_MESSAGE);
						return;
					}
					User= idField.getText();
					frame.setTitle(User);
					login_Panel.setVisible(false);
					Menu_Panel.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		});
		btnSignin.setBounds(636, 511, 197, 59);
		login_Panel.add(btnSignin);
		btnSignin.setBackground(new Color(255, 204, 102));
		btnSignin.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		JLabel lblId = new JLabel("ID(\uC5EC\uAD8C\uBC88\uD638)");
		lblId.setBounds(49, 521, 156, 49);
		login_Panel.add(lblId);
		lblId.setForeground(Color.DARK_GRAY);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		
		JLabel lblNewLabel = new JLabel("PW(yyMMdd\uD615\uC2DD)");
		lblNewLabel.setBounds(12, 614, 221, 49);
		login_Panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(636, 604, 197, 59);
		login_Panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(idField.getText().equals("")||String.valueOf(passwordField.getPassword()).equals(""))
				{
					JOptionPane.showMessageDialog(null, "ID와 PW를 입력해주십시오.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(idField.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(null, "사용할 수 없는 ID입니다", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					pstmt = con.prepareStatement("select count(*) from passenger where passport_number=?");
					pstmt.setString(1, idField.getText());
					
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						if(rs.getInt(1)>0)
						{
							JOptionPane.showMessageDialog(null, "이미 존재하는 회원입니다", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					pstmt = con.prepareStatement("insert into passenger values('Freshman',0,?,?)");
					pstmt.setString(1, idField.getText());
					pstmt.setString(2, String.valueOf(passwordField.getPassword()));
					int i = pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "회원가입 완료", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Insert Query Fail");
				}
				
				
			}
		});
		btnRegister.setBackground(new Color(255, 204, 102));
		btnRegister.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		try{
			   pstmt                = con.prepareStatement("select city_name from city");
	           rs                   = pstmt.executeQuery();
			   while(rs.next())
			   {
			    strtBox.addItem(rs.getString(1));
			    arrvBox.addItem(rs.getString(1));
			   }
		  }
		  catch(SQLException e)
		  {
		   e.getMessage();
		  }
		
		icon3 = new ImageIcon("./Image/탑승권.png");
		
		icon2 = new ImageIcon("./Image/등급.png");
		
		icon1 = new ImageIcon("./Image/마일리지.png");
		
		icon = new ImageIcon("./Image/KakaoTalk_20180518_233005930.png");
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}