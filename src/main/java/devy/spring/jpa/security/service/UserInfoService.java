package devy.spring.jpa.security.service;

import devy.spring.jpa.security.domain.UserInfo;
import devy.spring.jpa.security.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(username);
        userInfo = userInfoRepository.findByUserId(username);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("USER"));

        return new User(userInfo.getUserId(), userInfo.getPassword(), grantedAuthorityList);
    }

    public UserInfo addUser(UserInfo userInfo) {
        long userNo = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        String encodePassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userInfo.getPassword());
        userInfo.setPassword(encodePassword);
        userInfo.setUserNo(userNo);
        return userInfoRepository.save(userInfo);
    }

}
