package xyz.diploma.campusgistmaster.service;

import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.Educator;
import xyz.diploma.campusgistmaster.repository.EducatorRepository;

@Service
public class EducatorService {
    private EducatorRepository educatorRepository;

    public void addEducator(Educator educator) {
        educatorRepository.save(educator);
    }
    public void deleteEducatorById(Long id) {
        educatorRepository.deleteById(id);
    }
}