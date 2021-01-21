package ec.edu.ups.appdis.g1.clienteRest.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ec.edu.ups.appdis.g1.clienteRest.clienterest.FachadaCli;
import ec.edu.ups.appdis.g1.clienteRest.model.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;
	private JTextField txtCedula;
	private JLabel lblNewLabel_1;
	private JTextField txtCuenta;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JLabel lblNewLabel_3;
	private JTextField txtPlazos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(7, 41, 124, 14);
		panel.add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(141, 38, 237, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		lblNewLabel_1 = new JLabel("# Cuenta");
		lblNewLabel_1.setBounds(7, 74, 124, 14);
		panel.add(lblNewLabel_1);
		
		txtCuenta = new JTextField();
		txtCuenta.setColumns(10);
		txtCuenta.setBounds(141, 71, 237, 20);
		panel.add(txtCuenta);
		
		lblMonto = new JLabel("Monto");
		lblMonto.setBounds(7, 110, 124, 14);
		panel.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		txtMonto.setBounds(141, 107, 237, 20);
		panel.add(txtMonto);
		
		lblNewLabel_3 = new JLabel("# Plazos");
		lblNewLabel_3.setBounds(7, 143, 124, 14);
		panel.add(lblNewLabel_3);
		
		txtPlazos = new JTextField();
		txtPlazos.setColumns(10);
		txtPlazos.setBounds(141, 140, 237, 20);
		panel.add(txtPlazos);
		
		JButton btnNewButton = new JButton("Generar Solicitud");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fachada= new Fachada();
				fachada.setCedula(txtCedula.getText());
				fachada.setNumeroCuenta(Integer.parseInt(txtCuenta.getText()));
				fachada.setNumerodemesesplazo(Integer.parseInt(txtPlazos.getText()));
				fachada.setValorDecredito(Double.parseDouble((txtMonto.getText())));
				FachadaCli cli= new FachadaCli();
				cli.registra(fachada);
				
			}
		});
		btnNewButton.setBounds(141, 190, 176, 20);
		panel.add(btnNewButton);
	}
}
