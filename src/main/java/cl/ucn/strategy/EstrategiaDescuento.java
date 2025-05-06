package cl.ucn.strategy;

import cl.ucn.modelo.Producto;

import java.util.List;

public interface EstrategiaDescuento {

    double aplicarDescuento(List<Producto> productos, String fechaNacimiento, String anhoRegistro,
                         String fechaActual);

}
