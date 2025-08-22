package com.rohit.service.imple;

import com.rohit.exception.UserException;
import com.rohit.model.User;
import com.rohit.repository.UserRepository;
import com.rohit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
        {
            return user.get();
        }
        throw new UserException("user not found!");

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {

        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty())
        {
            throw new UserException("user not found with id " + id);
        }
        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public User updateUser(Long id , User user) throws UserException {

        Optional<User> userUpadte = userRepository.findById(id);
        if(userUpadte.isEmpty())
        {
            throw new UserException("user not found with id" + id);
        }
        User existingUser = userUpadte.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }
}
