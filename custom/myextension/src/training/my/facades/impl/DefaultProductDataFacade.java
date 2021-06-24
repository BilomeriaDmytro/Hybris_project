package training.my.facades.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;
import training.my.facades.ProductDataFacade;
import training.my.model.CarProductModel;

public class DefaultProductDataFacade implements ProductDataFacade {

    private Converter<ProductModel, ProductData> productConverter;

    @Override
    public ProductData getProductData(ProductModel productModel){
       return getProductConverter().convert(productModel);
    }

    public Converter<ProductModel, ProductData> getProductConverter(){
        return productConverter;
    }

    @Required
    public void setProductConverter(Converter<ProductModel, ProductData> productConverter) {
        this.productConverter = productConverter;
    }
}