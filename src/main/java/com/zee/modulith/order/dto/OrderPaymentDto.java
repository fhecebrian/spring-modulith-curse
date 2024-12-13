package com.zee.modulith.order.dto;

import org.jmolecules.event.types.DomainEvent;

//@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {
}