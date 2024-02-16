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

    // 로그인 처리 메서드
    public MemberDto memberLogin(MemberDto memberDto){
        TestMemberEntity testMemberEntity = testMemberRepository.findByEmailAndPassword(
                memberDto.getEmail(), memberDto.getPassword());
        if(testMemberEntity != null){// 이메일과 패스워드가 일치한다면
            return MemberDto.toDto(testMemberEntity);
        }
        return null; //이메일과 패스워드가 틀리다면
    }
}
