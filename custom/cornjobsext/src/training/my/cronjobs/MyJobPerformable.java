package training.my.cronjobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import training.my.model.MyCronJobModel;
import training.my.service.MyOrderService;
import javax.annotation.Resource;
import static de.hybris.platform.util.SingletonCreator.log;

public class MyJobPerformable extends AbstractJobPerformable<MyCronJobModel> {

    @Resource
    private MyOrderService myOrderService;

    @Override
    public PerformResult perform(MyCronJobModel myCronJobModel) {

        String line = "Current number of orders - " + myOrderService.getTotalNumberOrders();
        log.info(line);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}