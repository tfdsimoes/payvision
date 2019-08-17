package com.payvision.recruitment.service;

import com.payvision.recruitment.RecruitmentApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration test for class PaymentService
 */
@SpringBootTest(classes = RecruitmentApplication.class)
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testGetPayments() {

    }
}
