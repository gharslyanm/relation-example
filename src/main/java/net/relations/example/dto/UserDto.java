package net.relations.example.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by manukg on 10/28/2016.
 */
@XmlRootElement
public class UserDto {
    private Long userId;
    private String userName;
    private CompanyDto company;

    public UserDto() {
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }
}
