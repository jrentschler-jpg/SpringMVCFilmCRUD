package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class MVCFilmsSiteDAOImpl implements MVCFilmSiteDAO{

	
		private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		private static final String user = "student";
		private static final String pass = "student";
		
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		
		
		
	  @Override
	  public Film findFilmById(int filmId){
		  Film film = null;
			  String sql = "SELECT film.*, language.* FROM film "
			  		+ "JOIN language on film.language_id = language.id "
			  		+ " WHERE film.id = ?";
			  film = getOneFilmFromIDNumber(sql, filmId, film);
		  return film;
	  }

	  
	  
	  
	  
	  
	  
	  public Film getOneFilmFromIDNumber(String sql, int iDNumber, Film film) {
		  try {
		  Connection conn = DriverManager.getConnection(URL, user, pass);
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setInt(1,iDNumber);
		  ResultSet filmResult = stmt.executeQuery();
		  if (filmResult.next()) {
		    film = new Film(); // Create the object
		    film.setId(filmResult.getInt("id"));
		    film.setTitle(filmResult.getString("title").toUpperCase());
			film.setDecsription(filmResult.getString("description").toUpperCase());
			film.setReleaseYear(filmResult.getShort("release_year"));
			film.setLanguage(filmResult.getString("name").toUpperCase());
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setFilmLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating").toUpperCase());
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setActors(findActorsByFilmId(filmResult.getInt("id")));
		  }
	} catch (SQLException e) {
		System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");

		e.printStackTrace();
	}
		  return film;
	  }

	  
	  
	  
	  
	  
	  public Actor findActorById(int actorId){
		  Actor actor = null;
		  try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			  String sql = "SELECT id, first_name, last_name FROM actor WHERE actor.id = ?";
			  PreparedStatement stmt = conn.prepareStatement(sql);
			  stmt.setInt(1,actorId);
			  ResultSet actorResult = stmt.executeQuery();
			  if (actorResult.next()) {
			    actor = new Actor(); // Create the object
			    actor.setId(actorResult.getInt("id"));
			    actor.setFirstName(actorResult.getString("first_name").toUpperCase());
			    actor.setLastName(actorResult.getString("last_name").toUpperCase());
			    actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
			  }
		} catch (SQLException e) {
			System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");

//			e.printStackTrace();
		}
		 
		  return actor;
		}

	  
	  
	  
	  
		public List<Film> findFilmsByActorId(int actorId) {
		  List<Film> films = new ArrayList<>();
		  try {
		    Connection conn = DriverManager.getConnection(URL, user, pass);
		    String sql = "SELECT film.*, language.* "
		               +  " FROM film "
		               + "JOIN language on film.language_id = language.id "  
		               + "JOIN film_actor ON film.id = film_actor.film_id "
		               + " WHERE actor_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actorId);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		    	int filmId = rs.getInt("id");
		    	String title = rs.getString("title").toUpperCase();
		    	String desc = rs.getString("description").toUpperCase();
		    	short releaseYear = rs.getShort("release_year");
		    	String lang = rs.getString("name").toUpperCase();
		    	int rentDur = rs.getInt("rental_duration");
		    	double rate = rs.getDouble("rental_rate");
		    	int length = rs.getInt("length");
		    	double repCost = rs.getDouble("replacement_cost");
		    	String rating = rs.getString("rating").toUpperCase();
		    	String features = rs.getString("special_features").toUpperCase();
		    	List<Actor> actors = findActorsByFilmId(filmId);

		    	Film film = new Film(filmId, title, desc, releaseYear, lang,
	                    rentDur, rate, length, repCost, rating, features, actors);
		      films.add(film);
		    }
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
				System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");

//		    e.printStackTrace();
		  }
		  return films;
		}
		
		
		
		
		
		
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		  List<Actor> actors = new ArrayList<>();
		  try {
		    Connection conn = DriverManager.getConnection(URL, user, pass);
		    String sql = "SELECT actor.* "
		               + "FROM actor "
		               + "JOIN film_actor ON actor.id = film_actor.actor_id "
		               + "JOIN film ON film.id = film_actor.film_id "
		               + "WHERE film.id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, filmId);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		    	int iD = rs.getInt("id");
		    	String title = rs.getString("first_name").toUpperCase();
		    	String desc = rs.getString("last_name").toUpperCase();

		      Actor actor= new Actor(iD, title, desc);
		      actors.add(actor);
		    }
		    rs.close();
		    stmt.close();
		    conn.close();
		  } catch (SQLException e) {
				System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");

//		    e.printStackTrace();
		  }
		  return actors;
		}





