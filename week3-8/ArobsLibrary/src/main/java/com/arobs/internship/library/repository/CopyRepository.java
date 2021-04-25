package com.arobs.internship.library.repository;

import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.helper.StatusCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CopyRepository extends JpaRepository<Copy, UUID> {
    List<Copy> findAllByBookIdAndStatusAndFlag(Integer bookId, StatusCopy statusCopy, boolean flag);

    List<Copy> findAllByBookId(Integer bookId);

    Integer countByBookId(Integer bookId);
}
