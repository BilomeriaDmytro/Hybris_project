package training.my.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.impex.jalo.Importer;
import de.hybris.platform.impex.jalo.imp.ImpExImportReader;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.util.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.my.service.MyOrderService;
import javax.annotation.Resource;

@IntegrationTest
public class MyDefaultOrderServiceTest extends ServicelayerTest {

    @Resource
    private MyOrderService myOrderService;

    final private String IMPEX_FILE_PATH = "C:\\Users\\Dmitriy\\hybris-commerce\\hybris\\bin\\custom\\myextension\\testsrc\\training\\my\\service\\impl\\test-impex\\orderServiceTest.impex";

    @Before
    public void setup()
            throws Exception {

        CSVReader csvReader = new CSVReader(IMPEX_FILE_PATH, "utf-8");
        ImpExImportReader impExImportReader = new ImpExImportReader(csvReader);
        Importer importer = new Importer(impExImportReader);
        importer.importAll();
        importer.getProcessedItemsCountOverall();
    }

    @Test
    public void getTotalNumberOrders() {

        int ordersNumber = myOrderService.getTotalNumberOrders();
        Assert.assertEquals(3,ordersNumber);
    }

    @Test
    public void getLastOrder() {

        OrderModel lastOrder = myOrderService.getLastOrder();
        Assert.assertEquals("order3",lastOrder.getCode());
    }

    @Test
    public void getUserWithMostOrders() {

        UserModel user = myOrderService.getUserWithMostOrders();
        Assert.assertEquals(user.getName(),"employee2");
        Assert.assertEquals(user.getOrders().size(),2);
    }
}