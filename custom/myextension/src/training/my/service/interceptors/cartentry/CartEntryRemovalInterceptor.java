package training.my.service.interceptors.cartentry;

import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;
import javax.annotation.Resource;

public class CartEntryRemovalInterceptor implements  RemoveInterceptor<CartEntryModel> {

    @Resource
    private BusinessProcessService businessProcessService;

    @Override
    public void onRemove(CartEntryModel cartEntryModel, InterceptorContext interceptorContext){

        System.out.println("Triggering event cart entry removal");
        //BusinessProcessEvent event = BusinessProcessEvent.builder("event").withChoice(cartEntryModel.getPk().toString() + "_addedToCart_CartEntryRemoval").build();
        businessProcessService.triggerEvent(cartEntryModel.getPk().toString() + "_addedToCart_CartEntryRemoval");
    }
}