//	@Override
//	public EmployeeSearch findEmployeeByID(int employeeID){
//		EmployeeSearch employee = null;
//		  try {
//			Connection conn = DriverManager.getConnection(URL, user, pass);
//			  String sql = "SELECT staff.* FROM staff WHERE staff.id = ?";
//			  PreparedStatement stmt = conn.prepareStatement(sql);
//			  stmt.setInt(1,employeeID);
//			  ResultSet empResult = stmt.executeQuery();
//			  if (empResult.next()) {
//			    employee = new EmployeeSearch(); // Create the object
//			    employee.setId(empResult.getInt("id"));
//			    employee.setFirstName(empResult.getString("first_name").toUpperCase());
//			    employee.setLastName(empResult.getString("last_name").toUpperCase());
//			    if (empResult.getObject("password") == null) {
//			    	employee.setPassword("");
//			    }else {
//			    employee.setPassword(empResult.getString("password"));}
////		    System.out.println(employee.getFirstName());
//			  }
//		} catch (SQLException e) {
//			System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");
//
////			e.printStackTrace();
//		}
//		
//		return employee;
//		
//	}






	@Override
	public List<Film> findFilmByTitle(String filmName){
		  List<Film> films = new ArrayList<>();
		  String sql = "SELECT film.*, language.* FROM film "
				+ "JOIN language on film.language_id = language.id "
				+ "WHERE film.title LIKE '%' ? '%' ";
		films = getListOfFilmsForStringSearchReturn(films, sql, filmName);
		  return films;
		  }





	@Override
	public List<Film> getListOfFilmsForStringSearchReturn(List<Film> films, String sql, String userSearch) {
		 try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userSearch);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title").toUpperCase();
				String desc = rs.getString("description").toUpperCase();
				short releaseYear = rs.getShort("release_year");
				String lang = rs.getString("name").toUpperCase();
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating").toUpperCase();
				String features = rs.getString("special_features").toUpperCase();
				List<Actor> actors = findActorsByFilmId(filmId);
				

			  Film film = new Film(filmId, title, desc, releaseYear, lang,
			                       rentDur, rate, length, repCost, rating, features, actors);
			  films.add(film);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");
		}
	    return films;
	}




	@Override
	public List<Film> findFilmsByActorName(String actorName){
		  List<Film> films = new ArrayList<>();
		  String sql = "SELECT film.*, language.* FROM film "
							+ "JOIN language on film.language_id = language.id "
							+ "JOIN film_actor ON film.id = film_actor.film_id "
							+ "JOIN actor ON actor.id = film_actor.actor_id "
							+ "WHERE concat(actor.first_name,' ', actor.last_name) LIKE '%' ? '%'";
		films = getListOfFilmsForStringSearchReturn(films, sql, actorName);
		  return films;
		}





	@Override
	public List<Film> findFilmsByRating(String searchRating) {
		  List<Film> films = new ArrayList<>();
		  String sql = "SELECT film.*, language.* FROM film "
		    		+ "JOIN language on film.language_id = language.id "  
		    		+ "WHERE film.rating = ?";
		    films = getListOfFilmsForStringSearchReturn(films, sql, searchRating);
		  return films;
		}





	@Override
	public String findCategoryByFilmID(int id) {
		String category = null;
		    String sql = "SELECT category.* FROM category "
		    		+ "JOIN film_category on film_category.category_id = category.id "
		    		+ "JOIN film on film_category.film_id = film.id "
		    		+ "WHERE film.id = ? ";
			 try {
					Connection conn = DriverManager.getConnection(URL, user, pass);
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setInt(1, id);
				
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
					category = rs.getString("name");
						

					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");
				}
			 return category;
	}
		    
		    
		    





	@Override
	public List<Film> findFilmsFromSearch(String userSearch) {
		List<Film> films = new ArrayList<>();
	    String sql = "SELECT DISTINCT film.*, language.* FROM film "
	    		+ "JOIN language on film.language_id = language.id "
	    		+ "JOIN film_category on film_category.film_id = film.id "
	    		+ "JOIN category on film_category.category_id = category.id "
	    		+ "JOIN film_actor on film.id = film_actor.film_id "
	    		+ "JOIN actor on actor.id = film_actor.actor_id "
	    		+ "WHERE category.name LIKE '%' ? '%' "
	    		+ "OR concat(actor.first_name,' ', actor.last_name) LIKE '%' ? '%'"
	    		+ "OR film.title LIKE '%' ? '%' ";
		 try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userSearch);
			stmt.setString(2, userSearch);
			stmt.setString(3, userSearch);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title").toUpperCase();
				String desc = rs.getString("description").toUpperCase();
				short releaseYear = rs.getShort("release_year");
				String lang = rs.getString("name").toUpperCase();
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating").toUpperCase();
				String features = rs.getString("special_features").toUpperCase();
				List<Actor> actors = findActorsByFilmId(filmId);
				

			  Film film = new Film(filmId, title, desc, releaseYear, lang,
			                       rentDur, rate, length, repCost, rating, features, actors);
			  System.out.println(film);
			  films.add(film);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("WE ARE SORRY, WE COULDN'T FIND ANY FILMS FOR THAT SEARCH\n");
		}
	  return films;
	}





	@Override
	public void printFilmsList(List<Film> searchList) {
		int count = 0;
		for (Film film : searchList) {
			System.out.println(film);
			film.printCast(film.getActors());
			System.out.println("\n===================================================================================================================================\n");
			count++;
		}
		System.out.println("Your search returned " + count + " results");
	}






	@Override
	public void printIndividualFilm(Film film) {
		System.out.println(film);
		film.printCast(film.getActors());
		System.out.println("\n===================================================================================================================================\n");
	}






	@Override
	public Film findFilmByInventoryID(int inventoryId) {
		  Film film = null;
		  String sql = "SELECT film.*, language.* FROM film "
		  		+ "JOIN language ON film.language_id = language.id "
		  		+ "JOIN inventory_item ON inventory_item.film_id = film.id "
		  		+ "WHERE inventory_item.id = ?";
		  film = getOneFilmFromIDNumber(sql, inventoryId, film);
		  return film;
	}
	

	@Override
	public Film createFilm(Film film) {
		Film newFilm = film;
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
//			int filmId, String title, String description, int releaseYear, int langId, String language, int rentalDuration,
//			double rentalRate, int length, double replacementCost, String rating, String specialFeatures
		String sql = "INSERT INTO film(title, description, release_year, language_id, "
				+ "rental_duration, length, "
				+ "replacement_cost, rating) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		pst.setInt(1, newFilm.getId());
		pst.setString(1, newFilm.getTitle());
		pst.setString(2, newFilm.getDecsription());
		pst.setInt(3, newFilm.getReleaseYear());
		pst.setInt(4, newFilm.getLanguageId());
		pst.setInt(5, newFilm.getRentalDuration());
//		pst.setDouble(7, newFilm.getRentalRate());
		pst.setInt(6, newFilm.getFilmLength());
		pst.setDouble(7, newFilm.getReplacementCost());
		pst.setString(8, newFilm.getRating());
//		pst.setString(11, newFilm.getSpecialFeatures());
		
		
		int updateCount = pst.executeUpdate();
		System.out.println(updateCount + " film was created.");
		ResultSet keys = pst.getGeneratedKeys();
		
//		if (updateCount == 1) {
//			ResultSet keys = pst.getGeneratedKeys();
			if (keys.next()) {
				int newFilmId = keys.getInt(1);
				newFilm.setId(newFilmId);
			}
			keys.close();
//		}
		
		conn.commit();
//		pst.close();
		conn.close();
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
//			throw new RuntimeException("Error inserting film " + film.getTitle());

		}
		return newFilm;
	}
	
	@Override 
	public boolean deleteFilm(int filmId) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE film.id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, filmId);
			int updateCount = pst.executeUpdate();
			System.out.println(updateCount + " film was deleted.");
			conn.commit(); // COMMIT TRANSACTION
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
		
	}

