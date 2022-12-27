//package com.foodieapp.favoriteService.repository;
//
//import com.foodieapp.favoriteService.domain.Favorite;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@ExtendWith(MockitoExtension.class)
//@DataMongoTest
//public class FavoriteRepoTest {
//    @Autowired
//    private FavRepo favRepo;
//    private Favorite favorite;
//
//    @BeforeEach
//    public void setUp(){
//        favorite=new Favorite("chatBhandar","indore",123,"url","5.5");
//
//    }
//    @Test
//    void givenRestronToSaveShouldReturnSavedRestaurant(){
//        favRepo.save(favorite);
//        Favorite favorite1=favRepo.findById(favorite.getRestaurantName()).get();
//        assertNotNull(favorite1);
//        assertEquals(favorite.getRestaurantName(),favorite1.getRestaurantName());
//    }
//    @Test
//    public void givenRestaurantToDeleteShouldDeleteRestaurant() {
//        favRepo.insert(favorite);
//        Favorite favorite1 = favRepo.findById(favorite.getRestaurantName()).get();
//        favRepo.delete(favorite1);
//        assertEquals(Optional.empty(), favRepo.findById(favorite.getRestaurantName()));
//
//    }
//}
