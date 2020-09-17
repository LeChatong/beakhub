package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BhCategoryRepository extends JpaRepository<BhCategory, Integer> {
    @Override
    boolean existsById(Integer integer);

    @Override
    List<BhCategory> findAll();

    @Override
    <S extends BhCategory> S save(S s);

    @Override
    BhCategory getOne(Integer integer);
}
