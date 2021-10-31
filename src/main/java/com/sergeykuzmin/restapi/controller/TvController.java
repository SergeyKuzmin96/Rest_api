package com.sergeykuzmin.restapi.controller;


import com.sergeykuzmin.restapi.Service.TvService;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.dto.TvFilter;
import com.sergeykuzmin.restapi.model.TV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Tag(name = "Телевизоры", description = "доступ к телевизорам")
@RequestMapping("/api")
public class TvController {


    @Autowired
    private TvService service;

    @GetMapping("/tvs")
    @Operation(
            summary = "Получение списка телевизоров",
            description = "Позволяет  получить список телевизоров, согласно заданым параметрам"
    )
    public Page<TV> showByAttribute(

            @RequestParam(value = "category", required = false) @Parameter(description = "Категория") String category,
            @RequestParam(value = "technology", required = false) @Parameter(description = "Технология") String technology,

            @RequestParam(value = "name", required = false) @Parameter(description = "Наименование") String name,
            @RequestParam(value = "serialNumber", required = false) @Parameter(description = "Сериный номер") String serialNumber,
            @RequestParam(value = "priceFrom", required = false) @Parameter(description = "Нижнее значение ценового диапазона") BigDecimal priceFrom,
            @RequestParam(value = "priceTo", required = false) @Parameter(description = "Верхнеее значение ценового диапазона") BigDecimal priceTo,
            @RequestParam(value = "color", required = false) @Parameter(description = "Цвет") String color,

            @RequestParam(value = "length", required = false) @Parameter(description = "Длинна девайса") Double length,
            @RequestParam(value = "height", required = false) @Parameter(description = "Высота девайса") Double height,
            @RequestParam(value = "width", required = false) @Parameter(description = "Ширина девайса") Double width,

            @RequestParam(value = "company", required = false) @Parameter(description = "Компания производитель") String company,
            @RequestParam(value = "country", required = false) @Parameter(description = "Страна производитель") String country,

            @RequestParam(value = "availability", required = false) @Parameter(description = "Наличие товара") Boolean availability,
            @RequestParam(value = "orderOnline", required = false) @Parameter(description = "Возможность заказа онлайн") Boolean orderOnline,
            @RequestParam(value = "instalment", required = false) @Parameter(description = "Возможность оформления рассрочки") Boolean instalment,

            @RequestParam(value = "pageNumber", required = false) @Parameter(description = "Номер страницы") Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) @Parameter(description = "Количество позиций на странице") Integer pageSize,
            @RequestParam(value = "sortDirectional", required = false) @Parameter(description = "Порядок сортировки") String sortDirectional,
            @RequestParam(value = "sortBy", required = false) @Parameter(description = "Атрибут сортировки(Возможна сортировка по имени и цене)") String sortBy) {

        DeviceFilter deviceFilter = new DeviceFilter(name, serialNumber, priceFrom, priceTo, color, length, height, width, company, country, availability, orderOnline,
                instalment, pageNumber, pageSize, sortDirectional, sortBy);

        TvFilter tvFilter = new TvFilter(category, technology);


        return service.findByFilter(deviceFilter, tvFilter);

    }

    @PostMapping("/tvs")
    @Operation(
            summary = "Добавление телевизора",
            description = "Позволяет добавить в реестр телевизоров новую позицию"
    )
    public TV addNewTv(@RequestBody TV tv) {

        service.addNewTv(tv);

        return tv;
    }

}