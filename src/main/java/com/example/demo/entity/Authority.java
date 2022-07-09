package com.example.demo.entity;

import com.example.demo.AuthorityPK;

import javax.persistence.*;

@IdClass(AuthorityPK.class)
@Entity
@Table(name="authorities")
public class Authority {
    @Id
    private String username;
    @Id
    private String authority;
    public Authority(){}
    public Authority(User user, String authority){
        this.username = user.getUsername();
        this.authority = authority;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getAuthority(){
        return authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }


}
