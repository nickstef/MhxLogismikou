import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class feedback1 extends JFrame {

	private JPanel contentPane;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback1 frame = new feedback1();
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
	Connection connection=null;
	private JScrollPane scrollPane;
	public feedback1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03BF\u03B3\u03B5\u03AF\u03C3\u03C4\u03B5 \u03B1\u03C0\u03CC 1 \u03B5\u03C9\u03C2 10.");
		lblNewLabel.setBounds(10, 9, 189, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 445, 351);
		contentPane.add(scrollPane);
		
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		
		JButton btnNewButton = new JButton("\u0391\u03BE\u03B9\u03BF\u03BB\u03BF\u03B3\u03AE\u03C3\u03B5\u03B9\u03C2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from axiologhsh ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(197, 4, 145, 23);
		contentPane.add(btnNewButton);
	}
}
