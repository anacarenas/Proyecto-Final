package com.nttdata.mscustomer.service;

import com.nttdata.mscustomer.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    public Flux<Customer> findAll();
    public Mono<Customer> findById(String id);
    public Mono<Customer> save(Customer client);
    public void delete(String id);
}
