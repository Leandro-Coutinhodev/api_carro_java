package com.api.carro.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.carro.entitys.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
