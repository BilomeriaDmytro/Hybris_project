package training.my.events;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.impex.jalo.Importer;
import de.hybris.platform.impex.jalo.imp.ImpExImportReader;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.util.CSVReader;
import org.junit.Before;
import org.junit.Test;
import javax.annotation.Resource;

@IntegrationTest
public class addToCartListenerTest extends ServicelayerTest {

    @Resource
    private ModelService modelService;

    @Resource
    private FlexibleSearchService flexibleSearchService;

    final private String IMPEX_FILE_PATH = "C:\\Users\\Dmitriy\\hybris-commerce\\hybris\\bin\\custom\\myextension\\testsrc\\test-impex\\orderServiceTest.impex";

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
    public void testOnEvent() {

        CartEntryModel cartEntryModel = new CartEntryModel();

        CartModel cartModel = (CartModel)flexibleSearchService.search("Select {pk} from {Cart} where {code} = 'cart1'").getResult().iterator().next();
        ProductModel productModel = (ProductModel)flexibleSearchService.search("Select {pk} from {Product} where {code} = 'car1'").getResult().iterator().next();
        UnitModel unitModel = (UnitModel)flexibleSearchService.search("Select {pk} from {Unit} where {code} = 'unit1'").getResult().iterator().next();

        cartEntryModel.setOrder(cartModel);
        cartEntryModel.setInfo("Cart entry");
        cartEntryModel.setProduct(productModel);
        cartEntryModel.setQuantity(10L);
        cartEntryModel.setUnit(unitModel);

        modelService.save(cartEntryModel);
    }
}