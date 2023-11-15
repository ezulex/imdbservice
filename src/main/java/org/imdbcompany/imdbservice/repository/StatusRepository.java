package org.imdbcompany.imdbservice.repository;

import org.imdbcompany.imdbservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
