package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenarPorUbicacion implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad o1, Propiedad o2) {
		
		return o1.getCalle().compareTo(o2.getCalle());
	}

}
