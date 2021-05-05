package training.my.processes;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.task.RetryLaterException;
import static de.hybris.platform.util.SingletonCreator.log;

public class CheckStatusAction extends AbstractSimpleDecisionAction{

    @Override
    public Transition executeAction(BusinessProcessModel businessProcessModel) throws RetryLaterException, Exception {
        log.info("Waiting for event.");
        return Transition.OK;
    }
}