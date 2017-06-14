package ua.room414.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.room414.facade.CharacterFacade;
import ua.room414.facade.dto.CharacterDetailsDto;
import ua.room414.facade.dto.CharacterDto;
import ua.room414.facade.dto.FilterCharacterRequestDto;

import java.util.List;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Jun 2017
 */
@Controller
@RequestMapping("/characters")
public class CharacterController {
    private static final String FIND_MANY_VIEW = "characters";
    private static final String FIND_MANY_MODEL = "characters";

    private static final String CHARACTER_DETAILS_VIEW = "characterDetails";
    private static final String CHARACTER_DETAILS_MODEL = "character";

    private CharacterFacade characterFacade;

    @Autowired
    public CharacterController(CharacterFacade characterFacade) {
        this.characterFacade = characterFacade;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findOne(@RequestParam("id") long id) {
        final CharacterDetailsDto model = characterFacade.find(id);

        return new ModelAndView(CHARACTER_DETAILS_VIEW, CHARACTER_DETAILS_MODEL, model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findMany(@ModelAttribute FilterCharacterRequestDto filter) {
        final List<CharacterDto> model = characterFacade.filter(filter);

        return new ModelAndView(FIND_MANY_VIEW, FIND_MANY_MODEL, model);
    }
}
