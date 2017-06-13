package ua.room414.service.impl;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.room414.configuration.IceAndFireApiProperties;
import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;
import ua.room414.service.CharacterService;

import java.util.List;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Service
public class CharacterServiceImpl implements CharacterService {
    private RestTemplate restTemplate;
    private IceAndFireApiProperties properties;

    @Autowired
    public CharacterServiceImpl(RestTemplate restTemplate, IceAndFireApiProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public List<Character> filter(FilterCharacterRequest request) {
        return restTemplate.exchange(
                properties.getFilter(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Character>>() {},
                requestToMap(request)
        ).getBody();
    }

    @Override
    public Character find(long id) {
        return restTemplate.getForObject(properties.getFind(), Character.class, id);
    }

    @Override
    public Character find(String url) {
        return restTemplate.getForObject(url, Character.class);
    }

    private Map<String, Object> requestToMap(FilterCharacterRequest request) {
        return ImmutableMap
                .<String, Object>builder()
                .put(properties.getRouteParam().getPage(), request.getPage())
                .put(properties.getRouteParam().getName(), request.getName())
                .put(properties.getRouteParam().getBorn(), request.getBorn())
                .put(properties.getRouteParam().getDied(), request.getDied())
                .put(properties.getRouteParam().getIsAlive(), request.isAlive())
                .put(properties.getRouteParam().getCulture(), request.getCulture())
                .put(properties.getRouteParam().getGender(), request.getGender())
                .build();
    }
}
