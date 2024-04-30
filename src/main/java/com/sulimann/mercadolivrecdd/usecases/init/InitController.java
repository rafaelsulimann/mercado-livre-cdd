package com.sulimann.mercadolivrecdd.usecases.init;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.mercadolivrecdd.utils.constants.Path;

@RestController
public class InitController {

    @GetMapping(value = Path.INIT)
    public ResponseEntity<Object> init(){
        return ResponseEntity.status(HttpStatus.OK).body("Get realizado com sucesso!");
    }

}
