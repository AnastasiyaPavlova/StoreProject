package com.example.storeproject.repository;

import com.example.storeproject.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSavingRoundTrip(){
        // given
        Customer customer = new Customer("Имя1", "Фамилия1", "email1", "телефон1", "Адрес1", "логин1", "пароль1");

        // when
        Customer result = customerRepository.save(customer);

        // then
        assertNotNull(result);
    }

}