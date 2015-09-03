import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JSeparator;


public class GUI extends JFrame {

	public JPanel contentPane;
	public JTextField PTNO;
	public JTextField ID_Operator;
	public JTextField Date;
	public JTextField Qty;
	private static String VerNum = "V1.0";
	private static String NONE = " NONE / NINGUNO ";
	
	String sPTNO,sQty, sDefect;
	int iShift,iID_Operator;
	
	Integer[] shiftArray = new Integer[] {0,1,2,3};
	String[] defectArray = new String[] {NONE,"DEFECT1", "DEFECT2","DEFECT3", "DEFECT4", "DEFECT5", "DEFECT6"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();					
					frame.setVisible(true);
					frame.setTitle("(Database Input Example Program "+VerNum+") [SQL Server Database]");
					frame.setResizable(false);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GUI() throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");		
		Calendar cal = Calendar.getInstance();
		String DATE = dateFormat.format(cal.getTime());
		
		
		
		Image img1 = new ImageIcon (this.getClass().getResource("ex.png")).getImage();
		setIconImage(img1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Database Input Example Program"+VerNum);
		lblTitle1.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle1.setBounds(154, 43, 417, 23);
		contentPane.add(lblTitle1);
		
		JLabel lblPartNumber = new JLabel("Part Number/N\u00FAmero de Pieza:");
		lblPartNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPartNumber.setBounds(25, 137, 158, 14);
		contentPane.add(lblPartNumber);
		
		JLabel lblIdOperator = new JLabel("ID Operator/ID Operador:");
		lblIdOperator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdOperator.setBounds(25, 183, 145, 14);
		contentPane.add(lblIdOperator);
		
		JLabel lblDate = new JLabel("Date/Fecha: (MM/DD/YYYY)");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDate.setBounds(365, 235, 154, 14);		
		//contentPane.add(lblDate);
		
		JLabel lblQty = new JLabel("Qty/Cantidad:");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQty.setBounds(365, 137, 84, 14);
		contentPane.add(lblQty);
		
		JLabel lblDefect = new JLabel("Defect/Defecto:");
		lblDefect.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDefect.setBounds(365, 183, 84, 14);
		contentPane.add(lblDefect);
		
		PTNO = new JTextField();
		PTNO.setBounds(180, 137, 145, 20);
		contentPane.add(PTNO);
		PTNO.setColumns(10);
		
		ID_Operator = new JTextField();
		ID_Operator.setBounds(180, 183, 145, 20);
		contentPane.add(ID_Operator);
		ID_Operator.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(518, 232, 84, 20);
		Date.setText(DATE);
		Date.setEditable(false);
		//contentPane.add(Date);
		Date.setColumns(10);
		
		Qty = new JTextField();
		Qty.setBounds(459, 137, 145, 20);
		contentPane.add(Qty);
		Qty.setColumns(10);
		
	
		
		
		JLabel lblTitle2 = new JLabel("Scrap Material");
		lblTitle2.setFont(new Font("Arial", Font.BOLD, 13));
		lblTitle2.setBounds(269, 84, 158, 20);
		contentPane.add(lblTitle2);
		
		JLabel lblGeIcon = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("ex.png")).getImage();
		lblGeIcon.setIcon(new ImageIcon(img));
		lblGeIcon.setBounds(10, 33, 71, 71);
		contentPane.add(lblGeIcon);
		
		JLabel lblShift = new JLabel("Shift/Turno: ");
		lblShift.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblShift.setBounds(25, 232, 84, 14);
		contentPane.add(lblShift);
		
		JLabel lblVegaAltaPlant = new JLabel("Powered by bravopr");
		lblVegaAltaPlant.setFont(new Font("Arial", Font.BOLD, 10));
		lblVegaAltaPlant.setBounds(15, 298, 167, 14);
		contentPane.add(lblVegaAltaPlant);
		/*
		JComboBox comboBoxShift = new JComboBox();
		comboBoxShift.setBounds(180, 228, 145, 22);
		contentPane.add(comboBoxShift);
		
		JComboBox comboBoxDefect = new JComboBox();
		comboBoxDefect.setBounds(459, 179, 145, 22);
		contentPane.add(comboBoxDefect); */
		
		JComboBox<Integer> comboBoxShift = new JComboBox<Integer>(shiftArray);
		comboBoxShift.setBounds(180, 228, 145, 22);
		contentPane.add(comboBoxShift);
		
		JComboBox<String> comboBoxDefect = new JComboBox<String>(defectArray);
		comboBoxDefect.setBounds(459, 179, 145, 22);
		contentPane.add(comboBoxDefect);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 650, 21);
		contentPane.add(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnOptions.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(null,"Develop by Gustavo Bravo, IT COOP."+"\n"+VerNum+", Last Compiled: "+DATE);
            }
        });
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnOptions.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	System.exit(0);
            }
        }); 
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 295, 617, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 116, 617, 0);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 114, 612, 2);
		contentPane.add(separator_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(518, 261, 86, 23);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	sPTNO = PTNO.getText().toUpperCase();
            	
            	if (!(ID_Operator.getText()).matches("[0-9]+")){
              	  JOptionPane.showMessageDialog(null,"ERROR: Verify your values. / Verifica tus valores.");
            	}
            	
            	iID_Operator = Integer.parseInt(ID_Operator.getText());
            	sQty = Qty.getText();
            	iShift = (int) comboBoxShift.getSelectedItem();
            	sDefect = (String) comboBoxDefect.getSelectedItem();
            	            	
					DatabaseConn.dbInput(sPTNO,iID_Operator,iShift,sQty,sDefect);
				            	
            		PTNO.setText(null);
            		Qty.setText(null);
            		ID_Operator.setText(null);
            	
            	
            	//System.out.println(sPTNO+" "+sID_Operator+" "+sQty +" "+sShift+" "+sDefect);
            	//JOptionPane.showMessageDialog(null,"Do you want to submit another defect with the same Part Number?");
            }
        }); 
	}
	
	public static String getNone(){
		return NONE;
	}
}
