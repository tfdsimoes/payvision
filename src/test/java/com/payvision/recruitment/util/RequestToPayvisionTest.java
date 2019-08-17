package com.payvision.recruitment.util;

import com.payvision.recruitment.RecruitmentApplication;
import com.payvision.recruitment.util.request_payvision.RequestToPayvision;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration test for class RequestToPayvision
 */
@SpringBootTest(classes = RecruitmentApplication.class)
public class RequestToPayvisionTest {

    @Autowired
    private RequestToPayvision requestToPayvision;

    @Test
    public void requestHttpError() {

    }

    @Test
    public void requestHttpOK() {

    }
}
