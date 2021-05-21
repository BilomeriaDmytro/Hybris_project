package training.my.repository;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.Collections;

@UnitTest
public class OrderRepUnitT {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private FlexibleSearchService flexibleSearchService;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private SearchResult searchResult;

    @InjectMocks
    private OrderRepository orderRepository;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        orderRepository.setFlexibleSearchService(flexibleSearchService);
    }

    @Test
    public void GetLastOrder() {

        String query = "Select top 1 "+ OrderModel.PK +" from {Order} order by {date} desc";
        OrderModel orderModel = new OrderModel();

        Mockito.when(flexibleSearchService.search(query)).thenReturn(searchResult);
        Mockito.when(searchResult.getResult().iterator().next()).thenReturn(orderModel);

        Assert.assertEquals(orderRepository.getLastOrder(),orderModel);
    }

    @Test
    public void testFindNumberOfOrders() {

        String query = "Select count(1) from {Order}";
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);
        flexibleSearchQuery.setResultClassList(Collections.singletonList(Integer.class));

        Mockito.when(flexibleSearchService.search(flexibleSearchQuery)).thenReturn(searchResult);
        Mockito.when(searchResult.getResult().get(0)).thenReturn(2);

        Assert.assertEquals(orderRepository.findNumberOfOrders(),2);
    }

    @Test
    public void testGetUserWithMostOrders() {

        String query = "select top 1 P_user from (select P_user, count(P_user) from {Order as o} group by P_user order by count(P_user) desc)";
        UserModel userModel = new UserModel();

        Mockito.when(flexibleSearchService.search(query)).thenReturn(searchResult);
        Mockito.when(searchResult.getResult().get(0)).thenReturn(userModel);

        Assert.assertEquals(orderRepository.getUserWithMostOrders(),userModel);
    }
}