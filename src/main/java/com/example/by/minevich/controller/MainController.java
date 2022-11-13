package com.example.by.minevich.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j                            //логирование
@RestController
@RequestMapping
public class MainController {    //отвечает за обработку всех переходов на сайте (каждая функция обрабатывает определенный url
    @Autowired
    private HotelsEntityRepository hotelsEntityRepository;



}
