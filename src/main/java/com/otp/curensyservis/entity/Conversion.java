package com.otp.curensyservis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conversion")
@Builder
public class Conversion {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "converted_amount", nullable = false)
    private BigDecimal convertedAmount;

    @Column(name = "rate", nullable = false, precision = 10, scale = 4)
    private BigDecimal rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_curency", nullable = false)
    private Curency fromCurency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_curency", nullable = false)
    private Curency toCurency;




}

