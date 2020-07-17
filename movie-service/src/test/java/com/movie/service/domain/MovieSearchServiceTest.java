package com.movie.service.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.movie.domain.model.MovieDetail;
import com.movie.domain.repository.MovieDetailRepository;

@ExtendWith(MockitoExtension.class)
public class MovieSearchServiceTest {

   private static final int MOVIE_RATING = 1;
   private static final int MOVIE_ID = 1;

   @Mock
   private MovieDetailRepository movieDetailRepository;

   private MovieSearchService movieSearchService;

   @BeforeEach
   public void before() {
      movieSearchService = new MovieSearchService(movieDetailRepository);
   }

   @Test
   public void test() {
      List<MovieDetail> list = new ArrayList<MovieDetail>();

      MovieDetail md = new MovieDetail();
      md.setId(MOVIE_ID);
      list.add(md);

      when(movieSearchService.searchByMovieRating(MOVIE_RATING)).thenReturn(list);
      int id = movieSearchService.searchByMovieRating(MOVIE_RATING).get(0).getId();
      assertEquals(id, MOVIE_ID);
      verifyNoMoreInteractions(movieDetailRepository);
   }

}
