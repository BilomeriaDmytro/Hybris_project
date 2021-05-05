package training.my.events;

import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.events.AfterItemCreationEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

public class addToCartUpgradedListener extends AbstractEventListener<AfterItemCreationEvent> {

    private BusinessProcessService businessProcessService;

    private ModelService modelService;

    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    protected void onEvent(AfterItemCreationEvent afterItemCreationEvent) {

        if (afterItemCreationEvent != null && afterItemCreationEvent.getSource() != null)
        {
            final Object object = modelService.get(afterItemCreationEvent.getSource());
            if (object instanceof CartEntryModel)
            {
                CartEntryModel cartEntryModel = (CartEntryModel) object;
                String processCode = cartEntryModel.getPk().toString() + "_addedToCart";
                businessProcessService.startProcess(processCode,"addedToCartProcess");
            }
        }
    }
}