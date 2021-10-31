package com.sergeykuzmin.restapi.controller;

import com.sergeykuzmin.restapi.Service.CleanerService;
import com.sergeykuzmin.restapi.dto.CleanerFilter;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.model.Cleaner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Tag(name = "Пылесосы", description = "доступ к пылесосам")
@RequestMapping("/api/cleaners")
public class CleanerController {
    @Autowired
    CleanerService service;

    @GetMapping
    @Operation(
            summary = "Получение списка пылесосов",
            description = "Позволяет  получить список пылесосов, согласно заданым параметрам"
    )
    public Page<Cleaner> showByAttribute(

            @RequestParam(value = "collectorVolume", required = false) @Parameter(description = "Объем пылесборника") Double collectorVolume,
            @RequestParam(value = "countOfMode", required = false) @Parameter(description = "Количество режимов работы") Integer countOfMode,


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
            @RequestParam(value = "sortBy", required = false) @Parameter(description = "Атрибут сортировки(Возможна сортировка по имени и цене)") String sortBy
    ) {


        DeviceFilter deviceFilter = new DeviceFilter(name, serialNumber, priceFrom, priceTo, color, length, height, width,
                company, country, availability, orderOnline, instalment, pageNumber, pageSize, sortDirectional, sortBy);


        CleanerFilter cleanerFilter = new CleanerFilter(collectorVolume, countOfMode);

        return service.findByFilter(deviceFilter, cleanerFilter);
    }


    @PostMapping("/cleaners")
    @Operation(
            summary = "Добавление пылесоса",
            description = "Позволяет добавить в реестр пылесосов новую позицию"
    )
    public Cleaner addNewTv(@RequestBody Cleaner cleaner) {

        service.addNewCleaner(cleaner);

        return cleaner;
    }
}