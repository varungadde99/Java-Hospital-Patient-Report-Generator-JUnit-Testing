
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTest extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	Container container = getContentPane();

	private final JLabel welcomeLabel = new JLabel("Hospital Admin Login");

	JLabel usernameLabel = new JLabel("Enter Username");
	JLabel passwordLabel = new JLabel("Enter Password");

	JTextField usernameTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();

	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");

	JCheckBox showPassword = new JCheckBox("View Password");

	LoginTest() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {

		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		welcomeLabel.setBounds(280, 30, 250, 70);	//x,y,w,h

		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		usernameLabel.setBounds(164, 150, 200, 30);

		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		passwordLabel.setBounds(163, 220, 194, 30);

		usernameTextField.setBounds(433, 150, 150, 30);
		passwordField.setBounds(433, 220, 150, 30);

		showPassword.setBounds(350, 280, 150, 30);

		loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
		loginButton.setBounds(231, 341, 143, 45);
		loginButton.setEnabled(false);

		clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
		clearButton.setBounds(433, 341, 131, 45);

		this.setTitle("STQA Project");
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
		container.add(usernameLabel);
		container.add(passwordLabel);
		container.add(usernameTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(clearButton);
		getContentPane().add(welcomeLabel);
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		clearButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String userText;
		String pwdText;
		userText = usernameTextField.getText();
		pwdText = passwordField.getText();

		if (!userText.isEmpty() && pwdText.length() > 0) {
			loginButton.setEnabled(true);
		}

		if (e.getSource() == loginButton) {
			if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {
				JOptionPane.showMessageDialog(null, "Login Successful");
				new HomePage().setVisible(true);
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			}
		}

		if (e.getSource() == clearButton) {
			usernameTextField.setText("");
			passwordField.setText("");
			loginButton.setEnabled(false);
		}

		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LoginTest login_frame = new LoginTest();

	}

}
