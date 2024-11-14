package id.my.hendisantika.crudcustomervaadin.ui;

import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.server.VaadinRequest;
import id.my.hendisantika.crudcustomervaadin.entity.Customer;
import id.my.hendisantika.crudcustomervaadin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Created by IntelliJ IDEA.
 * Project : crud-customer-vaadin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/11/24
 * Time: 07.08
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest(classes = MainViewTests.Config.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MainViewTests {

    @Autowired
    CustomerRepository repository;

    VaadinRequest vaadinRequest = Mockito.mock(VaadinRequest.class);

    CustomerEditor editor;

    MainView mainView;

    @BeforeEach
    public void setup() {
        this.editor = new CustomerEditor(this.repository);
        this.mainView = new MainView(this.repository, editor);
    }

    @Test
    public void shouldInitializeTheGridWithCustomerRepositoryData() {
        int customerCount = (int) this.repository.count();

        then(mainView.grid.getColumns()).hasSize(3);
        then(getCustomersInGrid()).hasSize(customerCount);
    }

    private List<Customer> getCustomersInGrid() {
        ListDataProvider<Customer> ldp = (ListDataProvider) mainView.grid.getDataProvider();
        return new ArrayList<>(ldp.getItems());
    }

    @Test
    public void shouldFillOutTheGridWithNewData() {
        int initialCustomerCount = (int) this.repository.count();

        customerDataWasFilled(editor, "Monkey", "D. Luffy");

        this.editor.save();

        then(getCustomersInGrid()).hasSize(initialCustomerCount + 1);

        then(getCustomersInGrid().get(getCustomersInGrid().size() - 1))
                .extracting("firstName", "lastName")
                .containsExactly("Monkey", "D. Luffy");

    }

    @Test
    public void shouldFilterOutTheGridWithTheProvidedLastName() {
        this.repository.save(new Customer("Josh", "Long"));

        mainView.listCustomers("Long");

        then(getCustomersInGrid()).hasSize(1);
        then(getCustomersInGrid().get(getCustomersInGrid().size() - 1))
                .extracting("firstName", "lastName")
                .containsExactly("Josh", "Long");
    }

    @Test
    public void shouldInitializeWithInvisibleEditor() {
        then(this.editor.isVisible()).isFalse();
    }

    @Test
    public void shouldMakeEditorVisible() {
        Customer first = getCustomersInGrid().get(0);
        this.mainView.grid.select(first);

        then(this.editor.isVisible()).isTrue();
    }
}
