package com.example.rgr.model.repository;

import com.example.rgr.model.entity.Cinema;
import com.example.rgr.model.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomRepository {

 	private final EntityManager em;

 	public CustomRepository(EntityManager em) {
 		this.em = em;
	}

	public List<Movie> findCustomMoviesByCity(Integer id) {
		StringBuilder query = new StringBuilder();
		query.append("select distinct m.id as id, m.name as name ");
		query.append("from Movie m ");
		query.append("inner join MovieCity mc on m.id = mc.movie_id ");
		query.append("inner join Cinema c on c.id = mc.cinema_id ");
		query.append("inner join City c2 on c.city_id = c2.id ");
		query.append("where c.city_id = :id ");

		String quer = "select distinct m " +
				"from Movie m  " +
				"inner join MovieCity mc on m.id = mc.movie.id  " +
				"inner join Cinema c on c.id = mc.cinema.id  " +
				"inner join City c2 on c.city.id = c2.id  " +
				"where c.city.id = :id  " ;

		TypedQuery<Movie> q = em.createQuery(quer, Movie.class);

		q.setParameter("id",  id);

		return q.getResultList();
	}



	public List<Cinema> findCustomCinemasByCity(Integer id) {

		String query = "select distinct c " +
				"from Movie m " +
				"inner join MovieCity mc on m.id = mc.movie.id  " +
				"inner join Cinema c on c.id = mc.cinema.id  " +
				"inner join City c2 on c.city.id = c2.id  " +
				"where c.city.id = :id  ";

		TypedQuery<Cinema> q = em.createQuery(query, Cinema.class);

		q.setParameter("id",  id);

		return q.getResultList();
	}


}
