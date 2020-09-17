package com.lechatong.beakhub.repositories;

import com.lechatong.beakhub.models.BhJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BhJobRepository extends JpaRepository<BhJob, Integer> {
    @Override
    void deleteById(Integer integer);

    @Override
    <S extends BhJob> S save(S s);

    @Override
    BhJob getOne(Integer integer);

    @Query("SELECT j.* FROM bh_job j WHERE j.user_id = :user_id")
    List<BhJob> getBhJobByIdUser(@Param("user_id") Integer integer);

    @Query("SELECT j.* FROM bh_job j WHERE j.category_id = :category_id")
    List<BhJob> getBhJobByIdCategory(@Param("category_id") Integer integer);

    @Override
    List<BhJob> findAll();

    @Override
    Optional<BhJob> findById(Integer integer);
}
