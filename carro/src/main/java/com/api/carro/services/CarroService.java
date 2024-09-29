package com.api.carro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carro.entitys.Carro;
import com.api.carro.repositorys.CarroRepository;

@Service
public class CarroService {

  @Autowired
  private CarroRepository carroRepository;

  public String save(Carro carro){
    this.carroRepository.save(carro);
    
    return "Carro salvo com sucesso!";
  }

  public List<Carro> findAll(){

    return this.carroRepository.findAll();
  }

  public Carro fincById(Long id){
    Carro carro = this.carroRepository.findById(id).get();

    return carro;
  }

  public String delete(Long id){

    this.carroRepository.deleteById(id);

    return "Carro excluído com sucesso!";
  }

  public String update(Long id, Carro carro){

    carro.setId(id);
    this.carroRepository.save(carro);

    return "Carro atualizado com sucesso!";
  }
}
