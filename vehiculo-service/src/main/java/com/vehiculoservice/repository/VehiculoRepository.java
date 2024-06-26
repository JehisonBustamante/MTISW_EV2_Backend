package com.vehiculoservice.repository;

import com.vehiculoservice.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Integer> {
    List<VehiculoEntity> findAllByMarca(String marca);

    List<VehiculoEntity> findAllByMotor(String motor);


}
