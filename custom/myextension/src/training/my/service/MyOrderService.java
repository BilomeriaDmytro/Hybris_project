package training.my.service;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.order.Order;
import de.hybris.platform.jalo.user.User;

public interface MyOrderService {

    int getTotalNumberOrders();

    OrderModel getLastOrder();

    UserModel getUserWithMostOrders();
}
