package com.reparacionesvehiculoservice.controller;

import com.reparacionesvehiculoservice.entity.ReparacionesVehiculo;
import com.reparacionesvehiculoservice.service.ReparacionesVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
public class ReparacionesVehiculoController {

    @Autowired
    ReparacionesVehiculoService reparacionesVehiculoService;

    @GetMapping("/todas-reparaciones")
    public ResponseEntity<List<ReparacionesVehiculo>> getAll() {
        List<ReparacionesVehiculo> reparacionesVehiculos = reparacionesVehiculoService.getAll();
        if(reparacionesVehiculos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reparacionesVehiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionesVehiculo> getById(@PathVariable("id") int id) {
        ReparacionesVehiculo reparacionesVehiculo = reparacionesVehiculoService.getReparacionById(id);
        if(reparacionesVehiculo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reparacionesVehiculo);
    }

    @PostMapping("/nueva-reparacion")
    public ResponseEntity<ReparacionesVehiculo> save(@RequestBody ReparacionesVehiculo reparacionesVehiculo) {
        ReparacionesVehiculo reparacionesVehiculoNew = reparacionesVehiculoService.save(reparacionesVehiculo);
        return ResponseEntity.ok(reparacionesVehiculoNew);
    }

    @GetMapping("/porVehiculo/{vehiculoID}")
    public ResponseEntity<List<ReparacionesVehiculo>> getByStudentId(@PathVariable("vehiculoID") int vehiculoID) {
        List<ReparacionesVehiculo> reparacionesVehiculos = reparacionesVehiculoService.byVehiculoId(vehiculoID);
        return ResponseEntity.ok(reparacionesVehiculos);
    }

}
