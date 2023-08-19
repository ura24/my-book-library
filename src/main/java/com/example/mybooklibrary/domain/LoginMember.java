package com.example.mybooklibrary.domain;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginMember extends User {

    private final Member member;

    /**
	 * 通常のメンバー情報に加え、認可用ロールを設定する。
	 * 
	 * @param member メンバー情報
	 * @param authorityList 権限情報が入ったリスト
	 */
	public LoginMember(Member member, Collection<GrantedAuthority> authorityList) {
		super(member.getMailAddress(), member.getPassword(), authorityList);
		this.member = member;
	}

	/**
	 * 管理者情報を返します.
	 * 
	 * @return メンバー情報
	 */
	public Member getMember() {
		return member;
	}
    
}
