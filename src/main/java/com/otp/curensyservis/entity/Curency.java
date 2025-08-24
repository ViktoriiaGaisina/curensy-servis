package com.otp.curensyservis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "curency")
public class Curency {
    @Id
    @EqualsAndHashCode.Include
    private String code;

    @Column(name = "name", nullable = false)
    private String name;
}
