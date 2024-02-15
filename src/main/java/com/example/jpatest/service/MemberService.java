package com.example.jpatest.service;

import com.example.jpatest.dto.MemberDto;
import com.example.jpatest.entity.TestMemberEntity;
import com.example.jpatest.repository.TestMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    TestMemberRepository testMemberRepository;

    public void memberInsert(MemberDto memberDto){


        TestMemberEntity testMemberEntity = TestMemberEntity.toEntity(memberDto);
        testMemberRepository.save(testMemberEntity);
    }
}