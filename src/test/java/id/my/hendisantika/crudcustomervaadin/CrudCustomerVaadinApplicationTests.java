package id.my.hendisantika.crudcustomervaadin;

import id.my.hendisantika.crudcustomervaadin.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(classes = CrudCustomerVaadinApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class CrudCustomerVaadinApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void shouldFillOutComponentsWithDataWhenTheApplicationIsStarted() {
        then(this.repository.count()).isEqualTo(5);
    }

}
