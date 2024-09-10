package com.hisistant.auth.service;

import com.hisistant.auth.domain.*;
import com.hisistant.auth.dto.CategoryDTO;
import com.hisistant.auth.dto.MenuDTO;
import com.hisistant.auth.dto.OrderDTO;
import com.hisistant.auth.dto.OrderItemDTO;
import com.hisistant.auth.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> getCategories(Long user_id){
        List<MenuCategory> categories = menuCategoryRepository.findByUserId(user_id);
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for(MenuCategory category : categories){
            categoriesDTO.add(CategoryDTO.builder()
                    .id(category.id)
                    .name(category.name)
                    .build());
        }
        return categoriesDTO;
    }

    public List<MenuDTO> getCategoryMenu(Long user_id, Long category_id) {
        List<Menu> menus = menuRepository.findByUserIdAndCategoryId(user_id, category_id);
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for(Menu menu : menus){
            menuDTOList.add(modelMapper.map(menu, MenuDTO.class));
        }
        return menuDTOList;
    }

    public Order confirmOrder(Long user_id, OrderDTO orderDTO) {
        Order order = Order.builder()
                .user_id(user_id)
                .order_date(LocalDateTime.now())
                .payment_amount(orderDTO.getPayment_amount())
                .build();

        order = orderRepository.save(order);

        List<OrderItemDTO> orderItems = orderDTO.getOrder_items();
        for(OrderItemDTO orderItem : orderItems){
            OrderItem item = OrderItem.builder()
                    .menuId(orderItem.getId())
                    .qty(orderItem.getQty())
                    .orderId(order.getId())
                    .build();
            orderItemRepository.save(item);
        }

        return order;
    }
}
