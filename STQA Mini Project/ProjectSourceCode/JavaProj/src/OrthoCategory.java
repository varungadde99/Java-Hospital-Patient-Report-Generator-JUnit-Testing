import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrthoCategory extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	String pname;
	int page = 0;
	String pspeciality = "";
	int rating =0;
	String treatment = "";
	
	Container container = getContentPane();

	private final JLabel orthoDetailsLabel = new JLabel("Add Ortho Details");
	
	JLabel askquestionLabel = new JLabel("Answer the following questions:");
	
	JLabel CategoryLabel = new JLabel("Category :");
	JLabel RatingLabel = new JLabel("Severity Rating:");

	static ButtonGroup Category = new ButtonGroup();
	JRadioButton rdbtnOperation = new JRadioButton("Operation");
	JRadioButton rdbtnFracture = new JRadioButton("Fracture");
	JRadioButton rdbtnLigament = new JRadioButton("Ligament Tear");
	JRadioButton rdbtnPain = new JRadioButton("Pain/Swelling");
	
	JSlider sliderRating = new JSlider(0,10,5);
	JButton allotRoomButton = new JButton("Allot Room");
	JButton clearButton = new JButton("Clear");
	
	
	int flag = 0;

	OrthoCategory(String pname, int page, String pspeciality) {
		
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

		orthoDetailsLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		orthoDetailsLabel.setBounds(280, 30, 250, 70);

		askquestionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		askquestionLabel.setBounds(164, 130, 500, 30);

		CategoryLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		CategoryLabel.setBounds(264, 180, 200, 30);
		
		rdbtnOperation.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnOperation.setBounds(464, 180, 200, 30);

		rdbtnFracture.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnFracture.setBounds(464, 220 , 200, 30);

		rdbtnLigament.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnLigament.setBounds(464, 260 , 200, 30);
		
		rdbtnPain.setFont(new Font("Arial", Font.PLAIN, 22));
		rdbtnPain.setBounds(464, 300 , 200, 30);
		
		Category.add(rdbtnOperation);
		Category.add(rdbtnFracture);
		Category.add(rdbtnLigament);
		Category.add(rdbtnPain);

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
		container.add(rdbtnOperation);
		container.add(rdbtnFracture);
		container.add(rdbtnLigament);
		container.add(rdbtnPain);
		container.add(RatingLabel);
		container.add(sliderRating);
		container.add(allotRoomButton);
		container.add(clearButton);
		getContentPane().add(orthoDetailsLabel);
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
			
			if(rdbtnOperation.isSelected())
			{
				treatment = "Operation";
			}
			
			
			if(rdbtnFracture.isSelected())
			{
				treatment = "Fracture";
			}
			

			if(rdbtnLigament.isSelected())
			{
				treatment = "Ligament Tear";
			}
			
			if(rdbtnPain.isSelected())
			{
				treatment = "Pain/Swelling";
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
		OrthoCategory add_ortho_page = new OrthoCategory("A", 58, "Ortho");

	}	
	
}