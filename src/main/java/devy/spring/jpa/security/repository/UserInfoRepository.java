package devy.spring.jpa.security.repository;

import devy.spring.jpa.security.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByUserId(String userId);

}
