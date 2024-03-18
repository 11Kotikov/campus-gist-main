package xyz.diploma.campusgistmaster.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.diploma.campusgistmaster.model.Educator;
import xyz.diploma.campusgistmaster.repository.EducatorRepository;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EducatorService {
    private EducatorRepository educatorRepository;

    public void addEducator(Educator educator) {
        educatorRepository.save(educator);
    }
    public void deleteEducatorById(Long id) {
        educatorRepository.deleteById(id);
    }
}