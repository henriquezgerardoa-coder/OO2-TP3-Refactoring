package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaRepositoryTest {

    private PersonaRepository repository;

    @BeforeEach
    public void setUp() {
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
        new SetUpDatabase(jdbi).setUp();
        repository = new PersonaRepository(jdbi);
    }

    @Test
    public void buscarPorNombreLanzaExcepcionSiParametroEsNullOVacio() {
        assertThrows(IllegalArgumentException.class, () -> repository.buscarPorNombre(null));
        assertThrows(IllegalArgumentException.class, () -> repository.buscarPorNombre(""));
        assertThrows(IllegalArgumentException.class, () -> repository.buscarPorNombre("   "));
    }

    @Test
    public void buscarPorIdLanzaExcepcionSiIdNoEsValido() {
        assertThrows(IllegalArgumentException.class, () -> repository.buscarPorId(0L));
        assertThrows(IllegalArgumentException.class, () -> repository.buscarPorId(-1L));
    }

    @Test
    public void buscarPorNombreRetornaListaVaciaCuandoNoHayCoincidencias() {
        List<Persona> personas = repository.buscarPorNombre("ZZZ");

        assertTrue(personas.isEmpty());
    }

    @Test
    public void buscarPorIdRetornaOptionalVacioCuandoNoExiste() {
        assertTrue(repository.buscarPorId(999L).isEmpty());
    }

    @Test
    public void buscarPorNombreYPorIdRetornanDatosCuandoExisten() {
        List<Persona> personas = repository.buscarPorNombre("Vla");

        assertEquals(1, personas.size());
        assertEquals("Vladimir", personas.get(0).nombre());
        assertEquals("Varkov", personas.get(0).apellido());

        Persona persona = repository.buscarPorId(1L).orElseThrow();
        assertEquals("José", persona.nombre());
        assertEquals("Laurenti", persona.apellido());
    }
}

