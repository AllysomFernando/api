package com.fag.infra.celcoin.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class CelcoinPixResponse {
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    private Long transactionId;
    @JsonbProperty(value = "emvqrcps")
    private String qrCode;
}
