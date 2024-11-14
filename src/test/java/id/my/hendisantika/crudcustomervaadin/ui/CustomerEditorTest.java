package id.my.hendisantika.crudcustomervaadin.ui;

import id.my.hendisantika.crudcustomervaadin.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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
public class CustomerEditorTests {

    private static final String FIRST_NAME = "Marcin";
    private static final String LAST_NAME = "Grzejszczak";

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

}
