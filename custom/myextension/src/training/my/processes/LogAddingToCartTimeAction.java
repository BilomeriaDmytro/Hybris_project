package training.my.processes;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.time.TimeService;
import static de.hybris.platform.util.SingletonCreator.log;

public class LogAddingToCartTimeAction extends AbstractSimpleDecisionAction {

    private TimeService timeService;

    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel){
        log.info("New item was added to cart at " + timeService.getCurrentTime());
        return Transition.OK;
    }
}