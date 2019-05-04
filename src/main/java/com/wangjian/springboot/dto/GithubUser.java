package com.wangjian.springboot.dto;

/**
 * ClassName:GithubUser
 * Package:com.wangjian.springboot.dto
 * Description:
 *
 * @date:2019/5/4 19:00
 * @author:983998427@qq.com
 */
public class GithubUser {
    private  long id;
    private  String name;
    private  String bio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
