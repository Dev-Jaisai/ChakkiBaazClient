package com.Catalog.Service.repo;
import com.Catalog.Service.entity.Grain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrainRepository extends JpaRepository<Grain, Long> {
    // You can add custom query methods here if needed
}
