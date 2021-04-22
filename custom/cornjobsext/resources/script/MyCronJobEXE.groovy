package script

cronJobService = spring.getBean("cronJobService");
fs = spring.getBean("flexibleSearchService");

query = "select {pk} from {CronJob} where {code} = 'myJobPerformable'"
result = fs.search(query);
for(item in result.getResult()){
    myCronJobModel = item;
}

cronJobService.performCronJob(myCronJobModel,true);