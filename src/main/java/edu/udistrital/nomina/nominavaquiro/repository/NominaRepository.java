package edu.udistrital.nomina.nominavaquiro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import edu.udistrital.nomina.nominavaquiro.model.*;

@Repository
public class NominaRepository {


    private List<nomina> listanomina = new ArrayList<>();

    public List<nomina> findAll() {
        return listanomina;
    }

    public void save(nomina cdt) {
        listanomina.add(cdt);
    }

    public void delete(String idCdt) {
        listanomina.removeIf(c -> c.getIdCdt().equals(idCdt));
    }

    public Optional<nomina> findById(String idCdt) {
        return listanomina.stream().filter(c -> c.getIdCdt().equals(idCdt)).findFirst();
    }

    public void update(nomina cdt) {
        for (int i = 0; i < listanomina.size(); i++) {
            if (listanomina.get(i).getIdCdt().equals(cdt.getIdCdt())) {
                listanomina.set(i, cdt);
                break;
            }
        }
    }
}