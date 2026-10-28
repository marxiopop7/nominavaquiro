package edu.udistrital.nomina.nominavaquiro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.udistrital.nomina.nominavaquiro.model.*;
import edu.udistrital.nomina.nominavaquiro.repository.*;

@Service
public class NominaService {

    @Autowired 
    private NominaRepository repo;

    public List<Nomina> obtenerHistorico() {
        return repo.findAll();
    }
    
    public Nomina guardarNuevonomina(Nomina nomina) { 

        if (repo.findById(nomina.getIdnomina()).isPresent()) {
            throw new IllegalArgumentException("Error: Ya existe un registro con el ID " + nomina.getIdnomina());
        }


        List<Nomina> existentes = repo.findAll();
        for (Nomina n : existentes) {
            Cliente cActual = n.getCliente();
            Cliente cNuevo = nomina.getCliente();
            
            if (cActual != null && cNuevo != null) {
                boolean mismoNombre = cActual.getNombre().equalsIgnoreCase(cNuevo.getNombre());
                boolean mismoApellido = cActual.getApellido().equalsIgnoreCase(cNuevo.getApellido());
                boolean mismoTelefono = cActual.getTelefono().equals(cNuevo.getTelefono());

                if (mismoNombre && mismoApellido && mismoTelefono) {
                    throw new IllegalArgumentException("Error: El cliente " + cNuevo.getNombre() + " " + cNuevo.getApellido() + " con teléfono " + cNuevo.getTelefono() + " ya está registrado.");
                }
            }
        }


        nomina.calcularnomina(); 
        repo.save(nomina);
        return nomina;
    }
    
    public Nomina actualizarnomina(Nomina nomina) {
        nomina.calcularnomina(); 
        repo.update(nomina);
        return nomina;
    }
    
    public boolean eliminarnomina(String idnomina) {
        Optional<Nomina> existe = repo.findById(idnomina);
        if(existe.isPresent()){
            repo.delete(idnomina);
            return true;
        }
        return false;
    }
    
    public Optional<Nomina> buscarId(String idnomina) {
        return repo.findById(idnomina);
    }
}