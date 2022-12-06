package com.fcshop.study.service;

import com.fcshop.study.dto.ShoppingResponseDto;
import com.fcshop.study.entity.member.Member;
import com.fcshop.study.entity.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // login
    public Member findByMember(String id, String password){
        return memberRepository.findByIdAndPassword(id,password);
    }
    // select All
    @Transactional(readOnly = true)
    public List<Member> findAll(){
        return memberRepository.findAll();
    }
    // select by Id
    public ShoppingResponseDto findById(Long id){
        return new ShoppingResponseDto(memberRepository.findById(id).get());
    }
    // insert
    @Transactional
    public Member save(Member member){
        return memberRepository.save(member);
    }
    //update
//    public int updateMember(ShoppingRequestDto shoppingRequestDto){
//        return memberRepository.updateMember(shoppingRequestDto);
//    }

    // delete
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

}
