package com.example.mybooklibrary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.mybooklibrary.domain.Member;

@Repository
public class MemberRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
        Member member = new Member();
        member.setId(rs.getInt("id"));
        member.setName(rs.getString("name"));
        member.setMailAddress(rs.getString("mail_address"));
        member.setPassword(rs.getString("password"));
        return member;
    };

    private final String FIND_BY_MAIL_ADDRESS_SQL = """
            SELECT
                id, name, mail_address, password
            FROM
                members
            WHERE
                mail_address = :mailAddress;
            """;

    public Member findByMailAddress(String mailAddress) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);

        List<Member> memberList = template.query(FIND_BY_MAIL_ADDRESS_SQL, param, MEMBER_ROW_MAPPER);
		if (memberList.size() == 0) {
			return null;
		}
		return memberList.get(0);
    }
}
