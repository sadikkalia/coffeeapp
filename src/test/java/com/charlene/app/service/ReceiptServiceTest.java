package com.charlene.app.service;

import com.charlene.app.utils.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptServiceTest {

    private static ReceiptService receiptService;

    @BeforeAll
    public static void beforeAll() {
        receiptService = new ReceiptServiceImpl();
    }

    @Test
    void createReceiptTest() {
        String receipt = receiptService.createReceipt(TestUtils.createOrder());

        assertNotNull(receipt);
        assertEquals("Charlene's Coffee Shop\n" +
                "--------------------------------\n" +
                "Item              Qty      Price\n" +
                "----              ---      -----\n" +
                "large coffee        1       3.50\n" +
                "extra milk          1       0.30\n" +
                "medium coffee       1       3.00\n" +
                "--------------------------------\n" +
                "Total                  6.80  CHF\n", receipt);
    }

}