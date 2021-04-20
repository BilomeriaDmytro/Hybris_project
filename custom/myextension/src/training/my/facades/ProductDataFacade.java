package training.my.facades;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;

public interface ProductDataFacade {

    ProductData getProductData(ProductModel productModel);
}
