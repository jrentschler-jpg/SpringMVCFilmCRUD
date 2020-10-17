package com.skilldistillery.films.controllers;
//import java.util.List;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.MVCFilmsSiteDAOImpl;
import com.skilldistillery.film.entities.Film;
@Controller
public class FilmController {
	@Autowired
		private MVCFilmsSiteDAOImpl DAO;
	
	
	@RequestMapping(path="addFilm.do", method=RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView mv = new ModelAndView();
	    mv.addObject(new Film());
	    mv.setViewName("ConfirmationPage");
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
	@RequestMapping(path="SearchKeyword.do")
	public ModelAndView SearchKeyword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SearchKeyword");
		return mv;
	}
	@RequestMapping(path="results.do", method= RequestMethod.GET)
	public ModelAndView SearchFilmResults(@RequestParam("Keyword")String input) {
		List<Film> searchList =  DAO.findFilmsFromSearch(input);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listFilms", searchList);
		mv.setViewName("ListOfFilmsSearch");
		return mv;
	}
}
//	private boolean menuSwitch() {
//boolean keepGoing = true;
//DatabaseAccessorObject run = new DatabaseAccessorObject();
//String userSearch = "";
//
//  while(keepGoing) {
//	  searchMenu();
//	  String userInput = input.nextLine().toLowerCase();
//  switch (userInput) {
//  case "1": case "film": case "film name": case "name":
//	  userSearch = promptForSearchParameter(1);
//	  List<Film> searchFilmTitle = run.findFilmByTitle(userSearch);
//	run.printFilmsList(searchFilmTitle);
//	  break;
//  case "2": case "rating": case "r":
//	  userSearch = promptForSearchParameter(2);
//	  List<Film> filmsByRating = run.findFilmsByRating(userSearch);
//	  run.printFilmsList(filmsByRating);
//	  break;
//  case "3": case "actor": case "a": 
//	   userSearch = promptForSearchParameter(3);
//	   List<Film> filmsByActorName = run.findFilmsByActorName(userSearch);
//	run.printFilmsList(filmsByActorName);
//	  break;
//  case "4": case "genre":
//	   userSearch = promptForSearchParameter(4);
//	   List<Film> filmsByGenre = run.findFilmsByCategory(userSearch);
//	   run.printFilmsList(filmsByGenre);
//	  break;
//  case "5": case "general": case "search": case "general search":
//	   userSearch = promptForSearchParameter(5);
//	   List<Film> filmsBasedOnSearch = run.findFilmsFromSearch(userSearch);
//	   run.printFilmsList(filmsBasedOnSearch);
//	  break;
//  case "6": case "main": case "menu":
//	 boolean mainMenu = true;
//	 return mainMenu;
//  case "7": case "quit": case "q":
//	  keepGoing = false;
//	  break;
//default: System.out.println("Invalid entry\n");
//  }
//  }
//  return keepGoing;
//
//}
//
//private String promptForSearchParameter(int searchType) {
//String searchHeader = "";
//		if (searchType == 1) {
//			searchHeader = "FILM NAME";
//			
//		}else if(searchType == 2) {
//			searchHeader = "RATING";
//			
//		}else if(searchType == 3) {
//			searchHeader = "ACTOR/ACTRESS";
//			
//		}else if(searchType == 4) {
//			searchHeader = "GENRE";
//			
//		}else if(searchType == 5) {
//			searchHeader = "KEYWORD";
//		}
//printSearchParameterPrompt(searchHeader);
//String userSearch = input.nextLine();
//return userSearch;
//
//}

