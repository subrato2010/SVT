// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="MetricsProcessHandler"
 */
public class MetricsProcessHandler  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String metricsProcessHandlerId;
    private int handlerNumber;
    private String methodName;
    private Metrics metrics; 

    /**
     * @hibernate.property
     * 
     */
    public int getHandlerNumber() {
        return handlerNumber;
    }
    public void setHandlerNumber(int handlerNumber) {
        this.handlerNumber = handlerNumber;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getMetricsProcessHandlerId() {
        return metricsProcessHandlerId;
    }
    public void setMetricsProcessHandlerId(String metricsProcessHandlerId) {
        this.metricsProcessHandlerId = metricsProcessHandlerId;
    }

    /**
     * @return Returns the Metrics.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="metricId" not-null="true"
     */
    public Metrics getMetrics() {
        return metrics;
    }
    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
