package edu.miu.cs.cs489.aerotran.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SearchControllerIntegrationTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SearchService searchService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testGetFlightByFromToORDepartureDate() throws Exception {
//        // Prepare test data
//        Long fromAirportId = 1L;
//        Long toAirportId = 2L;
//        LocalDateTime departureDateTime = LocalDateTime.of(2024, 4, 27, 12, 0);
//
//        // Mock service response
//        Flight mockFlight = new Flight(); // Assuming Flight is your domain object
//        when(searchService.searchFlight(fromAirportId, toAirportId, departureDateTime))
//                .thenReturn(Collections.singletonList(mockFlight));
//
//        // Perform GET request
//        mockMvc.perform(get("/flights")
//                        .param("from", String.valueOf(fromAirportId))
//                        .param("to", String.valueOf(toAirportId))
//                        .param("departureDateTime", departureDateTime.toString())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].id").exists()); // Assuming Flight has an 'id' field
//
//        // Verify service method was called with correct parameters
//        verify(searchService, times(1)).searchFlight(fromAirportId, toAirportId, departureDateTime);
//    }

}