//
//private int enterEmployeeId() {
//	printPromptForEmployeeID();
//	int employeeInput = 0;
//	boolean keepGoing = true;
//	while (keepGoing) {
//		try {
//			String userInput = input.nextLine();
//			if (userInput.equals("main") || userInput.equals("q")) {
//				break;
//			}
//			employeeInput = Integer.parseInt(userInput);
//			keepGoing = false;
//		} catch (NumberFormatException e) {
//			printNoIDFound();
//		}
//	}
//	return employeeInput;
//}
//
//private boolean enterPassword(EmployeeSearch user) {
//	int passTryCount = 0;
//	while (passTryCount < 3) {
//		String enteredPassword = input.nextLine();
//		if (!enteredPassword.equals(user.password)) {
//			printInvalidPassword();
//			passTryCount++;
//		} else {
//			passTryCount = 3;
//			return true;
//		}
//	}
//	return false;
//}
//public boolean runEmployeeFunctions() {
//	boolean keepGoing = true;
//	int employeeID = enterEmployeeId();
//	EmployeeSearch user = null;
//	if (employeeID != 0) {
//		DatabaseAccessorObject dAO = new DatabaseAccessorObject();
//		user = dAO.findEmployeeByID(employeeID);
//		if (user == null) {
//			printNoIDFound();
//		} else {
//			while (keepGoing) {
//				printPromptForPassword(user);
//				keepGoing = enterPassword(user);
//				if (keepGoing == false) {
//					boolean mainMenu = true;
//					return mainMenu;
//				}
//				keepGoing = false;
//				keepGoing = searchSwitch();
//				System.out.println(keepGoing);
//				if (keepGoing == true) {
//					boolean mainMenu = true;
//					return mainMenu;
//				}
//				
//			}
//		}
//	} else {
//		boolean mainMenu = true;
//		return mainMenu;
//	}
//	return keepGoing;
//}
//
//private boolean searchSwitch() {
//		boolean keepGoing = true;
//		DatabaseAccessorObject run = new DatabaseAccessorObject();
//		String userSearch = "";
//		boolean tryAgain = true;
//		
//		  while(keepGoing) {
//			  searchMenu();
//			  String userInput = input.nextLine().toLowerCase();
//		  switch (userInput) {
//		  case "1": case "film": case "film id": case "id":
//			  int filmIDSearch;
//			  while(tryAgain) {
//			try {
//				userSearch = promptForSearchParameter(1);
//				filmIDSearch = Integer.parseInt(userSearch);
//				Film searchFilmByIDReturn = run.findFilmById(filmIDSearch);
//				run.printIndividualFilm(searchFilmByIDReturn);
//				tryAgain = false;
//			} catch (NumberFormatException e) {
//				System.out.println("Invalid please enter valid ID");
////				e.printStackTrace();
//			}
//			  }
//			  break;
//		  case "2": case "actor id": case "aid":
//			  tryAgain = true;
//			  while (tryAgain) {
//			  try {
//				  userSearch = promptForSearchParameter(2);
//				int actorId = Integer.parseInt(userSearch);
//				  List<Film> filmsByRating = run.findFilmsByActorId(actorId);
//				  run.printFilmsList(filmsByRating);
//				  tryAgain = false;
//			} catch (NumberFormatException e) {
//				System.out.println("Invalid please enter valid ID");
////				e.printStackTrace();
//			}
//			  }
//			  break;
//		  case "3": case "inventory": case "inv": case "inventory id": case "iid": case "i":
//			  tryAgain = true;
//			  while (tryAgain) {
//			  try {
//				userSearch = promptForSearchParameter(3);
//				   int inventoryIDSearchNumber = Integer.parseInt(userSearch);
//				   Film filmByInventoryID = run.findFilmByInventoryID(inventoryIDSearchNumber);
//				run.printIndividualFilm(filmByInventoryID);
//				tryAgain = false;
//			} catch (NumberFormatException e) {
//				System.out.println("Invalid please enter valid ID");
////				e.printStackTrace()
//			}}
//			  break;
//		  case "4": case "title": case "film title": case "t":
//			   userSearch = promptForSearchParameter(4);
//			   List<Film> filmsByTitle = run.findFilmByTitle(userSearch);
//			  run.printFilmsList(filmsByTitle);
//			  break;
//		  case "5": case "actor": case "a":
//			  userSearch = promptForSearchParameter(5);
//			  List<Film> filmsByActor = run.findFilmsByActorName(userSearch);
//			  run.printFilmsList(filmsByActor);
//			  break;
//		  case "6": case "general": case "search": case "general search":
//			   userSearch = promptForSearchParameter(6);
//			   List<Film> filmsBasedOnSearch = run.findFilmsFromSearch(userSearch);
//			   run.printFilmsList(filmsBasedOnSearch);
//			  break;
//		  case "7": case "new":
//			  Film filmToAdd = getNewFilmInfo();
//			  if (filmToAdd != null) {
//				  run.createFilm(filmToAdd);
//			  }
//		  case "9": case "menu": case "main":
//			  boolean mainMenu = true;
//			  return mainMenu;
//		  case "10": case "quit": case "q":
//			  keepGoing = false;
//			  return keepGoing;
//		default: System.out.println("Invalid entry\n");
//		  }
//		  }
//		  return keepGoing;
//		
//	}
//private Film getNewFilmInfo() {
//	Film newFilm = new Film();
//	System.out.print("What is the Film TITLE: ");
//	newFilm.setTitle(input.nextLine().toUpperCase());
//	newFilm.setLanguageId(1);
//	System.out.print("What is the Film DESCRIPTION: ");
//		newFilm.setDecsription(input.nextLine().toUpperCase());
//		boolean validRY = false;
//		while(validRY) {
//			System.out.print("What is the Film RELEASE YEAR: ");
//		short releaseYear;
//		String newInfo = input.nextLine();
//		try {
//			releaseYear = Short.parseShort(newInfo);
//			newFilm.setReleaseYear(releaseYear);
//			validRY = true;
//		} catch (NumberFormatException e) {
//			if (newInfo.equals("")) {
//				newFilm.setReleaseYear((short)0);
//				validRY = true;
//			}else {
//				System.out.println("Invalid Entry");
//			}
//		}}
//		
//		
//		
//		boolean validRD = false;
//		while (validRD) {
//			System.out.print("What is the Film RENTAL DURATION: ");
//			String newInfo = input.nextLine();
//			try {
//				newFilm.setRentalDuration(Integer.parseInt(newInfo));
//				validRD = true;
//			} catch (NumberFormatException e) {
//				if (newInfo.equals("")) {
//					validRD = true;
//					newFilm.setRentalDuration(0);
//		}else {
//			System.out.println("Invalid Entry");
//		}
//		}
//		}
//			
//		
//		boolean validRR = false;
//		while (validRR) {
//			System.out.print("What is the Film RENTAL RATE: ");
//			String newInfo = input.nextLine();
//			try {
//				newFilm.setRentalRate(Double.parseDouble(newInfo));
//			validRR = true;
//			} catch (NumberFormatException e) {
//				if (newInfo.equals("")) {
//				validRR = true;
//				newFilm.setRentalRate(0.00);
//				}
//				
//			else {
//				System.out.println("Invalid Entry");
//			}
//			}
//		}
//		System.out.print("What is the Film LENGTH: ");
//		newFilm.setFilmLength(Integer.parseInt(input.nextLine()));
//		System.out.print("What is the Film REPLACEMENT COST: ");
//		newFilm.setReplacementCost(Double.parseDouble(input.nextLine()));
//		System.out.print("What is the Film RATING: ");
//		newFilm.setRating(input.nextLine().toUpperCase());
//		System.out.print("What is the Film SPECIAL FEATURES: ");
//		newFilm.setSpecialFeatures(input.nextLine().toUpperCase());
//		newFilm.setActors(userInputActors());
//	return null;
//}
//
//private List<Actor> userInputActors() {
//	
//	return null;
//}
//
//private String promptForSearchParameter(int searchType) {
//	String searchHeader = "";
//	if (searchType == 1) {
//		searchHeader = "FILM ID";
//		
//	}else if(searchType == 2) {
//		searchHeader = "ACTOR ID";
//		
//	}else if(searchType == 3) {
//		searchHeader = "INVENTORY ID";
//		
//	}else if(searchType == 4) {
//		searchHeader = "FILM TITLE";
//		
//	}else if(searchType == 5) {
//		searchHeader = "ACTOR";
//	}else if(searchType == 6) {
//		searchHeader = "KEYWORD";
//	}
//printSearchParameterPrompt(searchHeader);
//String userSearch = input.nextLine();
//return userSearch;
//
//}