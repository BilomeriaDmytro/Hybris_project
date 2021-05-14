package training.my.repository;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import groovy.util.logging.Slf4j;
import java.util.Collections;
import java.util.List;

@Slf4j
public class OrderRepository {

    private FlexibleSearchService flexibleSearchService;

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService){
        this.flexibleSearchService = flexibleSearchService;
    }

    public OrderModel getLastOrder(){

        String query = "Select top 1 "+ OrderModel.PK +" from {Order} order by {date} desc";
        SearchResult<OrderModel> result = flexibleSearchService.search(query);
        OrderModel orderModel = result.getResult().iterator().next();

        return orderModel;
    }

    public int findNumberOfOrders(){

        String query = "Select count(1) from {Order}";
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(Integer.class));
        SearchResult<Integer> queryResult = flexibleSearchService.search(flexibleSearchQuery);
        int integer = queryResult.getResult().get(0);

        return integer;
    }

    public UserModel getUserWithMostOrders(){

        String orderQuery = "select top 1 P_user from (select P_user, count(P_user) from {Order as o} group by P_user order by count(P_user) desc)";
        SearchResult<UserModel> orderQueryResult = flexibleSearchService.search(orderQuery);
        UserModel userModel = orderQueryResult.getResult().get(0);

        return userModel;
    }
}
