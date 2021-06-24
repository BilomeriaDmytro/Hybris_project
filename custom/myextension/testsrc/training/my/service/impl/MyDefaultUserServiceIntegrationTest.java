package training.my.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.impex.jalo.Importer;
import de.hybris.platform.impex.jalo.imp.ImpExImportReader;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.util.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.my.service.MyUserService;
import javax.annotation.Resource;

@IntegrationTest
public class MyDefaultUserServiceIntegrationTest extends ServicelayerTest {

    @Resource
    private MyUserService myUserService;

    final private String IMPEX_FILE_PATH = "C:\\Users\\Dmitriy\\hybris-commerce\\hybris\\bin\\custom\\myextension\\testsrc\\training\\my\\service\\impl\\test-impex\\userServiceTest.impex";

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
    public void testGetNumberOfUsers() {

        int ordersNumber = myUserService.getNumberOfUsers();
        Assert.assertEquals(4,ordersNumber);
    }
}