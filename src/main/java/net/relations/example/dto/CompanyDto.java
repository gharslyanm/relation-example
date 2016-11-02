package net.relations.example.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by manukg on 10/28/2016.
 */
@XmlRootElement
public class CompanyDto {
    private Long companyId;
    private String companyName;

    public CompanyDto(){}

    private Set<UserDto> users;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }
}
