package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.msg.learning.shop.dtos.OrderDetailDto;
import ro.msg.learning.shop.dtos.OrderDto;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.exceptions.FileTypeMismatchException;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.utilities.CsvConverter;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CsvConverter csvConverter;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-order")
    public Order createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @SneakyThrows
    @PostMapping("/csv-from-file")
    public List<OrderDetailDto> readFromCsvFile(@RequestParam("file") MultipartFile file) {

        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new FileTypeMismatchException(file.getOriginalFilename(), "Use a .csv file!");
        }

        return csvConverter.fromCsv(OrderDetailDto.class, file.getInputStream());
    }
}
