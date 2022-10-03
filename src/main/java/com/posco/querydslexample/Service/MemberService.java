package com.posco.querydslexample.Service;

import com.posco.querydslexample.Entity.MemberEntity;
import com.posco.querydslexample.Entity.MemberRoleEntity;
import com.posco.querydslexample.Entity.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService
{
    private final EntityManager em;

    public void findUser(){
        JPAQueryFactory queryFactory =new JPAQueryFactory(em);
        QMemberEntity mem = new QMemberEntity("m");

        MemberEntity findMem=queryFactory.select(mem).from(mem).where(mem.id.eq("user")).fetchOne();

        System.out.println(" ID : "+findMem.getId()+" PW : "+findMem.getPw()+" NM : "+findMem.getNm());
        for (MemberRoleEntity memrole: findMem.getRoles()
             ) {
            System.out.println(memrole.getRoleEntity().getRoleNm());
        }
    }
}
