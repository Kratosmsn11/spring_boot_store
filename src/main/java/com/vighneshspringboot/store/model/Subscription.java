package com.vighneshspringboot.store.model;

import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.util.UUID;

// Assumed enum for the billing cycle
enum BillingCycle {
    MONTHLY, QUARTERLY, ANNUALLY
}

@Entity
@Table(name = "subscription") // Assuming the table name is 'subscription'
//@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
//@NoArgsConstructor // Lombok: Generates a no-argument constructor
//@AllArgsConstructor // Lombok: Generates an all-argument constructor
public class Subscription {

    /**
     * id: [PK] uuid
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    /**
     * name: character varying (100)
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * billing_cycle: subshub.billing_cycle_enum
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "billing_cycle", nullable = false)
    private BillingCycle billingCycle;

    /**
     * next_payment_date: date
     */
    @Column(name = "next_payment_date", columnDefinition = "DATE")
    private LocalDate nextPaymentDate;

    /**
     * category_id: uuid
     * This suggests a ManyToOne relationship to a Category entity, but here it's kept as a simple foreign key ID.
     */
    @Column(name = "category_id")
    private UUID categoryId;

    /**
     * created_at: timestamp with time zone
     */
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdAt;

    /**
     * price: numeric(10, 2)
     */
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    /**
     * user_id: character varying (100)
     * This is the foreign key reference to the user who owns the subscription.
     */
    @Column(name = "user_id", length = 100, nullable = false)
    private String userId;
}