package edu.udistrital.nomina.nominavaquiro.model;

public class Cliente extends Persona{

    private static final long serialVersionUID = 1L;

    public Cliente() {
        super();
    }

    public Cliente(String docId, String nombre, String apellido, String correo, String telefono) {
        super(docId, nombre, apellido, correo, telefono);
    }
    
    public boolean validar() {
        return docId != null && !docId.isEmpty() && nombre != null && !nombre.isEmpty();
    }
}