
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatient extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public String record = "";
	String pname = "";
	String pspeciality = "";
	
	public String getRecord() {
		return this.record;

	}

	Container container = getContentPane();

	private final JLabel patientDetailsLabel = new JLabel("Add Patient Details");

	JLabel pnameLabel = new JLabel("Patient Name :");
	JTextField pnameTextField = new JTextField();

	JLabel pageLabel = new JLabel("Patient Age :");
	JTextField pageTextField = new JTextField();

	JLabel specialityLabel = new JLabel("Speciality :");

	static ButtonGroup Speciality = new ButtonGroup();
	JRadioButton rdbtnOrtho = new JRadioButton("Ortho");
	JRadioButton rdbtnDental = new JRadioButton("Dental");

	JButton addPatientButton = new JButton("Add Patient");
	JButton clearButton = new JButton("Clear");

	String pnameText = pnameTextField.getText().trim();
	int page = 0;
	int flag = 0;

	AddPatient() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		patientDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		patientDetailsLabel.setBounds(280, 30, 250, 70);

		pnameLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		pnameLabel.setBounds(164, 150, 200, 30);

		pnameTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		pnameTextField.setBounds(464, 150, 200, 30);
		pnameTextField.setText(null);

		pageLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		pageLabel.setBounds(164, 200, 200, 30);
		pageTextField.setText(null);

		pageTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		pageTextField.setBounds(464, 200, 200, 30);

		specialityLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		specialityLabel.setBounds(164, 260, 200, 30);

		rdbtnOrtho.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnOrtho.setBounds(464, 260, 200, 30);

		rdbtnDental.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnDental.setBounds(464, 300, 200, 30);

		Speciality.add(rdbtnOrtho);
		Speciality.add(rdbtnDental);

		addPatientButton.setFont(new Font("Arial", Font.PLAIN, 20));
		addPatientButton.setBounds(231, 341, 143, 45);

		clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
		clearButton.setBounds(433, 341, 131, 45);

		this.setTitle("Add Patient Page");
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
		container.add(pnameLabel);
		container.add(pnameTextField);
		container.add(pageLabel);
		container.add(pageTextField);
		container.add(specialityLabel);
		container.add(rdbtnOrtho);
		container.add(rdbtnDental);
		container.add(addPatientButton);
		container.add(clearButton);
		getContentPane().add(patientDetailsLabel);
	}

	public void addActionEvent() {
		addPatientButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == addPatientButton) {
			
			try {
				flag = 0;
				String pname = pnameTextField.getText().trim();
				int page = 0;
				
				page = Integer.parseInt(pageTextField.getText().trim());
			
					
						
						if(page>0){
							System.out.println("Accepted Entry");
						}
						else
						{
							System.out.println("Denied Entry");
							JOptionPane.showMessageDialog(this, "Check Details! Enter properly.");
							flag = 1;
						}
				
			}

				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Check Details! Enter properly.");
					flag = 1;
				}
						
				
		

			if (rdbtnOrtho.isSelected())
				{
					pspeciality = "Ortho";
					if(flag!=1)	
					new OrthoCategory(pname, page, pspeciality);
				}
			else
				{
					pspeciality = "Dental";
					if(flag!=1)	
					new DentalCategory(pname, page, pspeciality);
				}
			
			if(flag!=1)	
			dispose();

		}

		if (e.getSource() == clearButton) {
			pnameTextField.setText("");
			pageTextField.setText("");
			Speciality.clearSelection();

		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		AddPatient add_patient_frame = new AddPatient();

	}

}
