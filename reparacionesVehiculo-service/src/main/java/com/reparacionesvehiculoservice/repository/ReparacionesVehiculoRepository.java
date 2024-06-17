package com.reparacionesvehiculoservice.repository;

import com.reparacionesvehiculoservice.entity.ReparacionesVehiculo;
import com.reparacionesvehiculoservice.model.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacionesVehiculoRepository extends JpaRepository<ReparacionesVehiculo, Integer> {
    List<ReparacionesVehiculo> findAllByIdVehiculo(Integer id);
    List<ReparacionesVehiculo> findAllByReparacionNum(Integer num);
    List<ReparacionesVehiculo> findAllByTipoReparacion(String motor);
}