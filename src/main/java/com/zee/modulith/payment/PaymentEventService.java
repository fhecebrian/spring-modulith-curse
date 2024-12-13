package com.zee.modulith.payment;

import com.zee.modulith.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventService {

    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on(final OrderPaymentDto paymentDto) {
        log.info("Order payment received in listener: {}", paymentDto);

        Payment payment = new Payment();
        payment.setOrderId(paymentDto.orderId());
        payment.setAmount(paymentDto.amount());
        paymentRepository.save(payment);
    }

//    @ApplicationModuleListener
//    void completeOrder(final CompleteOrder completeOrder) {
//
//        log.info("Complete order received in listener: {}", completeOrder);
//
//        Optional<Payment> optionalPayment = paymentRepository.getPaymentsByOrderId(completeOrder.orderIdentifier());
//
//        if (optionalPayment.isPresent()) {
//            Payment payment = optionalPayment.get();
//            payment.setStatus(PaymentStatus.COMPLETED);
//            paymentRepository.save(payment);
//        }
//    }
}