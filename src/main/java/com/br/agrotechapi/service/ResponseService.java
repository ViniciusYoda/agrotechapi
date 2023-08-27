package com.br.agrotechapi.service;

import com.br.agrotechapi.models.Response;
import com.br.agrotechapi.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    public Response getResponseById(Long id) {
        return responseRepository.findById(id).orElse(null);
    }
}
