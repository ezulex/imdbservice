package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public void saveStatus(Status status) {
        this.statusRepository.save(status);
    }

    @Override
    public Status getStatusById(long id) {
        Optional<Status> optional = statusRepository.findById(id);
        Status status = null;
        if (optional.isPresent()) {
            status = optional.get();
        } else {
            throw new RuntimeException("Status not found for id: " + id);
        }
        return status;
    }

    @Override
    public void deleteStatusById(long id) {
        this.statusRepository.deleteById(id);
    }
}
