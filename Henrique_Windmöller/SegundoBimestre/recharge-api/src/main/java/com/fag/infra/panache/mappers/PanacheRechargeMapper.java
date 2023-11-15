package main.java.com.fag.infra.panache.mappers;

import main.java.com.fag.domain.entities.RechargeBO;

public class PanacheRechargeMapper {
    

    public static RechargeBO toDomain(PanacheRecharge entity){
        Integer countryCode = Integer.valueOf(entity.getPhoneNUmber().substring(0,2));
        Integer stateCode = Integer.valueOf(entity.getPhoneNumber().substring(2,4));
        String number = entity.getPhoneNumber().substring(4, entity.getPhoneNumber().length());

        return new RechargeBO(
            entity.getId(),
            entity.getValue(),
            entity.getDocument(),
            entity.getOperatorId(),
            new PhoneBO(countryCode, stateCode, number),
            entity.getReceipt(),
            entity.getTransactionId(),
            entity.isSuccess());
    }

    public static PanacheRecharge toEntity(RechargeBO bo){
        PanacheRecharge entity = new PanacheRecharge();
        String phone = bo.getPhone().getCountryCode().toString()
            .concat(bo.getPhone().getStateCode().toString())
            .concat(bo.getPhone().getNumber());
        
        entity.setId(bo.getId());
        entity.setValue(bo.getValue());
        entity.setDocument(bo.getDocument());
        entity.setOperatorId(bo.getProviderId());
        entity.setPhoneNumber(phone);
        entity.setReceipt(bo.getReceipt());
        entity.setTransactionId(bo.getTransactionId());
        entity.setSuccess(bo.isSuccess());

        return entity;
    }
}
