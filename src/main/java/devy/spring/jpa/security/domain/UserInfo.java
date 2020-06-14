package devy.spring.jpa.security.domain;

import javax.persistence.*;

/**
 * 사용자 정보
 */
@Entity
//@Table(name = "user_info")
public class UserInfo {

    /** 사용자 번호 */
    @Id
    private long userNo;

    /** 사용자 ID */
    private String userId;

    /** 사용자 이름 */
    private String userName;

    /** 비밀번호 */
    private String password;

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userNo=" + userNo +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
