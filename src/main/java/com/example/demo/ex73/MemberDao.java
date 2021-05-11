package com.example.demo.ex73;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class MemberDao {
    // 멤버 테이블에 관한 거니까 멤버다오에 구현하는거임
    private JdbcTemplate jdbcTemplate;
    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER",Integer.class);
        return count;
    }

    public void update(Member member){
        jdbcTemplate.update("update MEMBER set Name = ?, PASSWORD =?"+"where EMAIL =?", member.getName(),member.getPassword(),member.getEmail());
    }

    public void insert(final Member member){
        jdbcTemplate.update("insert into MEMBER(EMAIL,PASSWORD,NAME,REGDATE)"+"values(?,?,?,?)", member.getEmail(),member.getPassword(),member.getName(),member.getRegisterDate());

    }

    public Member selectByEmail(String email){
        List<Member> results = jdbcTemplate.query("select * from MEMBER where email = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(rs.getString("EMAIL"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getTimestamp("REGDATE"));
                        member.setId(rs.getLong("ID"));
                        return member;
                    }
                }, email);
        return results.isEmpty() ? null : results.get(0);
    }

}


