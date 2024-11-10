package edu.icet.service.impl;

import edu.icet.dto.OrderItem;
import edu.icet.dto.User;
import edu.icet.entity.BookEntity;
import edu.icet.entity.OrderEntity;
import edu.icet.entity.OrderItemEntity;
import edu.icet.entity.UserEntity;
import edu.icet.repository.BookDao;
import edu.icet.repository.OrderDao;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderRepository;
    private final BookDao bookRepository;
    private final ModelMapper mapper;

    @Override
    public void placeOrder(User user, List<OrderItem> items) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(mapper.map(user, UserEntity.class));
        orderEntity.setDate(LocalDate.now());

        double total = 0;
        List<OrderItemEntity> orderItems = new ArrayList<>();
        for (OrderItem item : items) {
            BookEntity bookEntity = bookRepository.findById(item.getId()).orElseThrow(() -> new RuntimeException("Book not found"));
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setBook(bookEntity);
            orderItemEntity.setQuantity(item.getQuantity());
            orderItemEntity.setPrice(bookEntity.getPrice() * item.getQuantity());
            orderItems.add(orderItemEntity);
            total += orderItemEntity.getPrice();
        }
        orderEntity.setOrderItems(orderItems);
        orderEntity.setTotal(total);
        orderRepository.save(orderEntity);
    }
}
