package id.my.hendisantika.crudcustomervaadin.ui;

import id.my.hendisantika.crudcustomervaadin.entity.Customer;
import id.my.hendisantika.crudcustomervaadin.repository.CustomerRepository;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * Project : crud-customer-vaadin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/11/24
 * Time: 06.08
 * To change this template use File | Settings | File Templates.
 */
@Route
public class MainView extends VerticalLayout {

    final Grid<Customer> grid;
    final TextField filter;
    private final CustomerRepository repo;
    private final CustomerEditor editor;
    private final Button addNewBtn;
}
