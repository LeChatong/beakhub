package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BhAddressRepository extends JpaRepository<BhAddress, Integer> {
    @Override
    <S extends BhAddress> S save(S s);

    @Override
    List<BhAddress> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    Optional<BhAddress> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Query(value = "SELECT a.* FROM bh_address a WHERE a.job_id = :job_id", nativeQuery = true)
    List<BhAddress> findAllAdressByJobId(@Param("job_id") Integer job_id);
}
