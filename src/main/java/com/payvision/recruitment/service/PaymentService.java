package com.payvision.recruitment.service;

import com.payvision.recruitment.util.ConverterBrandIdToBrandName;
import com.payvision.recruitment.util.request_payvision.RequestToPayvision;
import com.payvision.recruitment.util.request_payvision.domain_payvision.PaymentPayvisionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service that handles the communication
 */
@Service
public class PaymentService {
    private final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final RequestToPayvision requestToPayvision;

    public PaymentService(
            RequestToPayvision requestToPayvision
    ) {
        this.requestToPayvision = requestToPayvision;
    }

    /**
     * Service responsible to get the payments from payvision and to convert brandId to brandName
     *
     * @param action Type of transaction to filter
     * @param currencyCode Type of currency to filter
     * @return Object with information to the frontend
     */
    public PaymentPayvisionDomain[] getPayments(String action, String currencyCode) {
        log.info("Getting information of payments");

        return convertBrandIdToBrandName(requestToPayvision.requestPaymentsFromPayvision(action, currencyCode));
    }

    /**
     * Convert brandIds to brandNames
     *
     * @param paymentPayvisionDomains array of PaymentPayvisionDomain
     * @return array of PaymentPayvisionDomain with brandName inserted
     */
    private PaymentPayvisionDomain[] convertBrandIdToBrandName(PaymentPayvisionDomain[] paymentPayvisionDomains) {

        for(int i=0; i<paymentPayvisionDomains.length; i++) {
            paymentPayvisionDomains[i].setBrandName(ConverterBrandIdToBrandName.convertBrandIdToBrandName(paymentPayvisionDomains[i].getBrandId()));
        }

        return paymentPayvisionDomains;
    }
}
