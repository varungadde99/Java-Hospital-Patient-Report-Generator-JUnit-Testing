import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;

	Container container = getContentPane();

	private final JLabel menuLabel = new JLabel("Menu");

	JButton addPatientButton = new JButton("Add Patient");
	JButton exitButton = new JButton("Logout");

	HomePage() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		menuLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		menuLabel.setBounds(375, 30, 250, 70);

		addPatientButton.setFont(new Font("Arial", Font.PLAIN, 20));
		addPatientButton.setBounds(280, 100, 250, 30);

		exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
		exitButton.setBounds(280, 200, 250, 30);

		this.setTitle("HomePage");
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
		container.add(addPatientButton);
		container.add(exitButton);
		getContentPane().add(menuLabel);
	}

	public void addActionEvent() {
		addPatientButton.addActionListener(this);
		exitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addPatientButton) {
			new AddPatient().setVisible(true);
		}
		this.dispose();
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		HomePage home_frame = new HomePage();
	}

}
