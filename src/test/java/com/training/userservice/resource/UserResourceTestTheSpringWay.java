//package com.training.userservice.resource;
//
///**
// * Created by Thomas Becker (thomas.becker00@gmail.com) on 15.01.23.
// */
//
//import com.training.userservice.persistence.UserEntity;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserResource.class)
//class UserResourceTestTheSpringWay {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Test
//    void testExample() throws Exception {
//        UUID id = UUID.randomUUID();
//        given(userRepository.findAll()).willReturn(
//                List.of(new UserEntity(id, "someFirstName", "someLastName", "some@email.com", Collections.emptySet()),
//                        new UserEntity(UUID.randomUUID(), "someOtherName", "someOtherLastName", "some@email.com",
//                                Collections.emptySet())));
//        mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[:1].firstName").value("someFirstName"));
//    }
//
//}
//
//
