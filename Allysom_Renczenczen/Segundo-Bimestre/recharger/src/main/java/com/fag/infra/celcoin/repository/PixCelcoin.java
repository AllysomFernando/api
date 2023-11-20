package com.fag.infra.celcoin.repository;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.entities.PixBO;
import com.fag.domain.repositories.IPixVendor;
import com.fag.infra.celcoin.dto.CelcoinPixDTO;
import com.fag.infra.celcoin.dto.CelcoinPixResponse;
import com.fag.infra.celcoin.dto.CelcoinTokenDTO;
import com.fag.infra.celcoin.mappers.CelcoinPixMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;
import org.eclipse.microprofile.rest.client.inject.RestClient;

public class PixCelcoin implements IPixVendor {

    @Inject
    @RestClient
    RestClientCelcoin restClient;

    @Override
    public PixDTO create(PixDTO pix){
        CelcoinPixDTO pixDTO = CelcoinPixMapper.toVendoDTO(pix);

        CelcoinPixResponse response = restClient.handlePix(getToken(), pixDTO);

        pix.setQrCode(response.getQrCode());
        pix.setTransactionId(response.getTransactionId());

        return pix;
    }

    private String getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelcoinTokenDTO tokenDTO = restClient.generateToken(form);
        String token = "Bearer " + tokenDTO.getAccessToken();

        return token;
    }
}
