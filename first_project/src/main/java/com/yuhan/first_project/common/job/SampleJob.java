package com.yuhan.first_project.common.job;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job{

    // 실제 작업이 실행 될 메서드
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Scheduler!!"); //작업 작성
    }
    
    // job Detail 설정 (job의 메타데이터)
    @Bean //bean으로 등록
    public JobDetail JobDetail(){
        return JobBuilder.newJob()
        .ofType(SampleJob.class)
        .storeDurably()
        .withIdentity("Sample Job")
        .withDescription("Sameple Job 테스트입니다.")
        .build();
    }
    // Trigger 설정 (반복할 스케줄 지정)
    @Bean   //Bean으로 등록해줘야 스프링이 읽는다..
    public Trigger trigger(JobDetail jobDetail){
        CronScheduleBuilder schedule = 
        CronScheduleBuilder.cronSchedule("* * * * * ?"); // 매초마다 실행

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("Sample Trigger")
                .withDescription("Sample Trigger 입니다.")
                .withSchedule(schedule)
                .build();
    }

}
