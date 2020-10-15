package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "select a.* from bh_account a where a.username = :username and a.password = :password", nativeQuery = true)
    Optional<BhAccount> login(@Param("username") String username, @Param("password") String password);
}
