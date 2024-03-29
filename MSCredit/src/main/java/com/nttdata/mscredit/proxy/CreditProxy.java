package com.nttdata.mscredit.proxy;
import com.nttdata.mscredit.model.Customer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CreditProxy {
    private final WebClient.Builder webClientBuilder = WebClient.builder();
    //get client by id
    public Mono<Customer> getCustomer(String idCustomer){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/customer/{idCustomer}", idCustomer)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
