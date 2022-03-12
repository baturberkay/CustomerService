package demo.microservice;

public enum TopicNamesEnum {

    CUSTOMER_REPLY("customer-reply"),
    ORDER_CREATED("order-created");

    private final String value;

    TopicNamesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
