package io.monster.ocs.cm.customer;

import io.monster.ocs.cm.customer.exception.ApplicationException;
import io.monster.ocs.cm.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SearchService {

    private final CustomerRepository customerRepository;
    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public SearchService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto findById(String id) {
        Optional<CustomerDocument> customerDocument = customerRepository.getByFirstName(id);
        if (customerDocument.isPresent()) {
            System.out.println(customerDocument.get());
            return customerMapper.toDto(customerDocument.get());
        }
        throw new ApplicationException(HttpStatus.NOT_FOUND);
    }

    public CustomerDto findByEmailAddress(String emailAddress) {
        CustomerDocument customerDocument = customerRepository.findByEmailAddress(emailAddress);
        if (customerDocument != null) {
            System.out.println(customerDocument);
            return customerMapper.toDto(customerDocument);
        }
        throw new ApplicationException(HttpStatus.NOT_FOUND);
    }

    public List<CustomerDto> findAll() {
        List<CustomerDocument> customerDocuments = (List<CustomerDocument>) customerRepository.findAll();
        return customerMapper.toDtoList(customerDocuments);
    }

    public List<CustomerDto> search(String key, String value) {
        List<CustomerDocument> customerDocuments = customerRepository.findByUsingQuery(key, value);
        if (customerDocuments.isEmpty()) {
            throw new ApplicationException(HttpStatus.NOT_FOUND);
        }
        return customerMapper.toDtoList(customerDocuments);
    }

}
