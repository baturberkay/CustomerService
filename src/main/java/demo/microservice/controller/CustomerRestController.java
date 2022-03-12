package demo.microservice.controller;

import demo.microservice.TopicNamesEnum;
import demo.microservice.entity.Customer;
import demo.microservice.kafka.producer.Producer;
import demo.microservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerService customerService;

    private final Producer producer;

    public CustomerRestController(CustomerService customerService, Producer producer) {
        this.customerService = customerService;
        this.producer = producer;
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

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer() {
        Customer customer = new Customer();
        customer.setName("test");
        customer.setCustomerLimit(120L);
        Customer savedCustomer = customerService.save(customer);
        producer.send(TopicNamesEnum.CUSTOMER_REPLY.getValue(), String.valueOf(savedCustomer.getId()));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
