package com.vighneshspringboot.store.model;

import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
import java.io.Serializable;
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
public class Subscription implements Serializable {

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

    // Constructors

    public Subscription() {}

    public Subscription(String name, BillingCycle billingCycle, LocalDate nextPaymentDate,
                        UUID categoryId, ZonedDateTime createdAt, BigDecimal price, String userId) {
        this.name = name;
        this.billingCycle = billingCycle;
        this.nextPaymentDate = nextPaymentDate;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.price = price;
        this.userId = userId;
    }

    // Getters & Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(BillingCycle billingCycle) {
        this.billingCycle = billingCycle;
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}