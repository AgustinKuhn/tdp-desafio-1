package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2023 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 260));
		setResizable(false);
		setContentPane(contentPane);
		
		ImageIcon icono = new ImageIcon("/images/tdp.png");
	    setIconImage(icono.getImage());
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data

		// Informacion del alumno
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 216);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation,
				"Muestra la informaci�n declarada por el alumno");

		JLabel LabelLU = new JLabel("LU");

		JLabel LabelNombre = new JLabel("Nombre");

		JLabel LabelApellido = new JLabel("Apellido");

		JLabel LabelEmail = new JLabel("Email");

		JLabel LabelGitHub = new JLabel("GitHub URL");

		JTextField txtLU = new JTextField();
		txtLU.setColumns(10);
		txtLU.setText(Integer.toString(studentData.getId()));

		JTextField txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setText(studentData.getLastName());

		JTextField txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setText(studentData.getFirstName());

		JTextField txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setText(studentData.getMail());

		JTextField txtGitHubURL = new JTextField();
		txtGitHubURL.setColumns(10);
		txtGitHubURL.setText(studentData.getGithubURL());

		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup().addContainerGap().addGroup(gl_tabInformation
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelLU, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtLU, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelApellido, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtApellido, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelNombre, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelGitHub, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtGitHubURL, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
						.addGroup(gl_tabInformation.createSequentialGroup()
								.addComponent(LabelEmail, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_tabInformation
				.setVerticalGroup(
						gl_tabInformation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_tabInformation.createSequentialGroup().addGap(15)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelLU).addComponent(txtLU, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelApellido)
												.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_tabInformation.createSequentialGroup().addGap(10)
														.addComponent(LabelNombre))
												.addGroup(gl_tabInformation.createSequentialGroup().addGap(10)
														.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelEmail)
												.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelGitHub).addComponent(txtGitHubURL,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(10)));

		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);

		// Foto del alumno
		JLabel image = new JLabel();
		image.setBounds(450, 40, 120, 150);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon profileIcon = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/foto.jpg"))
				.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
		image.setIcon(profileIcon);
		contentPane.add(image, BorderLayout.CENTER);

		// fecha y hora en la que la ventana se lanz� a ejecuci�n
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel dateLabel = new JLabel(
				"Esta ventana fue generada el " + date.format(now) + " a las " + time.format(now));
		dateLabel.setBounds(15, 240, 420, 13);
		contentPane.add(dateLabel, BorderLayout.SOUTH);

	}
}
