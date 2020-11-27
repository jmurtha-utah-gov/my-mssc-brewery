package guru.springframework.mymsscbrewery.web.service;

import guru.springframework.mymsscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
            .name("Best Customer Ever")
            .build();
    }
}
