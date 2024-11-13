package id.my.hendisantika.crudcustomervaadin.repository;

import id.my.hendisantika.crudcustomervaadin.entity.Customer;

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
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}
