/**
 * @author mylg
 * @date 2021-07-20
 */
package com.mylg.study.drools.banking.data.model;

import java.util.Date;

public class CashFlowNew {
    private int type;

    private long accountNo;

    private Date date;

    private double amount;

    public CashFlowNew(Date date, int type, double amount, long accountNo) {
        this.type      = type;
        this.accountNo = accountNo;
        this.date      = date;
        this.amount    = amount;
    }
}
