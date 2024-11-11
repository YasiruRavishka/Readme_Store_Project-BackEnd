package edu.icet.service.impl;

import edu.icet.dto.OrderItem;
import edu.icet.dto.User;
import edu.icet.entity.BookEntity;
import edu.icet.entity.OrderEntity;
import edu.icet.entity.OrderItemEntity;
import edu.icet.repository.BookDao;
import edu.icet.repository.OrderDao;
import edu.icet.repository.UserDao;
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
    private final UserDao userRepository;
    private final ModelMapper mapper;

    @Override
    public void placeOrder(User user, List<OrderItem> items) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Book not found")));
        orderEntity.setDate(LocalDate.now());

        double total = 0;
        List<OrderItemEntity> orderItems = new ArrayList<>();
        for (OrderItem item : items) {
            BookEntity bookEntity = bookRepository.findById(item.getBook().getId()).orElseThrow(() -> new RuntimeException("Book not found"));
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setBook(bookEntity);
            orderItemEntity.setQty(item.getQty());
            orderItemEntity.setPrice(bookEntity.getPrice() * item.getQty());
            orderItemEntity.setOrder(orderEntity);
            orderItems.add(orderItemEntity);
            total += orderItemEntity.getPrice();
        }

        orderEntity.setOrderItems(orderItems);
        orderEntity.setTotal(total);
        orderRepository.save(orderEntity);
    }
}
