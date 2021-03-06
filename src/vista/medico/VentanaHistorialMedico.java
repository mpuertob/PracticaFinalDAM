package vista.medico;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import vista.ventanaPrincipal;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

public class VentanaHistorialMedico extends JDialog {
	int pX,pY;
	private JLabel txtNombreMedico;
	private JPanel panelHistorialMedico;
	
	public VentanaHistorialMedico() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 540, 450);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		panelHistorialMedico = new JPanel();
		panelHistorialMedico.setBorder(new LineBorder(new Color(153, 204, 255)));
		panelHistorialMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY();
			}
		});
		panelHistorialMedico.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		panelHistorialMedico.setBackground(Color.WHITE);
		getContentPane().add(panelHistorialMedico, BorderLayout.CENTER);
		panelHistorialMedico.setLayout(null);
		
			JButton btnCerrar = new JButton("");
			btnCerrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			btnCerrar.setBackground(new Color(0, 153, 255));
			btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setBorderPainted(false);
			btnCerrar.setOpaque(true);
			btnCerrar.setBounds(503, 0, 37, 31);
			panelHistorialMedico.add(btnCerrar);
			
			JLabel lblHistorialMedico = new JLabel("HISTORIAL MEDICO");
			lblHistorialMedico.setIcon(new ImageIcon(VentanaHistorialMedico.class.getResource("/images/iconventana.png")));
			lblHistorialMedico.setOpaque(true);
			lblHistorialMedico.setHorizontalAlignment(SwingConstants.LEFT);
			lblHistorialMedico.setForeground(Color.WHITE);
			lblHistorialMedico.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
			lblHistorialMedico.setBackground(SystemColor.textHighlight);
			lblHistorialMedico.setBounds(0, 0, 540, 31);
			panelHistorialMedico.add(lblHistorialMedico);
			
			JLabel lblCitasPendientes = new JLabel("Citas Pendientes");
			lblCitasPendientes.setForeground(new Color(0, 102, 204));
			lblCitasPendientes.setFont(new Font("Verdana", Font.BOLD, 13));
			lblCitasPendientes.setBounds(10, 55, 270, 15);
			panelHistorialMedico.add(lblCitasPendientes);
			
			JLabel lblCitasRealizadas = new JLabel("Citas Realizadas");
			lblCitasRealizadas.setForeground(new Color(0, 102, 204));
			lblCitasRealizadas.setFont(new Font("Verdana", Font.BOLD, 13));
			lblCitasRealizadas.setBounds(10, 240, 270, 15);
			panelHistorialMedico.add(lblCitasRealizadas);
			
			JLabel txtNombre = new JLabel("Nombre:");
			txtNombre.setForeground(new Color(0, 102, 204));
			txtNombre.setFont(new Font("Verdana", Font.BOLD, 13));
			txtNombre.setBounds(296, 55, 67, 15);
			panelHistorialMedico.add(txtNombre);
			
			txtNombreMedico = new JLabel("New label");
			txtNombreMedico.setBounds(375, 55, 153, 16);
			panelHistorialMedico.add(txtNombreMedico);
			
	}

	public JLabel getTxtNombreMedico() {
		return txtNombreMedico;
	}

	public void setTxtNombreMedico(JLabel txtNombreMedico) {
		this.txtNombreMedico = txtNombreMedico;
	}

	public JPanel getPanelHistorialMedico() {
		return panelHistorialMedico;
	}
}