@Override
	public Film updateFilm(Film film) {
	
	Connection conn = null;
	
	try {
		conn = DriverManager.getConnection(URL, user, pass);
		conn.setAutoCommit(false);
//		int filmId, String title, String description, int releaseYear, int langId, String language, int rentalDuration,
//		double rentalRate, int length, double replacementCost, String rating, String specialFeatures
	String sql = "INSERT INTO film(title, description, release_year, language_id, "
			+ "rental_duration, length, "
			+ "replacement_cost, rating) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	
//	pst.setInt(1, newFilm.getId());
	pst.setString(1, film.getTitle());
	pst.setString(2, film.getDecsription());
	pst.setInt(3, film.getReleaseYear());
	pst.setInt(4, film.getLanguageId());
	pst.setInt(5, film.getRentalDuration());
	pst.setDouble(7, film.getRentalRate());
	pst.setInt(6, film.getFilmLength());
	pst.setDouble(7, film.getReplacementCost());
	pst.setString(8, film.getRating());
	pst.setString(11, film.getSpecialFeatures());
	
	
	int updateCount = pst.executeUpdate();
	System.out.println(updateCount + " film was updated.");
	ResultSet keys = pst.getGeneratedKeys();
	
	if (updateCount != 1) {
		film = null;
		System.out.println("film is null");
//		ResultSet keys = pst.getGeneratedKeys();
//		if (keys.next()) {
	//		int newFilmId = keys.getInt(1);
	//		film.setId(newFilmId);
		}
		keys.close();
//	}
	
	conn.commit();
//	pst.close();
	conn.close();
	
//	}
	
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException sqle2) {
				System.err.println("Error trying to rollback");
			}
		}
//		throw new RuntimeException("Error inserting film " + film.getTitle());

	}
	return film;
}

		
		

}
