package ua.room414.service.impl;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.room414.domain.entity.Auditorium;
import ua.room414.repository.AuditoriumRepository;
import ua.room414.service.AuditoriumService;

import java.util.Set;

/**
 * @author Alexander Melashchenko
 * @version 1.0 01 Jun 2017
 */
@Service
@Transactional
public class AuditoriumServiceImpl implements AuditoriumService {
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Auditorium> getAll() {
        return Sets.newHashSet(auditoriumRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Auditorium getByName(String name) {
        return auditoriumRepository.findAuditoriumByName(name);
    }
}
