package id.my.hendisantika.crudcustomervaadin.ui;

import id.my.hendisantika.crudcustomervaadin.entity.Customer;
import id.my.hendisantika.crudcustomervaadin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.then;

/**
 * Created by IntelliJ IDEA.
 * Project : crud-customer-vaadin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/11/24
 * Time: 07.06
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class CustomerEditorTests {

    private static final String FIRST_NAME = "Monkey";
    private static final String LAST_NAME = "D. Luffy";

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerEditor editor;

    @Mock
    CustomerEditor.ChangeHandler changeHandler;

    @BeforeEach
    public void init() {
        editor.setChangeHandler(changeHandler);
    }

    @Test
    public void shouldStoreCustomerInRepoWhenEditorSaveClicked() {
        emptyCustomerWasSetToForm();

        this.editor.firstName.setValue(FIRST_NAME);
        this.editor.lastName.setValue(LAST_NAME);

        this.editor.save();

        then(this.customerRepository).should().save(argThat(customerMatchesEditorFields()));
    }

    @Test
    public void shouldDeleteCustomerFromRepoWhenEditorDeleteClicked() {
        customerDataWasFilled();

        editor.delete();

        then(this.customerRepository).should().delete(argThat(customerMatchesEditorFields()));
    }

    private void emptyCustomerWasSetToForm() {
        this.editor.editCustomer(new Customer());
    }

    private void customerDataWasFilled() {
        this.editor.editCustomer(new Customer(FIRST_NAME, LAST_NAME));
    }

    private ArgumentMatcher<Customer> customerMatchesEditorFields() {
        return customer -> FIRST_NAME.equals(customer.getFirstName()) && LAST_NAME.equals(customer.getLastName());
    }
}
