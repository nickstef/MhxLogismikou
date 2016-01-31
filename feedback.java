import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class feedback extends JFrame {

	private JPanel contentPane;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textFieldSearch1;
	public feedback() {
		connection=DBConnect.DBConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u0395\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03C9\u03BD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from manage";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 11, 216, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 485, 280);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				feedback1 fb1= new feedback1();
				fb1.setVisible(true);
			}
		});
		scrollPane.setViewportView(table1);
		
		JLabel label = new JLabel("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE \u03A4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2:");
		label.setBounds(236, 15, 162, 14);
		contentPane.add(label);
		
		textFieldSearch1 = new JTextField();
		textFieldSearch1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					
					String query="select * from manage where Τμήμα=?";
					System.out.println(query);
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textFieldSearch1.getText() );
					ResultSet rs=pst.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		textFieldSearch1.setBounds(376, 12, 86, 20);
		contentPane.add(textFieldSearch1);
		textFieldSearch1.setColumns(10);
	}
}
