package com.ipl.nextg;

import com.ipl.nextg.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserController_Tests {

    @Autowired
    MockMvc mockMvc;

    //@MockBean
    //UserRepository userRepository;

    @Test
    public void contextLoads() throws Exception {
//        Mockito.when(userRepository.save(new UserDTO())).
//                thenReturn();
//
////        String json = "{\"usr_fname\":\"Mayur\", \"usr_lname\":\"Patil\", \"usr_password\":\"testing0s\", \"usr_profile\":\"a.png\", \"usr_type\":1, \"usr_gender\":\"M\", \"usr_status\":\"A\", \"usr_rating\":0}";
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getUsers")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();

    }
}
