package br.com.grupo.acert.controller;

import br.com.grupo.acert.model.request.ConverterRequestCelsius;
import br.com.grupo.acert.model.request.ConverterRequestFahrenheit;
import br.com.grupo.acert.service.ConverterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/converter")
@Api(value = "API REST converter")
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @PostMapping("/celsius-fahrenheit")
    @ApiOperation(value = "Converte uma temperatura de celsius para fahrenheit")
    public ResponseEntity celsiusParaFahrenheit(@Valid @RequestBody ConverterRequestCelsius conversaoRequest, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.OK).body(this.converterService.celsiusParaFahrenheit(conversaoRequest, request));
    }

    @PostMapping("/fahrenheit-celsius")
    @ApiOperation(value = "Converte uma temperatura de fahrenheit para celsius")
    public ResponseEntity fahrenheitParaCelsius(@Valid @RequestBody ConverterRequestFahrenheit conversaoRequest, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(this.converterService.fahrenheitParaCelsius(conversaoRequest, request));
    }
}
