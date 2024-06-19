package ar.edu.unlam.pb2;

import java.util.Comparator;


public class OrdenarPorPrecio implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad o1, Propiedad o2) {
        return o1.getPrecioVenta().compareTo(o2.getPrecioVenta());
    }

	

}
