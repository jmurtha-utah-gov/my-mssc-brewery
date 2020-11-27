package guru.springframework.mymsscbrewery.web.service;

import guru.springframework.mymsscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
}
