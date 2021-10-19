package com.preNifi.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BillingList {

    private List<BillingDetail> billingDetails;


    @Override
    public String toString(){
        return billingDetails.toString();
    }

}
