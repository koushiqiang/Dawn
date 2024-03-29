package com.neutrino.dawn.quartz.service;

import com.neutrino.dawn.quartz.model.SysJob;
import java.util.List;
import org.quartz.SchedulerException;

/**
 * Package: com.neutrino.dawn.quartz.service Description:定时任务调度信息 服务层
 * Date:  2020/5/23 12:50 Author: kousq
 * Modified By:
 */
public interface ISysJobService {
    /**
     * 获取quartz调度器的计划任务
     *
     * @param job 调度信息
     * @return 调度任务集合
     */
    List<SysJob> selectJobList(SysJob job);

    /**
     * 通过调度任务ID查询调度信息
     *
     * @param jobId 调度任务ID
     * @return 调度任务对象信息
     */
    SysJob selectJobById(Long jobId);

    /**
     * 暂停任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int pauseJob(SysJob job)throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param job 调度信息
     * @return 结果
     */
    int resumeJob(SysJob job)throws SchedulerException;

    /**
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param job 调度信息
     * @return 结果
     */
    int deleteJob(SysJob job)throws SchedulerException;

    /**
     * 批量删除调度信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    void deleteJobByIds(String ids)throws SchedulerException;

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     * @return 结果
     */
    int changeStatus(SysJob job)throws SchedulerException;

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     * @return 结果
     */
    void run(SysJob job)throws SchedulerException;

    /**
     * 新增任务表达式
     *
     * @param job 调度信息
     * @return 结果
     */
    int insertJobCron(SysJob job)throws SchedulerException;//, TaskException;

    /**
     * 更新任务的时间表达式
     *
     * @param job 调度信息
     * @return 结果
     */
    int updateJobCron(SysJob job)throws SchedulerException;//, TaskException;

    /**
     * 校验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return 结果
     */
    boolean checkCronExpressionIsValid(String cronExpression);
}
