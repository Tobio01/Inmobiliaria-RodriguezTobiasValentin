package ar.edu.unlam.pb2;

public class Permuta extends Operacion {

	private Propiedad propiedadA;
	private Propiedad propiedadB;
	private Cliente propietarioA;
	private Cliente propietarioB;

	public Permuta(tipoOperacion tipo, Propiedad propiedadA, Propiedad propiedadB, Cliente propietarioA,
			Cliente propietarioB) {
		super(tipo);
		this.propiedadA = propiedadA;
		this.propiedadB = propiedadB;
		this.propietarioA = propiedadA.getDueño();
		this.propietarioB = propiedadB.getDueño();
	}

	public Propiedad getPropieadadA() {
		return propiedadA;
	}

	public void setPropieadadA(Propiedad propieadadA) {
		this.propiedadA = propieadadA;
	}

	public Propiedad getPropiedadB() {
		return propiedadB;
	}

	public void setPropiedadB(Propiedad propiedadB) {
		this.propiedadB = propiedadB;
	}

	public Cliente getPropietarioA() {
		return propietarioA;
	}

	public void setPropietarioA(Cliente propietarioA) {
		this.propietarioA = propietarioA;
	}

	public Cliente getPropietarioB() {
		return propietarioB;
	}

	public void setPropietarioB(Cliente propietarioB) {
		this.propietarioB = propietarioB;
	}

	public void ejecutar(Propiedad propiedadA, Propiedad propiedadB) {

		propiedadA.setDueño(propietarioB);
		propiedadB.setDueño(propietarioA);

	}

	@Override
	public String toString() {
		return "Permuta [propiedadA=" + propiedadA + ", propiedadB=" + propiedadB + ", propietarioA=" + propietarioA
				+ ", propietarioB=" + propietarioB + "]";
	}
	

}
