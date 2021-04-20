package training.my.facades.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import training.my.facades.ProductDataFacade;

import static training.my.facades.populators.productdata.ProductDataPopulator.getProductDataConverter;

public class DefaultProductDataFacade implements ProductDataFacade {

    @Override
    public ProductData getProductData(ProductModel productModel){
       return getProductDataConverter().convert(productModel);
    }

}
