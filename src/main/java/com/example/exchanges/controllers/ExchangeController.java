package com.example.exchanges.controllers;

import com.example.exchanges.constants.Routes;
import com.example.exchanges.requests.ExchangeRequest;
import com.example.exchanges.responses.ExchangeResponse;
import com.example.exchanges.services.ExchangeService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Routes.EXCHANGES, produces = (MediaType.APPLICATION_JSON_VALUE))
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @PostMapping
    public ExchangeResponse exchange(@RequestBody ExchangeRequest exchangeRequest) {
        return exchangeService.exchange(exchangeRequest);
    }

    @PostMapping(Routes.MASSIVE)
    public List<ExchangeResponse> exchangeMassive(@RequestBody List<ExchangeRequest> exchangeRequest) {
        return exchangeService.exchangeMassive(exchangeRequest);
    }

    @GetMapping
    public List<Integer> order() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(24);
        numbers.add(8);
        numbers.add(13);
        numbers.add(6);
        numbers.add(15);
        numbers.add(8);
        numbers.add(15);
        numbers.add(20);

        return numbers.stream().filter(this::isPar).sorted().collect(Collectors.toList());
    }

    public Boolean isPar(Integer number) {
        return number % 2 == 0;
    }
}
