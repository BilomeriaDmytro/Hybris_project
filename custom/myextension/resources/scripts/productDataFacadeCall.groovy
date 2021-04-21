package scripts

defaultProductDataFacade = spring.getBean("defaultProductDataFacade");
modelService = spring.getBean("modelService");
flexibleSearchService = spring.getBean("flexibleSearchService");

query = "select {pk} from {Product} where {code} = 'car1'";
result = flexibleSearchService.search(query);

for (item in result.getResult()) {
    pk = item.getPk();
}

object = modelService.get(pk)

productData = defaultProductDataFacade.getProductData(object);
println productData.getCodePk();