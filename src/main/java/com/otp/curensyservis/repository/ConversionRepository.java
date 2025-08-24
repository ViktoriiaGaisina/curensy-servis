package com.otp.curensyservis.repository;

import com.otp.curensyservis.entity.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversionRepository extends JpaRepository<Conversion, UUID> {


}

