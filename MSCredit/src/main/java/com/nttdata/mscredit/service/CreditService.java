package com.nttdata.mscredit.service;

import com.nttdata.mscredit.model.Credit;
import com.nttdata.mscredit.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<Credit> getAll();
    Flux<Credit> getAllByIdCustomer(String idCustomer);
    Mono<Credit> getCreditById(String id);
    Mono<Credit> save(Credit credit);
    Mono<Credit> getCreditByIdCustomer(String idCustomer);
    void delete(String id);
    Mono<Customer> test(String idCustomer);
}
