package com.vehiculoservice.service;

import com.vehiculoservice.entity.VehiculoEntity;
import com.vehiculoservice.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<VehiculoEntity> obtenerTodos()
    {
        return vehiculoRepository.findAll();
    }

    public void nuevoVehiculo(VehiculoEntity vehiculoEntity)
    {
        vehiculoRepository.save(vehiculoEntity);
    }

    public Optional<VehiculoEntity> obtenerPorID(Integer id)
    {
        return vehiculoRepository.findById(id);
    }

    public List<VehiculoEntity> todasPorMarca(String marca)
    {
        return vehiculoRepository.findAllByMarca(marca);
    }

    public List<VehiculoEntity> todosPorMotor(String motor){
        return vehiculoRepository.findAllByMotor(motor);
    }

}
