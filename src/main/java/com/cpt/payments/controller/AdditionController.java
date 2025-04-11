package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AdditionController {

    private int lastAdditionResult;
    private int num1;
    private int num2;

    @PostMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        System.out.println("num1:" + num1 + "|num2:" + num2);

        this.num1 = num1;
        this.num2 = num2;
        lastAdditionResult = num1 + num2;
        System.out.println("sumResult:" + lastAdditionResult);

        return lastAdditionResult;
    }

    @GetMapping("/addResult")
    public int addResult() {
        System.out.println("Fetching last addition result: " + lastAdditionResult);
        return lastAdditionResult;
    }

    @PutMapping("/updateAdd/{num1}/{num2}")
    public int updateAdd(@PathVariable int num1, @PathVariable int num2) {
        System.out.println("Updating addition with num1:" + num1 + " and num2:" + num2);

        this.num1 = num1;
        this.num2 = num2;
        lastAdditionResult = num1 + num2;
        System.out.println("Updated sumResult:" + lastAdditionResult);

        return lastAdditionResult;
    }

    @PatchMapping("/patchAdd")
    public int patchAdd(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 != null) {
            System.out.println("Patching num1: " + num1);
            this.num1 = num1;
        }
        if (num2 != null) {
            System.out.println("Patching num2: " + num2);
            this.num2 = num2;
        }
        lastAdditionResult = this.num1 + this.num2;
        System.out.println("Patched sumResult:" + lastAdditionResult);
        return lastAdditionResult;
    }

    @DeleteMapping("/deleteAdd")
    public String deleteAdd() {
        System.out.println("Deleting addition result.");
        lastAdditionResult = 0; // Reset the last addition result
        return "Addition result deleted. Last addition result reset to 0.";
    }
}