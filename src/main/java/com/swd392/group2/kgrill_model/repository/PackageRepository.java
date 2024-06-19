package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Package;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Integer> {

    Page<Package> findAll(@NonNull Pageable pageable);
}
