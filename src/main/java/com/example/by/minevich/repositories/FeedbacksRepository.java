package com.example.by.minevich.repositories;

import com.example.by.minevich.models.FeedbacksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FeedbacksRepository extends JpaRepository<FeedbacksEntity, Long> {
}
