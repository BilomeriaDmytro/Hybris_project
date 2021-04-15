package training.my.service.impl;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import training.my.repository.OrderRepository;
import training.my.service.MyOrderService;

public class MyDefaultOrderService implements MyOrderService {

    private OrderRepository orderRepository;

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public int getTotalNumberOrders() {
        return orderRepository.findNumberOfOrders();
    }

    @Override
    public OrderModel getLastOrder() { return orderRepository.getLastOrder(); }

    @Override
    public UserModel getUserWithMostOrders() {
        return orderRepository.getUserWithMostOrders();
    }
}
