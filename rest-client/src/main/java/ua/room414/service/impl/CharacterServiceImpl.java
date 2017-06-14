package ua.room414.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ua.room414.configuration.IceAndFireApiProperties;
import ua.room414.domain.Character;
import ua.room414.domain.FilterCharacterRequest;
import ua.room414.service.CharacterService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


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
    public List<Character> filter(final FilterCharacterRequest request) {
        final HttpEntity<String> httpEntity = createHttpEntity();
        final String requestUri = filterRequestToUri(request);
        final ResponseEntity<Character[]> characters = restTemplate.exchange(requestUri, HttpMethod.GET, httpEntity, Character[].class);

        return Lists.newArrayList(characters.getBody());
    }

    @Override
    public Character find(final long id) {
        final HttpEntity<String> httpEntity = createHttpEntity();
        final ResponseEntity<Character> character
                = restTemplate.exchange(properties.getFind(), HttpMethod.GET, httpEntity, Character.class, id);

        return character.getBody();
    }

    @Override
    public Character find(final String url) {
        final HttpEntity<String> httpEntity = createHttpEntity();
        final ResponseEntity<Character> character
                = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Character.class);

        return character.getBody();
    }

    private HttpEntity<String> createHttpEntity() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.add(HttpHeaders.USER_AGENT, ServiceUtil.FAKE_USER_AGENT);

        return new HttpEntity<>("", httpHeaders);
    }

    private String filterRequestToUri(final FilterCharacterRequest request) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        IceAndFireApiProperties.RouteParam routeParam = properties.getRouteParam();

        ServiceUtil.putIfCondition(routeParam.getPage(), request.getPage(), map, p -> p > 0);
        ServiceUtil.putIfCondition(routeParam.getName(), request.getName(), map, Objects::nonNull);
        ServiceUtil.putIfCondition(routeParam.getGender(), request.getGender(), map, Objects::nonNull);
        ServiceUtil.putIfCondition(routeParam.getCulture(), request.getCulture(), map, Objects::nonNull);
        ServiceUtil.putIfCondition(routeParam.getBorn(), request.getDied(), map, Objects::nonNull);
        ServiceUtil.putIfCondition(routeParam.getCulture(), request.getCulture(), map, Objects::nonNull);
        ServiceUtil.putIfCondition(routeParam.getIsAlive(), request.getIsAlive(), map, Objects::nonNull);

        return UriComponentsBuilder.fromUriString(properties.getFilter()).queryParams(map).build().toUriString();
    }
}
