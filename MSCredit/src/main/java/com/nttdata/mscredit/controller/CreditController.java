package com.nttdata.mscredit.controller;

import com.nttdata.mscredit.MsCreditApplication;
import com.nttdata.mscredit.model.Credit;
import com.nttdata.mscredit.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    CreditService creditService;

//    @Autowired
//    private Environment env;
    private static final Logger logger = LogManager.getLogger(MsCreditApplication.class);

//    @Value("${application.config.description}")
//    private String texto;
    @GetMapping
    public Flux<Credit> getCredits(){
        return creditService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> getCreditById(@PathVariable("id") String id){
        return creditService.getCreditById(id);
    }

    @GetMapping("/byPersonalCustomer/{id}")
    public Mono<Credit> getCreditByIdCustomer(@PathVariable("id") String idCustomer){
        return creditService.getCreditByIdCustomer(idCustomer);
    }

    @GetMapping("/allByCustomer/{id}")
    public Flux<Credit> getAllCreditByIdCustomer(@PathVariable("id") String idCustomer){
        return creditService.getAllByIdCustomer(idCustomer);
    }

    @PostMapping
    public Mono<Credit> postCredit(@RequestBody Credit credit){
        return creditService.save(credit);
    }

    @PutMapping
    Mono<Credit> updCredit(@RequestBody Credit credit){
        logger.debug(credit.getCreditType()+" Entro 2");
        return creditService.save(credit);
    }

    @DeleteMapping("/{id}")
    void dltCredit(@PathVariable("id") String id){
        creditService.delete(id);
    }

//    @GetMapping("/obtener-config")
//    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){
//        logger.info(texto);
//
//        Map<String, String> json = new HashMap<>();
//        json.put("texto", texto);
//        json.put("puerto", puerto);
//        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
//    }
}