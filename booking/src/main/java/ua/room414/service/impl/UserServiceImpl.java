package ua.room414.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.User;
import ua.room414.repository.UserRepository;
import ua.room414.service.UserService;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void remove(User object) {
        userRepository.delete(object);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
