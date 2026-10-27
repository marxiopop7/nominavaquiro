package edu.udistrital.nomina.nominavaquiro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import edu.udistrital.nomina.nominavaquiro.model.*;

@Repository
public class NominaRepository {

    private List<Nomina> listanomina = new ArrayList<>();

    public NominaRepository() {
        if (listanomina.isEmpty()) {
            
            Cliente cliente1 = new Cliente("101010", "Laura", "Gomez", "laura@correo.com", "3001112233");
            Nomina nomina1 = new Nomina("NOM-001", cliente1, 5000000, 90, 11.5);
            listanomina.add(nomina1);

            
            Cliente cliente2 = new Cliente("202020", "Andres", "Perez", "andres@correo.com", "3104445566");
            Nomina nomina2 = new Nomina("NOM-002", cliente2, 12000000, 180, 13.0);
            listanomina.add(nomina2);
        }
    }

    public List<Nomina> findAll() {
        return listanomina;
    }

    public void save(Nomina nomina) {
        listanomina.add(nomina);
    }

    public void delete(String idNomina) {
        listanomina.removeIf(n -> n.getIdnomina().equals(idNomina));
    }

    public Optional<Nomina> findById(String idNomina) {
        return listanomina.stream().filter(n -> n.getIdnomina().equals(idNomina)).findFirst();
    }

    public void update(Nomina nomina) {
        for (int i = 0; i < listanomina.size(); i++) {
            if (listanomina.get(i).getIdnomina().equals(nomina.getIdnomina())) {
                listanomina.set(i, nomina);
                break;
            }
        }
    }
}