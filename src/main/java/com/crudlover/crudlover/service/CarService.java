package com.crudlover.crudlover.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudlover.crudlover.dto.CarDTO;
import com.crudlover.crudlover.model.Car;
import com.crudlover.crudlover.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public List<Car> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, CarDTO dto) {
        repository.findById(id).map(car -> {
            car.setFabricante(dto.fabricante());
            car.setDataFabricacao(dto.dataFabricacao());
            car.setModelo(dto.modelo());
            car.setAnoModelo(dto.anoModelo());
            car.setValor(dto.valor());
            return repository.save(car);
        });
    }

    public ResponseEntity<String> create(CarDTO dto) {
        repository.save(new Car(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}
