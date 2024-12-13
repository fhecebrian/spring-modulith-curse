package com.zee.modulith.order;

import com.zee.modulith.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeOrder(final OrderPaymentDto orderPaymentDto) {

        log.info("Completing order payment with details{}", orderPaymentDto);
        eventPublisher.publishEvent(orderPaymentDto);

//        log.info("Sending email for order {}", emailDto);
//        eventPublisher.publishEvent(emailDto);
    }

//    @Transactional
//    public void completePayment(CompleteOrder completeOrder, EmailDto emailDto) {
//        log.info("Attempting to complete payment {}", completeOrder);
//        eventPublisher.publishEvent(completeOrder);
//
//        log.info("Completed payment Email {}", emailDto);
//        eventPublisher.publishEvent(emailDto);
//    }
}