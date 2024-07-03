package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.PackageDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageDishRepository extends JpaRepository<PackageDish, Integer> {
}