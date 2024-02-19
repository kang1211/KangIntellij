package com.example.jpatest.repository;

import com.example.jpatest.entity.LoginHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistoryEntity,Long> {
    public List<LoginHistoryEntity> findByTestMemberEntityId(Long test_member_entity_id);
}
