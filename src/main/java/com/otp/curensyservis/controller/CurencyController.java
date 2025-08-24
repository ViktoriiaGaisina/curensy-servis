package com.otp.curensyservis.controller;

import com.otp.curensyservis.dto.CurencyDto;
import com.otp.curensyservis.entity.Curency;
import com.otp.curensyservis.service.impl.CurencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curency")
@RequiredArgsConstructor
public class CurencyController {
    private final CurencyService curencyService;
    @GetMapping("/curencies")
    public List<CurencyDto> getAllCurency(){
        return curencyService.getAllCurency();
    }

    @GetMapping("/curencies/{code}")
    public CurencyDto getByCode(@PathVariable String code){
        return curencyService.getByCode(code);
    }

    @DeleteMapping("/delete")
    public void deleteCurencyByCode(@RequestParam String code){
        curencyService.deleteCurencyByCode(code);
    }

    @PutMapping("/update")
    public CurencyDto update(@RequestBody Curency curency){
        return curencyService.update(curency);
    }

    @PostMapping("/save")
    public CurencyDto save(@RequestBody Curency curency){
        return curencyService.save(curency);
    }

}
