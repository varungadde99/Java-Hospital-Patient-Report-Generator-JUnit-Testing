import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rooms extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String pname;
	int page = 0;
	String pspeciality = "";
	int rating = 0;
	String roomCategory = "";
	String treatment = "";
	
	Container container = getContentPane();

	private final JLabel roomDetailsLabel = new JLabel("Add Room Details");
	
	JLabel selectroomLabel = new JLabel("Select Room Category");
	
	JLabel CategoryLabel = new JLabel("Category :");
	//JLabel RatingLabel = new JLabel("Severity Rating:");

	static ButtonGroup Category = new ButtonGroup();
	static ButtonGroup Cbox = new ButtonGroup();
	
	
	JRadioButton rdbtnICU = new JRadioButton("ICU");
	JRadioButton rdbtnDeluxe = new JRadioButton("Deluxe");
	JRadioButton rdbtnStandard = new JRadioButton("Standard");
	JRadioButton rdbtnGeneral = new JRadioButton("General");
	
	//JSlider sliderRating = new JSlider(0,10,5);
	JLabel nutritionLabel = new JLabel("Hospital Nutrition Service:");
	JCheckBox nutritionCbox = new JCheckBox("Opt if YES");
	
	JButton transactionButton = new JButton("Transaction");
	JButton clearButton = new JButton("Clear");
	
	
	int flag = 0;

	Rooms(String pname, int page, String pspeciality , int rating, String treatment) {
		
		this.pname = pname;
		this.page = page;
		this.pspeciality = pspeciality;
		this.rating = rating;
		this.treatment = treatment;
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		roomDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		roomDetailsLabel.setBounds(280, 30, 250, 70);

		selectroomLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		selectroomLabel.setBounds(164, 130, 500, 30);

		CategoryLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		CategoryLabel.setBounds(264, 180, 200, 30);
		
		rdbtnICU.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnICU.setBounds(464, 180, 200, 30);

		rdbtnDeluxe.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnDeluxe.setBounds(464, 220 , 200, 30);

		rdbtnStandard.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnStandard.setBounds(464, 260 , 200, 30);
		
		rdbtnGeneral.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnGeneral.setBounds(464, 300 , 200, 30);
		
		Category.add(rdbtnICU);
		Category.add(rdbtnDeluxe);
		Category.add(rdbtnStandard);
		Category.add(rdbtnGeneral);

		nutritionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		nutritionLabel.setBounds(164, 350, 300, 30);
		
		nutritionCbox.setFont(new Font("Arial", Font.PLAIN, 22));
		nutritionCbox.setBounds(464, 350 , 200, 30);
		Cbox.add(nutritionCbox);
		
		transactionButton.setFont(new Font("Arial", Font.PLAIN, 20));
		transactionButton.setBounds(231, 420, 143, 45);

		clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
		clearButton.setBounds(433, 420, 131, 45);

		
		this.setTitle("Add Room Details");
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
		container.add(selectroomLabel);
		container.add(CategoryLabel);
		container.add(rdbtnICU);
		container.add(rdbtnDeluxe);
		container.add(rdbtnStandard);
		container.add(rdbtnGeneral);
		container.add(nutritionLabel);
		container.add(nutritionCbox);
		container.add(transactionButton);
		container.add(clearButton);
		getContentPane().add(roomDetailsLabel);
	}

	public void addActionEvent() {
		transactionButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == transactionButton) {
			
			if(rdbtnICU.isSelected())
			{
				roomCategory = "ICU";
			}
			
			if(rdbtnDeluxe.isSelected())
			{
				roomCategory = "Deluxe";
			}
			
			if(rdbtnStandard.isSelected())
			{
				roomCategory = "Standard";
			}
			
			if(rdbtnGeneral.isSelected())
			{
				roomCategory = "General";
			}
			
			new Transaction(pname, page, pspeciality,rating,treatment,roomCategory);
			dispose();
		}

		if (e.getSource() == clearButton) {
			Category.clearSelection();
			Cbox.clearSelection();
			
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Rooms add_room_page = new Rooms("A", 58, "Ortho",5,"Fracture");

	}	
	
}