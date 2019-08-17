package com.payvision.recruitment.util.request_payvision.domain_payvision;

/**
 * Class that represents the Payment received by payvision and one returned to the frontend
 */
public class PaymentPayvisionDomain {
    private String action;
    private Float amount;
    private Integer brandId;
    private String brandName;
    private CardPayvisionDomain card;
    private String currencyCode;
    private String id;
    private String trackingCode;

    public PaymentPayvisionDomain() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CardPayvisionDomain getCard() {
        return card;
    }

    public void setCard(CardPayvisionDomain card) {
        this.card = card;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }
}
