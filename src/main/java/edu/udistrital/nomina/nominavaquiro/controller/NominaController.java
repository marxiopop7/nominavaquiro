package edu.udistrital.nomina.nominavaquiro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.udistrital.nomina.nominavaquiro.model.*;
import edu.udistrital.nomina.nominavaquiro.service.*;

@RestController
@RequestMapping("/edu/udistrital/nomina")
public class NominaController {

    @Autowired
    private NominaService NominaService;

    @GetMapping
    public ResponseEntity<List<Nomina>> listarHistorico() {
        return ResponseEntity.ok(NominaService.obtenerHistorico());
    }
    
    @GetMapping("/{idnomina}")
    public ResponseEntity<Nomina> obtenerPorId(@PathVariable String idnomina) {
        return NominaService.buscarId(idnomina)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> crearNomina(@RequestBody Nomina nomina) {
        try {

            Nomina nueva = NominaService.guardarNuevonomina(nomina);
            return ResponseEntity.ok(nueva);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<Nomina> modificarNomina(@RequestBody Nomina nomina) {
        Nomina Actualizado = NominaService.actualizarnomina(nomina);
        return ResponseEntity.ok(Actualizado);
    }
    
    @DeleteMapping("/{idnomina}")
    public ResponseEntity<String> borrarNomina(@PathVariable String idnomina) {
        boolean eliminado = NominaService.eliminarnomina(idnomina);
        if(eliminado){
            return ResponseEntity.ok("nomina Eliminada correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}