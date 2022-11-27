package com.example.storeproject.service;


import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;
import com.example.storeproject.entity.Product;
import com.example.storeproject.exeption.OrderProductNotEnoughProductException;
import com.example.storeproject.repository.OrderProductRepository;
import com.example.storeproject.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProductServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @MockBean
    OrderProductRepository orderProductRepository;
    @MockBean
    ProductRepository productRepository;
    @Autowired
    OrderProductService orderProductService;

    @Test
    public void testCreateOrderProduct() {
        // given
        List<OrderProductCreatRequestDto> orderProductRequestArray = new ArrayList<>();
        orderProductRequestArray.add(new OrderProductCreatRequestDto(1L, 2));
        Long orderId = 1L;
        List<Product> productFromDBArray = new ArrayList<>();
        Product product = new Product(1L, "Машинка", true, 100.02, 5);
        product.setId(1L);
        productFromDBArray.add(product);
        double expectedCost = 200.04;

        when(productRepository.findAll()).thenReturn(productFromDBArray);

        //when
        double actualCost = orderProductService.createOrderProduct(orderId, orderProductRequestArray);
        // then
        Assert.assertEquals(expectedCost, actualCost, 0.00);
    }

    @Test
    public void testCreateOrderProductThrowNotEnoughProductException() {
        // given
        List<OrderProductCreatRequestDto> orderProductRequestArray = new ArrayList<>();
        orderProductRequestArray.add(new OrderProductCreatRequestDto(1L, 6));
        Long orderId = 1L;
        List<Product> productFromDBArray = new ArrayList<>();
        Product product = new Product(1L, "Машинка", true, 100.02, 5);
        product.setId(1L);
        productFromDBArray.add(product);
        double expectedCost = 200.04;

        when(productRepository.findAll()).thenReturn(productFromDBArray);

        //when
        thrown.expect(OrderProductNotEnoughProductException.class);
        double actualCost = orderProductService.createOrderProduct(orderId, orderProductRequestArray);
        // then
        Assert.assertEquals(expectedCost, actualCost, 0.00);
    }
}