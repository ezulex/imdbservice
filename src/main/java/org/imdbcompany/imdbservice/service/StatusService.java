package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatuses();
    void saveStatus(Status status);
    Status getStatusById(long id);
    void deleteStatusById(long id);
}
