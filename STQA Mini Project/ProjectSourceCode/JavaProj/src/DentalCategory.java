import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DentalCategory extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String pname;
	int page = 0;
	String pspeciality = "";
	int rating =0;
	String treatment = "";
	
	Container container = getContentPane();

	private final JLabel dentalDetailsLabel = new JLabel("Add Dental Details");
	
	JLabel askquestionLabel = new JLabel("Answer the following questions:");
	
	JLabel CategoryLabel = new JLabel("Category :");
	JLabel RatingLabel = new JLabel("Severity Rating:");

	static ButtonGroup Category = new ButtonGroup();
	JRadioButton rdbtnRoot = new JRadioButton("Root Canal");
	JRadioButton rdbtnCavity = new JRadioButton("Cavity Treatment");
	JRadioButton rdbtnBraces = new JRadioButton("Braces");
	JRadioButton rdbtnGeneral = new JRadioButton("General");
	
	JSlider sliderRating = new JSlider(0,10,5);
	JButton allotRoomButton = new JButton("Allot Room");
	JButton clearButton = new JButton("Clear");
	
	
	int flag = 0;

	DentalCategory(String pname, int page, String pspeciality) {
		
		this.pname = pname;
		this.page = page;
		this.pspeciality = pspeciality;
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		dentalDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		dentalDetailsLabel.setBounds(280, 30, 250, 70);

		askquestionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		askquestionLabel.setBounds(164, 130, 500, 30);

		CategoryLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		CategoryLabel.setBounds(264, 180, 200, 30);
		
		rdbtnRoot.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnRoot.setBounds(464, 180, 200, 30);

		rdbtnCavity.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnCavity.setBounds(464, 220 , 200, 30);

		rdbtnBraces.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnBraces.setBounds(464, 260 , 200, 30);
		
		rdbtnGeneral.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnGeneral.setBounds(464, 300 , 200, 30);
		
		Category.add(rdbtnRoot);
		Category.add(rdbtnCavity);
		Category.add(rdbtnBraces);
		Category.add(rdbtnGeneral);

		RatingLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		RatingLabel.setBounds(264, 350, 200, 30);
		
		sliderRating.setFont(new Font("Arial", Font.PLAIN, 15));
		sliderRating.setBounds(464, 350 , 200, 50);
		
		sliderRating.setPaintTrack(true);
		sliderRating.setPaintTicks(true);
		sliderRating.setPaintLabels(true);
		
		sliderRating.setMajorTickSpacing(1);
		
		allotRoomButton.setFont(new Font("Arial", Font.PLAIN, 20));
		allotRoomButton.setBounds(231, 420, 143, 45);

		clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
		clearButton.setBounds(433, 420, 131, 45);

		
		this.setTitle("Add Ortho Details");
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
		container.add(askquestionLabel);
		container.add(CategoryLabel);
		container.add(rdbtnRoot);
		container.add(rdbtnCavity);
		container.add(rdbtnBraces);
		container.add(rdbtnGeneral);
		container.add(RatingLabel);
		container.add(sliderRating);
		container.add(allotRoomButton);
		container.add(clearButton);
		getContentPane().add(dentalDetailsLabel);
	}

	public void addActionEvent() {
		allotRoomButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == allotRoomButton) {
			rating = sliderRating.getValue();
			System.out.println(rating);
			
			if(rdbtnRoot.isSelected())
			{
				treatment = "Root Canal";
			}
			
			
			if(rdbtnCavity.isSelected())
			{
				treatment = "Cavity Treatment";
			}
			

			if(rdbtnBraces.isSelected())
			{
				treatment = "Braces";
			}
			
			if(rdbtnGeneral.isSelected())
			{
				treatment = "General Checkup";
			}
			
			new Rooms(pname, page, pspeciality ,rating,treatment);
			dispose();
		}

		if (e.getSource() == clearButton) {
			Category.clearSelection();
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		DentalCategory add_dental_page = new DentalCategory("A", 58, "Dental");

	}	
	
}