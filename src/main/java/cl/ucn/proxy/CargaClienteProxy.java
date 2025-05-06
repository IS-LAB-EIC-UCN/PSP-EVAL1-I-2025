package cl.ucn.proxy;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Producto;
import cl.ucn.utilities.CargadorCSV;
import cl.ucn.utilities.RegistroClienteProducto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargaClienteProxy implements ProxyInterface{

    private ProxyInterface base;

    public CargaClienteProxy(ProxyInterface base) {
        this.base = base;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        List<RegistroClienteProducto> registros = CargadorCSV.cargarRegistros("clientes.csv");
        for (RegistroClienteProducto registro : registros) {
            Cliente cliente = new Cliente();
            cliente.setRut(registro.getRut());
            cliente.setNombre(registro.getNombre());
            cliente.setAnhoRegistro(registro.getAnhoRegistro());
            cliente.setFechaNacimiento(registro.getFechaNacimiento());
            Producto producto = new Producto();
            producto.setIdProducto(registro.getIdProducto());
            producto.setNombreProducto(registro.getNombreProducto());
            producto.setCategoria(registro.getCategoria());
            producto.setPrecioProducto(registro.getPrecio());
            producto.setCliente(cliente);
            cliente.setProductos(Collections.singletonList(producto));
            clientes.add(cliente);
        }
        clientes.addAll(base.getClientes());
        return clientes;
    }
}
