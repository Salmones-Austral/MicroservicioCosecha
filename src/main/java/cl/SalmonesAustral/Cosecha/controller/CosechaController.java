package cl.SalmonesAustral.Cosecha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;
import cl.SalmonesAustral.Cosecha.service.CosechaService;

import java.util.List;

@RestController
@RequestMapping("/cosecha")
public class CosechaController {

    private final CosechaService cosechaService;

    public CosechaController(CosechaService cosechaService) {
        this.cosechaService = cosechaService;
    }

    // Crear una nueva cosecha
    @PostMapping
    public ResponseEntity<Cosecha> crearCosecha(@RequestBody Cosecha cosecha) {
        Cosecha nueva = cosechaService.crearCosecha(cosecha);
        return ResponseEntity.ok(nueva);
    }

    // Obtener todas las cosechas
    @GetMapping
    public ResponseEntity<List<Cosecha>> obtenerTodas() {
        return ResponseEntity.ok(cosechaService.obtenerTodas());
    }

    // Obtener cosecha por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cosecha> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cosechaService.obtenerPorId(id));
    }
}