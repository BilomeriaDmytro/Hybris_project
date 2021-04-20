package training.my.events;

import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.servicelayer.event.events.AfterItemCreationEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

import static de.hybris.platform.util.SingletonCreator.log;

public class addToCartListener extends AbstractEventListener<AfterItemCreationEvent>{

    private ModelService modelService;

    public void setModelService(final ModelService modelService)
    {
        this.modelService = modelService;
    }

    @Override
    protected void onEvent(final AfterItemCreationEvent event)
    {
        if (event != null && event.getSource() != null)
        {
            final Object object = modelService.get(event.getSource());
            if (object instanceof CartEntryModel)
            {
                CartEntryModel cartEntryModel = (CartEntryModel) object;
                log.info("Cart entry instance was created with pk - " + cartEntryModel.getPk() + ".");
                log.info(cartEntryModel.getInfo());
            }
        }
    }
}
