package com.witon.jakub.ai.user;

import com.witon.jakub.ai.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByEmail(email);
        return new CustomUserDetails( optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email))));
    }
    public void signUpUser(User user) {
        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPass());
        user.setPass(encryptedPassword);
        final User createdUser = userRepository.save(user);

    }
}
