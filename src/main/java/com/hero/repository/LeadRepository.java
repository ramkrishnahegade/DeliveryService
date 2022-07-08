package com.hero.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hero.entity.LeadEntity;

@Repository
public class LeadRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LeadEntity getLeads() {
		return (LeadEntity) jdbcTemplate.query(
                "select * from Lead where LastName='Hegade Insert'",
                (rs, rowNum) ->
                        new LeadEntity(
                                rs.getString("Id"),
                                rs.getString("Company"),
                                rs.getString("LastName")
                        )
        ).get(0);

	}
	
	 public int save( ) {
	        return jdbcTemplate.update(
	                "insert into Lead (LastName, Company ,FirstName,MobilePhone) values(?,?,?,?)",
	                "Hegade Insert", "HMCL Insert","RK Insert","9449943595");
	    }
	 
	 public int update( ) {
	        return jdbcTemplate.update(
	                "update Lead set FirstName='Krishna' where LastName like ?","%Hegade Insert%");
	    }
	 
	 public int deleteById() {
	        return jdbcTemplate.update(
	                "delete Lead where LastName like ?","%Hegade Insert%");
	    }
}
