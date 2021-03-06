package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiOperacionRealizada;
import vista.paciente.VentanaDatosPaciente;

public class paraUiVentanaDatosPaciente extends VentanaDatosPaciente {
	String[] ayudante;
	boolean modificar;
	String idPaciente;
	Controller control;
	public paraUiVentanaDatosPaciente(Controller control, String datos) {
		super();
		this.setControl(control);
		this.setModificar(true);
		this.agregarListener();
		ayudante=datos.split("-");
		this.setIdPaciente(ayudante[2]);
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[5]);
		this.getTxtFechaNacimiento().setText(ayudante[4]);
	}
	private void agregarListener() {
		this.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isModificar())
				{
					getTxtTelefono().setEditable(true);
					getTxtTelefono().setBorder(new LineBorder(Color.RED, 1, true));
					getTxtDireccion().setEditable(true);
					getTxtDireccion().setBorder(new LineBorder(Color.RED, 1, true));
					setModificar(false);
				}
				else
				{
					getTxtTelefono().setEditable(false);
					getTxtTelefono().setBorder(new LineBorder(Color.BLUE, 1, true));
					getTxtDireccion().setEditable(false);
					getTxtDireccion().setBorder(new LineBorder(Color.BLUE, 1, true));
					getControl().modificarPaciente(getIdPaciente(),getTxtTelefono().getText(),getTxtDireccion().getText());
					setModificar(true);
				}
				
			}
		});
		this.getBtnEliminar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getControl().eliminarPaciente(ayudante[2]);
				ParaUiOperacionRealizada paraUiOperacionRealizada = new ParaUiOperacionRealizada("Paciente eliminado");
				paraUiOperacionRealizada.setVisible(true);
				paraUiVentanaPaciente paraUiVentanaPaciente = new paraUiVentanaPaciente(getControl());
				paraUiVentanaPaciente.setVisible(true);
				dispose();
			}
		});
		this.getBtnHistorial().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaHistorialPaciente paraUiVentanaHistorialPaciente = new ParaUiVentanaHistorialPaciente(ayudante[2], getControl());
				paraUiVentanaHistorialPaciente.setVisible(true);
			}
		});
		this.getBtnSolicitarCita().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaSolicitarCitaPaciente paraUiVentanaSolicitarCitaPaciente = new ParaUiVentanaSolicitarCitaPaciente(getControl(),ayudante[2]);
				paraUiVentanaSolicitarCitaPaciente.setVisible(true);
			}
		});
		
	}
	public String[] getAyudante() {
		return ayudante;
	}
	public void setAyudante(String[] ayudante) {
		this.ayudante = ayudante;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public boolean isModificar() {
		return modificar;
	}
	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	

}
