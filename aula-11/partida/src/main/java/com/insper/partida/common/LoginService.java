package com.insper.partida.common;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    public boolean verificar_token(String token){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> response = restTemplate.getForEntity("http://localhost:8081/login/token/" + token , Boolean.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        else    {
            return false;
        }





    }


}
