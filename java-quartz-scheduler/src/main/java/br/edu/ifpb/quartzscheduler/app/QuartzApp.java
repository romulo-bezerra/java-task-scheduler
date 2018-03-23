/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.quartzscheduler.app;

import br.edu.ifpb.quartzscheduler.service.ValidadorJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author romulo
 */
public class QuartzApp {

    public static void main(String[] args) {
        
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(ValidadorJob.class)
                    .withIdentity("validadorJOB", "grupo01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("validadorTRIGGER", "grupo01")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
    }

}
