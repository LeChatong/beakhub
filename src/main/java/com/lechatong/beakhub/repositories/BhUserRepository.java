package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BhUserRepository extends JpaRepository<BhUser, Integer> {
    @Override
    boolean existsById(Integer integer);

    @Override
    <S extends BhUser> S save(S s);

    @Override
    List<BhUser> findAll();

    @Override
    void deleteById(Integer integer);

    @Override
    Optional<BhUser> findById(Integer integer);
}
