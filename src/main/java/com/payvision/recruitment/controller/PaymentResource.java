package com.payvision.recruitment.controller;

import com.payvision.recruitment.service.PaymentService;
import com.payvision.recruitment.util.request_payvision.domain_payvision.PaymentPayvisionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the resource of payment
 */
@RestController
@CrossOrigin(origins = "*")
public class PaymentResource {
    private final Logger log = LoggerFactory.getLogger(PaymentResource.class);

    private final PaymentService paymentService;

    public PaymentResource(
            PaymentService paymentService
    ) {
        this.paymentService = paymentService;
    }

    /**
     * Controller to get all the payments form payvision
     *
     * @return String with the json
     */
    @GetMapping(value = "/payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentPayvisionDomain[]> getPayments(
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String currencyCode
            ) {
        log.info("REST request for payments");

        return ResponseEntity.ok(paymentService.getPayments(action, currencyCode));
    }
}
