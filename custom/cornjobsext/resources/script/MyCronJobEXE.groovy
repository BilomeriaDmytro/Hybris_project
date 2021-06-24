package script

cronJobService = spring.getBean("cronJobService");
fs = spring.getBean("flexibleSearchService");

////// execute cron job that logs amount of orders

query = "select {pk} from {CronJob} where {code} = 'myJobPerformable'"
result = fs.search(query);
for(item in result.getResult()){
    myCronJobModel = item;
}
cronJobService.performCronJob(myCronJobModel,true);

////// execute cron job that logs amount of users

query = "select {pk} from {CronJob} where {code} = 'countOfUsersJobPerformable'"
result = fs.search(query);
for(item in result.getResult()){
    countOfUsersCronJobModel = item;
}
cronJobService.performCronJob(countOfUsersCronJobModel,true);

////// execute composite cron job that logs amount of users and orders

query = "select {pk} from {CompositeCronJob} where {code} = 'compositeCronJob'"
result = fs.search(query);
for(item in result.getResult()){
    countOfUsersCronJobModel = item;
}
cronJobService.performCronJob(countOfUsersCronJobModel,true);