package demo.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    private long id;
    private String name;
    private String description;
    private Long customerLimit;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerLimit() {
        return customerLimit;
    }

    public void setCustomerLimit(Long customerLimit) {
        this.customerLimit = customerLimit;
    }
}