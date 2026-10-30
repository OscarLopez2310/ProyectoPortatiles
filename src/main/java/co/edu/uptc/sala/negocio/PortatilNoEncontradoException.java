package co.edu.uptc.sala.negocio;

public class PortatilNoEncontradoException extends Exception {
    public PortatilNoEncontradoException(String message) {
        super("[!] Portatil no encontrado");
    }
}
