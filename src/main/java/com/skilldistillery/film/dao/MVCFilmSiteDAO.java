package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;



public interface MVCFilmSiteDAO {
	  public Film findFilmById(int filmId);
	  public Actor findActorById(int actorId); 
	  public List<Actor> findActorsByFilmId(int filmId);
	  public List<Film> findFilmsByActorId(int actorId);
//	  public EmployeeSearch findEmployeeByID(int employeeId);
	  public List<Film> findFilmByTitle(String filmName);
	  public List<Film> findFilmsByActorName(String actorName); 
	  public List<Film> findFilmsByRating(String searchRating);
	  public List<Film> getListOfFilmsForStringSearchReturn(List<Film> films, String sql, String userSearch);
	  public void printFilmsList(List<Film> searchList);
	  public void printIndividualFilm(Film film);
	  public Film findFilmByInventoryID(int inventoryId);
	  public Film getOneFilmFromIDNumber(String sql, int iDNumber, Film film);
	List<Film> findFilmsFromSearch(String userSearch);
//	List<Film> findCategoryFilmID(String userGenre);
	Film createFilm(Film film);
	boolean deleteFilm(int filmId);
	String findCategoryByFilmID(int id);

}
