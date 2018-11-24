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
					Moon_air frame = new Moon_air();
					frame.setVisible(true);
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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1093, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 204, 0));
		panel.setBounds(0, 0, 1071, 390);
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
		btnLogIn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		btnLogIn.setBounds(636, 446, 197, 59);
		contentPane.add(btnLogIn);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 204, 102));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 26));
		lblId.setBounds(209, 402, 116, 49);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setForeground(new Color(255, 204, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 26));
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
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
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
}
