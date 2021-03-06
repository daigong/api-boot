package org.minbox.framework.api.boot.plugin.quartz.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;
import java.util.Date;

/**
 * Create a parameter wrapper class for a job
 *
 * @author 恒宇少年
 */
@Getter
@AllArgsConstructor
public class ApiBootJobWrapper implements Serializable {
    /**
     * Job unique key
     * Can operate jobs based on jobKey
     */
    @Setter
    private String jobKey;
    /**
     * Job execution class
     */
    private Class<? extends QuartzJobBean> jobClass;
    /**
     * Start execution time
     */
    private Date startAtTime;
    /**
     * Job execution params
     */
    private ApiBootJobParamWrapper param;

    /**
     * Get job start time
     * If {@link #startAtTime} is empty, the current time is used
     *
     * @return Job start time
     */
    public Date getStartAtTime() {
        return startAtTime == null ? new Date() : startAtTime;
    }
}
