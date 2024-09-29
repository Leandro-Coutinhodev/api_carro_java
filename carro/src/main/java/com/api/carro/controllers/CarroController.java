package com.api.carro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.carro.entitys.Carro;
import com.api.carro.services.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

  @Autowired
  private CarroService carroService;

  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody Carro carro){
    try {
      String retorno = this.carroService.save(carro);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao salvar!", HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findAll")
  public ResponseEntity<List<Carro>> findAll(){
    try {
      List<Carro> lista = this.carroService.findAll();

      return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Carro> findById(@PathVariable Long id){
    try {
      Carro carro = this.carroService.fincById(id);

      return new ResponseEntity<>(carro, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Carro carro){
    try {
      String retorno = this.carroService.update(id, carro);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao atualizar carro!", HttpStatus.BAD_REQUEST);
    }
  }

  public ResponseEntity<String> delete(@PathVariable Long id){
    try {
      String retorno = this.carroService.delete(id);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao excluir carro!", HttpStatus.BAD_REQUEST);
    }
  }
}
