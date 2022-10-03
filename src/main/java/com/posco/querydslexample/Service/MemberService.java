package com.posco.querydslexample.Service;

import com.posco.querydslexample.Entity.MemberEntity;
import com.posco.querydslexample.Entity.MemberRoleEntity;
import com.posco.querydslexample.Entity.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import static com.posco.querydslexample.Entity.QMemberEntity.memberEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService
{
    private final EntityManager em;

    private final JPAQueryFactory queryFactory;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(em);
    }

    public void findUser(){

        MemberEntity findMem=queryFactory
                .select(memberEntity)
                .from(memberEntity)
                .where(memberEntity.id.eq("user").and(memberEntity.pw.eq("user")))
                .fetchOne();

        System.out.println(" ID : "+findMem.getId()+" PW : "+findMem.getPw()+" NM : "+findMem.getNm());

        for (MemberRoleEntity memrole: findMem.getRoles()) {
            System.out.println(memrole.getRoleEntity().getRoleNm());
        }
    }
}
