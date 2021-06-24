package training.my.cronjobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import training.my.model.CountOfUsersCronJobModel;
import training.my.service.MyUserService;
import javax.annotation.Resource;
import static de.hybris.platform.util.SingletonCreator.log;

public class CountOfUsersJobPerformable extends AbstractJobPerformable<CountOfUsersCronJobModel> {

    @Resource
    private MyUserService myUserService;

    @Override
    public PerformResult perform(CountOfUsersCronJobModel countOfUsersCronJobModel) {

        String line = "Current number of users - " + myUserService.getNumberOfUsers();
        log.info(line);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}