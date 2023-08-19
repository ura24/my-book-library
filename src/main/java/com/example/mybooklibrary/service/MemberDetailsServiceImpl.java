package com.example.mybooklibrary.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mybooklibrary.domain.LoginMember;
import com.example.mybooklibrary.domain.Member;
import com.example.mybooklibrary.repository.MemberRepository;

@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {
        Member member = memberRepository.findByMailAddress(mailAddress);
        if (member == null) {
            throw new UsernameNotFoundException("そのメールアドレスは登録されていません");
        }
        
        // 権限付与
        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new LoginMember(member, authorityList);
    }
    
}
