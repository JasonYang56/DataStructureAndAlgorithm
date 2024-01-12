package com.atguigu.json;


import java.io.Serializable;

/**
 * <p>
 * 积分等级表
 * </p>
 *
 * @author Jason
 * @since 2022-10-30
 */
public class IntegralGrade implements Serializable {


    /**
     * id : 2
     * integralStart : 51
     * integralEnd : 100
     * borrowAmount : 30000
     * createTime : 2020-12-08 17:02:42
     * updateTime : 2022-11-05 11:14:24
     * deleted : false
     */

    private int id;
    private int integralStart;
    private int integralEnd;
    private int borrowAmount;
    private String createTime;
    private String updateTime;
    private boolean deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntegralStart() {
        return integralStart;
    }

    public void setIntegralStart(int integralStart) {
        this.integralStart = integralStart;
    }

    public int getIntegralEnd() {
        return integralEnd;
    }

    public void setIntegralEnd(int integralEnd) {
        this.integralEnd = integralEnd;
    }

    public int getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(int borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "IntegralGrade{" +
                "id=" + id +
                ", integralStart=" + integralStart +
                ", integralEnd=" + integralEnd +
                ", borrowAmount=" + borrowAmount +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
