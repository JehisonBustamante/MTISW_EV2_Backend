package com.vehiculoservice.controller;

import com.vehiculoservice.entity.VehiculoEntity;
import com.vehiculoservice.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/registros")
    public ResponseEntity<List<VehiculoEntity>> registros()
    {
        if(vehiculoService.obtenerTodos() != null)
        {
            return ResponseEntity.ok(vehiculoService.obtenerTodos());
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/por-id/{id}")
    public ResponseEntity<Optional<VehiculoEntity>> obtenerPorID(@PathVariable("id") int id)
    {
        return ResponseEntity.ok(vehiculoService.obtenerPorID((Integer) id));
    }

    @GetMapping("/por-marca/{s}")
    public ResponseEntity<List<VehiculoEntity>> todasLasMarcas(@PathVariable("s") String s)
    {
        return ResponseEntity.ok(vehiculoService.todasPorMarca(s));
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarVehiculo(@RequestBody VehiculoEntity vehiculoEntity)
    {
        vehiculoService.nuevoVehiculo(vehiculoEntity);
        return ResponseEntity.ok("Vehiculo agregado con exito");
    }
}
