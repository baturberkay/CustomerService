package demo.microservice.controller;

import demo.microservice.entity.Customer;
import demo.microservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllProducts() {
        return customerService.findAll();
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/{id}")
    public Customer getAllProducts(@PathVariable Long id) {
        return customerService.findById(id);
    }

//    @PostMapping
//    public ResponseEntity<String> saveProduct(@RequestBody Customer product) {
    @PostMapping
    public ResponseEntity<String> saveProduct() {
//        Customer savedProduct = customerRepository.save(product);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedProduct.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("test");
        customer.setCustomerLimit(120L);
        return new ResponseEntity<>(customerService.save(customer).toString(), HttpStatus.ACCEPTED);
    }
}
