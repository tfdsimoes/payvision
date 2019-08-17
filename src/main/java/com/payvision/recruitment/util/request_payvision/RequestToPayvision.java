package com.payvision.recruitment.util.request_payvision;

import com.payvision.recruitment.util.request_payvision.domain_payvision.PaymentPayvisionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Class with methods to make the request to payvision
 */
@Component
public class RequestToPayvision {
    private final Logger log = LoggerFactory.getLogger(RequestToPayvision.class);

    @Value("${payvision.username}")
    private String PAYVISION_USERNAME;

    @Value("${payvision.password}")
    private String PAYVISION_PASSWORD;

    @Value("${payvision.url}")
    private String PAYVISION_URL;

    @Value("${payvision.endpoint.payments}")
    private String PAYVISION_ENDPOINT_PAYMENTS;

    private final RestTemplate restTemplate;

    public RequestToPayvision(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Function that handles the http request to payvision to recover all the information
     *
     * @param action Type of transaction to filter
     * @param currencyCode Type of currency to filter
     * @return Object that represents the answer
     */
    public PaymentPayvisionDomain[] requestPaymentsFromPayvision(String action, String currencyCode) {
        log.info("Requesting information to payvision");

        boolean alreadyAdd = false;
        String urlFinal = PAYVISION_URL + PAYVISION_ENDPOINT_PAYMENTS ;

        if(Optional.ofNullable(action).isPresent()) {
            alreadyAdd = true;
            urlFinal = urlFinal + "?action=" + action;
        }

        if(Optional.ofNullable(currencyCode).isPresent()) {
            if (!alreadyAdd) {
                urlFinal = urlFinal + "?";
            } else {
                urlFinal = urlFinal + "&";
            }

            urlFinal = urlFinal + "currencyCode=" + currencyCode;
        }

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(PAYVISION_USERNAME, PAYVISION_PASSWORD));

        ResponseEntity<PaymentPayvisionDomain[]> answer = restTemplate.getForEntity(urlFinal, PaymentPayvisionDomain[].class);

        if (answer.getStatusCode() == HttpStatus.OK) {
            return answer.getBody();
        } else if(answer.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new IllegalStateException(String.format("Error connecting to Payvision (bad request %s)", answer.getStatusCode()));
        } else {
            throw new IllegalStateException(String.format("Error connecting to Payvision (status %s)", answer.getStatusCode()));
        }
    }
}
