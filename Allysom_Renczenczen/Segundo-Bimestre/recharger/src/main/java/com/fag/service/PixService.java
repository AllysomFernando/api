package com.fag.service;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.repositories.IPixRepository;
import com.fag.domain.useCases.CreatePix;
import com.fag.infra.celcoin.repository.PixCelcoin;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixService {
    @Inject
    PixCelcoin pixCelcoin;
    @Inject
    IPixRepository panache;
    public PixDTO genPix(PixDTO dto){
        CreatePix createPix = new CreatePix((IPixRepository) pixCelcoin, panache);

        dto = createPix.execute(dto);

        return createPix.execute(dto);
    }

}