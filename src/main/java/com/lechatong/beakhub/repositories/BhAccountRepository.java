package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BhAccountRepository extends JpaRepository<BhAccount, Integer> {
    @Override
    <S extends BhAccount> S save(S s);

    @Override
    BhAccount getOne(Integer integer);

    @Override
    List<BhAccount> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Optional<BhAccount> findById(Integer integer);
}
