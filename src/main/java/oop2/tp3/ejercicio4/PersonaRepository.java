package oop2.tp3.ejercicio4;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PersonaRepository {

    private final Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = Objects.requireNonNull(jdbi, "jdbi no puede ser null");
    }
    /**
     * Busca por nombre a parte
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        if (nombreOParte == null || nombreOParte.isBlank()) {
            throw new IllegalArgumentException("nombreOParte no puede ser null o vacio");
        }
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();
            var personas = new ArrayList<Persona>();
            for (Map<String, String> map : rs) {
                personas.add(new Persona(map.get("nombre"), map.get("apellido")));
            }
            return personas;
        });
    }
    /**
     * Dado un id, retorna:
     * - Optional.empty si el id no se encuentra en la BD
     * - Optional con la instancia de Persona encontrada
     */
    public Optional<Persona> buscarPorId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id debe ser mayor a 0");
        }
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where id_persona = ?")
                    .bind(0, id).mapToMap(String.class).list();
            if (rs.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido")));
        });
    }
}