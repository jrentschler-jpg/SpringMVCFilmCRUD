package com.skilldistillery.films.controllers;
//import java.util.List;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.MVCFilmsSiteDAOImpl;
import com.skilldistillery.film.entities.Film;
@Controller
public class FilmController {
	@Autowired
		private MVCFilmsSiteDAOImpl DAO;
	
	
	@RequestMapping(path="addNewFilm.do", method=RequestMethod.POST)
	public String addFilmToDB(Film film, RedirectAttributes redir) {
		DAO.createFilm(film);
//		System.out.println(film);
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:filmAdded.do";
	}
	
	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("ConfirmationPage");
		return mv;
	}
	@RequestMapping(path="addFilm.do", method=RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView mv = new ModelAndView();
	    mv.addObject(new Film());
	    mv.setViewName("addFilm");
	    return mv;
	  }
	@RequestMapping(path="OneFilmSearch.do")
	public ModelAndView OneFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("OneFilmSearch");
		return mv;
	}
	@RequestMapping(path="findFilmById.do", method=RequestMethod.GET)
	public ModelAndView FilmbyID(@RequestParam("Film ID")int input) {
		ModelAndView mv = new ModelAndView();
		Film searchFilm = DAO.findFilmById(input);
		searchFilm.setCategory(DAO.findCategoryByFilmID(searchFilm.getId()));
		System.out.println(searchFilm.getCategory());
//		System.out.println(input);
//		System.out.println(searchFilm);
		mv.addObject("film", searchFilm);
		mv.setViewName("OneFilmSearchResult");
		return mv;
	}
		
		
		
		
	@RequestMapping(path="getNewFilmInfo.do")
	public ModelAndView newFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Update");
		return mv;
	}
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.GET)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId ) {
		ModelAndView mv = new ModelAndView();
		Film filmToDelete = DAO.findFilmById(filmId);
		filmToDelete.setCategory(DAO.findCategoryByFilmID(filmToDelete.getId()));
		mv.addObject("film", filmToDelete);
		mv.setViewName("DeleteFilm");
		return mv;
	}
	
	@RequestMapping(path="confirmFilmDelete", method=RequestMethod.POST)
	public ModelAndView confirmDelete(@RequestParam("filmId")int filmId) {
		ModelAndView mv = new ModelAndView();
		
		
	}
	
	
	
	
	
	
	@RequestMapping(path="SearchKeyword.do")
	public ModelAndView SearchKeyword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SearchKeyword");
		return mv;
	}
	@RequestMapping(path="results.do", method= RequestMethod.GET)
	public ModelAndView SearchFilmResults(@RequestParam("Keyword")String input) {
		List<Film> searchList =  DAO.findFilmsFromSearch(input.toUpperCase());
		ModelAndView mv = new ModelAndView();
		for (Film film : searchList) {
//			System.out.println(film);
			mv.addObject("film", film);
		}
		mv.addObject("listFilms", searchList);
		mv.setViewName("OneFilmSearchResult");
		return mv;
	}
	@RequestMapping(path="updateFilm.do", method= RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("filmToUpdate")Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film updatedFilm = DAO.updateFilm(film);
		
		redir.addFlashAttribute("filmUpdated", film);
		mv.setViewName("redirect:Update.do");
		return mv;
	}
	@RequestMapping(path="Update.do", method=RequestMethod.GET)
	  public ModelAndView Update() {
	    ModelAndView mv = new ModelAndView();
//	    mv.addObject(new Film());
	    mv.setViewName("ConfirmationPage");
	    return mv;
	  }
	
	
	
	
}
