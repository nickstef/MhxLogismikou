import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField IDText;
	private JTextField OnomaText;
	private JTextField EponimoText;
	private JTextField HlikiaText;
	private JTextField TelText;
	private JTextField AddressText;
	private JTextField textFieldSearch;
	private JComboBox comboBox;
	private JTextField TmimaText;
	
	public void refreshTable(){
		try {
			String query="select * from manage";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Manage() {
		connection=DBConnect.DBConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 82, 480, 390);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnload = new JButton("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u0395\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03C9\u03BD");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from manage";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnload.setBounds(10, 357, 188, 23);
		contentPane.add(btnload);
		
		JLabel lbl1 = new JLabel("ID");
		lbl1.setBounds(10, 83, 46, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lbl2.setBounds(10, 108, 46, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		lbl3.setBounds(10, 133, 65, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("\u0397\u03BB\u03B9\u03BA\u03AF\u03B1");
		lbl4.setBounds(10, 158, 65, 14);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		lbl5.setBounds(10, 183, 65, 14);
		contentPane.add(lbl5);
		
		JLabel lbl6 = new JLabel("\u0394\u03B9\u03AD\u03C5\u03B8\u03C5\u03BD\u03C3\u03B7");
		lbl6.setBounds(10, 208, 66, 14);
		contentPane.add(lbl6);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setToolTipText("");
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select * from manage where "+selection+"=?";
					System.out.println(query);
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textFieldSearch.getText() );
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		textFieldSearch.setBounds(384, 39, 227, 32);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		IDText = new JTextField();
		IDText.setBounds(85, 80, 46, 20);
		contentPane.add(IDText);
		IDText.setColumns(10);
		
		OnomaText = new JTextField();
		OnomaText.setBounds(85, 105, 113, 20);
		contentPane.add(OnomaText);
		OnomaText.setColumns(10);
		
		EponimoText = new JTextField();
		EponimoText.setBounds(85, 130, 113, 20);
		contentPane.add(EponimoText);
		EponimoText.setColumns(10);
		
		HlikiaText = new JTextField();
		HlikiaText.setBounds(85, 155, 46, 20);
		contentPane.add(HlikiaText);
		HlikiaText.setColumns(10);
		
		TelText = new JTextField();
		TelText.setBounds(85, 180, 86, 20);
		contentPane.add(TelText);
		TelText.setColumns(10);
		
		AddressText = new JTextField();
		AddressText.setBounds(85, 205, 113, 20);
		contentPane.add(AddressText);
		AddressText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into manage (ID,Όνομα,Επώνυμο,Ηλικία,Τηλέφωνο,Διέυθυνση,Τμήμα) values(?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, IDText.getText());
					pst.setString(2, OnomaText.getText());
					pst.setString(3, EponimoText.getText());
					pst.setString(4, HlikiaText.getText());
					pst.setString(5, TelText.getText());
					pst.setString(6, AddressText.getText());
					pst.setString(7, TmimaText.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Saved");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(10, 289, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("\u0391\u03BD\u03B1\u03BD\u03AD\u03C9\u03C3\u03B7");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update manage set ID='"+IDText.getText()+"' , ID='"+IDText.getText()+"' ,Όνομα='"+OnomaText.getText()+"' ,Επώνυμο='"+EponimoText.getText()+"' ,Ηλικία='"+HlikiaText.getText()+"' ,Τηλέφωνο='"+TelText.getText()+"' ,Διέυθυνση='"+AddressText.getText()+"', Τμήμα='"+TmimaText.getText()+"' where ID='"+IDText.getText()+"' "; 
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				refreshTable();
			}
		});
		btnUpdate.setBounds(109, 323, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="delete from manage where ID='"+IDText.getText()+"'"; 
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				refreshTable();
				
			}
		});
		btnDelete.setBounds(10, 323, 89, 23);
		contentPane.add(btnDelete);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "\u038C\u03BD\u03BF\u03BC\u03B1\t", "\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF", "\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF", "\u03A4\u03BC\u03AE\u03BC\u03B1"}));
		comboBox.setBounds(233, 39, 141, 32);
		contentPane.add(comboBox);
		
		TmimaText = new JTextField();
		TmimaText.setBounds(85, 236, 113, 20);
		contentPane.add(TmimaText);
		TmimaText.setColumns(10);
		
		JLabel lblSection = new JLabel("\u03A4\u03BC\u03B7\u03BC\u03B1");
		lblSection.setBounds(10, 239, 46, 14);
		contentPane.add(lblSection);
		
		
		
	}
}
