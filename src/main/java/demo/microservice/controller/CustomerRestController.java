package demo.microservice.controller;

import demo.microservice.entity.Customer;
import demo.microservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllProducts() {
        return customerRepository.findAll();
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/{id}")
    public Customer getAllProducts(@PathVariable String id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot Find Product By ID: " + id));
    }

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody Customer product) {
        Customer savedProduct = customerRepository.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
