
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Container container = getContentPane();
	String pname = "";
	int page = 0;
	String speciality = "";
	float amt = 0;
	int flag = 0;

	String filename = "";
	String record="";

	private final JLabel transactionDetailsLabel = new JLabel("Transaction Details");

	JLabel baseCostLabel = new JLabel("Base Amount :");
	JTextField baseCostTextField = new JTextField();

	JLabel taxLabel = new JLabel("Service Tax :");
	JLabel taxValueLabel = new JLabel("5%");

	JLabel gstTaxLabel = new JLabel("GST Tax :");
	JLabel gstValueTaxLabel = new JLabel("18%");

	JLabel totalAmt = new JLabel("Gross Payable Amt :");
	JLabel totalAmtLabel = new JLabel("");

	JButton generateBillButton = new JButton("Generate & Save Bill");
	JButton clearButton = new JButton("Clear");

	Transaction(String pname, int page, String pspeciality) {

		this.pname = pname;
		this.page = page;
		this.speciality = pspeciality;
		

		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		transactionDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		transactionDetailsLabel.setBounds(280, 30, 250, 70);

		baseCostLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		baseCostLabel.setBounds(164, 150, 200, 30);
		baseCostTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		baseCostTextField.setBounds(464, 150, 200, 30);

		taxLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		taxLabel.setBounds(164, 200, 200, 30);
		taxValueLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		taxValueLabel.setBounds(464, 200, 200, 30);

		gstTaxLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		gstTaxLabel.setBounds(164, 250, 200, 30);
		gstValueTaxLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		gstValueTaxLabel.setBounds(464, 250, 200, 30);

		totalAmt.setFont(new Font("Arial", Font.PLAIN, 22));
		totalAmt.setBounds(164, 300, 200, 30);
		totalAmtLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		totalAmtLabel.setBounds(464, 300, 200, 30);
		totalAmtLabel.setVisible(false);

		generateBillButton.setFont(new Font("Arial", Font.PLAIN, 20));
		generateBillButton.setBounds(175, 350, 275, 30);

		clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
		clearButton.setBounds(500, 350, 131, 30);


		this.setTitle("Transaction Page");
		this.setVisible(true);
		this.setBounds(10, 10, 832, 551);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		this.setLocation(x, y);

	}

	public void addComponentsToContainer() {
		container.add(baseCostLabel);
		container.add(baseCostTextField);
		container.add(taxLabel);
		container.add(taxValueLabel);
		container.add(gstTaxLabel);
		container.add(gstValueTaxLabel);
		container.add(totalAmt);
		container.add(totalAmtLabel);
		container.add(generateBillButton);
		container.add(clearButton);
		getContentPane().add(transactionDetailsLabel);
	}

	public void addActionEvent() {
		generateBillButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	public float getAmount() {

		try {
			amt = Integer.parseInt(baseCostTextField.getText().trim());
			if (amt > 0 && pname!="") {
				amt = (float) (amt + amt * 0.05 + amt * 0.18);
				String a = String.valueOf(amt);
				totalAmtLabel.setText(a);
				totalAmtLabel.setVisible(true);
				flag = 1;
				
				this.record = "Patient Name: " + pname + "\r\n" + "Patient Age: " + page + "\r\n" + "Speciality Treatment: "
						+ speciality + "\r\n" + "Total Bill Amt: " + amt + "\r\n" + "----------------------------";
				
				this.filename = pname + "_" + page + ".txt";
				
			} else
				JOptionPane.showMessageDialog(null, "Amount Cannot Be 0 or Negative");

		}

		catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Check Details! Enter properly.");

		}
		return amt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == generateBillButton) {
			this.getAmount();
			
			if(pname!="" && amt>0)
			{
				JOptionPane.showMessageDialog(null, "Record Saved with amt: " + amt);
				new HomePage();
				dispose();
			}
			
			try {
				FileWriter writer = new FileWriter(filename, true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				 
	            bufferedWriter.write(record);
	            bufferedWriter.newLine();
	            bufferedWriter.close();
	            
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

		if (e.getSource() == clearButton) {
			baseCostTextField.setText("");
			totalAmtLabel.setText("");
		}
		
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Transaction add_transaction_frame = new Transaction("A", 58, "Dental");

	}

}
