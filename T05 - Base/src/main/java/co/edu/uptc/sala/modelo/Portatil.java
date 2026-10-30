package co.edu.uptc.sala.modelo;

import co.edu.uptc.sala.negocio.Sala;

/** Un portatil de la sala de sistemas. */
public class Portatil {

    private String codigo;
    private String marca;
    private EstadoPortatil estado;    // PUNTO 1 · cree el enum EstadoPortatil

    /** Un portatil nuevo siempre empieza DISPONIBLE. */
    public Portatil(String codigo, String marca) {
        this(codigo, marca, EstadoPortatil.DISPONIBLE);
    }

    /** Para reconstruirlo desde el archivo, con el estado que tenia. */
    public Portatil(String codigo, String marca, EstadoPortatil estado) {
        // PUNTO 2 · Si el codigo o la marca vienen vacios, lance DatoInvalidoException.
        if(codigo == null || codigo.isBlank()){
            throw new DatoInvalidoException("[!] Error, el codigo no puede ir vacio");
        }
        if(marca == null || marca.isBlank()){
            throw new DatoInvalidoException("[!] Error, la marca no puede ir vacio");
        }
        this.codigo = codigo;
        this.marca = marca;
        this.estado = estado;
    }

    public String getCodigo()         { return codigo; }
    public  String getMarca()          { return marca; }
    public EstadoPortatil getEstado() { return estado; }

    /** Solo se presta uno DISPONIBLE. */
    public void prestar() throws EstadoInvalidoException {
        if(estado ==EstadoPortatil.PRESTADO || estado == EstadoPortatil.REPARACION){
            throw new EstadoInvalidoException("Portatil prestado o en reparacion, por favor elija otro");
        }
        // PUNTO 2 · Si no esta DISPONIBLE, lance EstadoInvalidoException (accion "prestar").
        estado = EstadoPortatil.PRESTADO;
    }

    /** Solo se devuelve uno PRESTADO. */
    public void devolver() throws EstadoInvalidoException{
        if(getEstado() == EstadoPortatil.DISPONIBLE) {
            throw new EstadoInvalidoException("No puede devolver un portatil que no ha pedido prestado");
        }
        // PUNTO 2 · Si no esta PRESTADO, lance EstadoInvalidoException (accion "devolver").
        estado = EstadoPortatil.DISPONIBLE;
    }

    @Override
    public String toString() {
        return codigo + " | " + marca + " | " + estado.getTexto();
    }
}
