package training.my.facades.populator;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

public class ProductPopulator implements Populator<ProductModel, ProductData> {


    private final String codePkConnector = "_";

    @Override
    public void populate(ProductModel productModel, ProductData productData)
            throws ConversionException {

        String codePk = productModel.getCode() + codePkConnector + productModel.getPk();
        productData.setCodePk(codePk);
    }
}
