package com.kingjakeu.springstudy.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingjakeu.springstudy.common.domain.GameDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class HttpRequester {
    public static void doPost(){
        String url = "https://acs.leagueoflegends.com/v1/stats/game/ESPORTSTMNT01/1885163?gameHash=21d6065b9600a6d9";
        WebClient webClient = WebClient.create(url);

    }
    public static void doGet(String url, Map<String, String> httpHeader) throws JsonProcessingException {
        WebClient webClient = createDefaultGetClient(url);
        WebClient.RequestHeadersUriSpec<?> uriSpec = webClient.get();

        WebClient.RequestHeadersSpec<?> headersSpec = uriSpec.uri("");

        for(Map.Entry<String, String> header : httpHeader.entrySet()){
            headersSpec = headersSpec.attribute(header.getKey(), header.getValue());
        }
        Mono<String> response = headersSpec.retrieve().bodyToMono(String.class).log();
        String str = response.block();
        //System.out.println(str);

        Map<String, Object> map = new ObjectMapper().readValue(str, Map.class);
        GameDto game = new ObjectMapper().readValue(str, GameDto.class);
        System.out.println(game.toString());
    }

    private static WebClient createDefaultGetClient(String url){
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Cookie", "id_token=eyJraWQiOiJzMSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1MDZmMzlmMC02MWVlLTU3NGEtYTE4YS0wYjAwYzE5MTNmMDYiLCJjb3VudHJ5Ijoia29yIiwicGxheWVyX3Bsb2NhbGUiOiJrby1LUiIsImFtciI6WyJwYXNzd29yZCJdLCJpc3MiOiJodHRwczpcL1wvYXV0aC5yaW90Z2FtZXMuY29tIiwibG9sIjpbeyJjdWlkIjo0NzQ0ODAwLCJjcGlkIjoiS1IiLCJ1aWQiOjQ3NDQ4MDAsInVuYW1lIjoiamFrZWhzdSIsInB0cmlkIjpudWxsLCJwaWQiOiJLUiIsInN0YXRlIjoiRU5BQkxFRCJ9XSwibG9jYWxlIjoiZW5fVVMiLCJhdWQiOiJyc28td2ViLWNsaWVudC1wcm9kIiwiYWNyIjoidXJuOnJpb3Q6YnJvbnplIiwicGxheWVyX2xvY2FsZSI6ImtvLUtSIiwiZXhwIjoxNjE0OTI5Mjg3LCJpYXQiOjE2MTQ4NDI4ODcsImFjY3QiOnsiZ2FtZV9uYW1lIjoi7ISc64yA66y46rWs7LqQ66as66i47IugIiwidGFnX2xpbmUiOiJLUjEifSwianRpIjoibzBVNzJOSzZqV0EiLCJsb2dpbl9jb3VudHJ5Ijoia29yIn0.ho-ri8As1cur6UjefjRyXDjdLNpkSRDNCmINXr2yITxPkmlU-Ox_OFxiYU1hI84pRXdZxANgZqSZCR59d4qW9_Q4cTVd6fKXxptFB89RbCou3A4s5SSMu6kR1i-EFIn-cm6JFtX_1b2zZPd8HWnbImaqIj9S8dNKdiWVnOOCoyA;")
                .defaultHeader("user-agent", "Mozilla")
                .build();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException {
        Map<String, String> httpHeaders = new HashMap<>();
        doGet(
                "https://acs.leagueoflegends.com/v1/stats/game/ESPORTSTMNT01/1885163?gameHash=21d6065b9600a6d9",
                httpHeaders
        );
    }
}