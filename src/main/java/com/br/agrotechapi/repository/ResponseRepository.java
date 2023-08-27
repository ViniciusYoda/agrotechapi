package com.br.agrotechapi.repository;

import com.br.agrotechapi.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
