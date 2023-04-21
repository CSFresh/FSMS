package com.amanda.fsms.controller;

import com.amanda.fsms.constant.CPConstant;
import com.amanda.fsms.data.*;
import com.amanda.fsms.service.DoWorkService;
import com.amanda.fsms.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/audit")
public class DoWorkController {

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private DoWorkService doWorkService;

    @GetMapping("/area")
    public List<AreaData> getAreaOfHotel(){
        System.out.println("123");
        return null;
    }


    @GetMapping("/start")
    public CPConstant runAudit(Integer userId){
        CPConstant cpConstant = new CPConstant();
        return cpConstant;
    }

    @PostMapping("daily/individual")
    public IndividualReportResponse calculateIndividual(GenerateReportRequest generateReportRequest){
        final IndividualReportResponse individualReportResponse = doWorkService.calculateIndividual(
                generateReportRequest);
        return null;
    }

    @PostMapping("daily/merge")
    public MergedReportResponse calculateMerge(GenerateReportRequest generateReportRequest){
        return doWorkService.calculateMerge(generateReportRequest);
    }

    @PostMapping("monthly/merge")
    public IndividualReportResponse calculateMonthlyMerge(GenerateReportRequest generateReportRequest){
        return null;
    }

    @PostMapping("/upload")
    public UpLoadResponse uploadModel(@RequestParam("file") final MultipartFile file,
            @RequestBody final UploadRequest uploadRequest) {
        fileUploadService.handleFileUpload(file,uploadRequest);
        return null;
    }
}
