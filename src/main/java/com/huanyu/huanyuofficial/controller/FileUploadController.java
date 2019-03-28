package com.huanyu.huanyuofficial.controller;


import com.huanyu.huanyuofficial.bean.base.BaseResponse;
import com.huanyu.huanyuofficial.storage.StorageFileNotFoundException;
import com.huanyu.huanyuofficial.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;


@Controller
@RequestMapping("hyofficial/file")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/all")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    @ResponseBody
    public BaseResponse handleFileUpload(@RequestParam("file") MultipartFile file) {
        BaseResponse<Object> response = new BaseResponse<>();
        try {
            if (file.isEmpty()) {
                response.setResponseMsg("文件不能为空!");
                response.setResponseCode(400);
            }else {
                storageService.store(file);
                response.setResponseMsg("上传成功!"+file.getOriginalFilename());
                response.setResponseCode(200);
            }
        }catch (IOException e){
            response.setResponseMsg("上传失败! "+file.getOriginalFilename());
            response.setResponseCode(500);
        }
        return response;
    }

    @PostMapping("/delete/{filename}")
    @ResponseBody
    public BaseResponse handleFileDelete(@PathVariable String filename) {
        BaseResponse<Object> response = new BaseResponse<>();
        try {
            storageService.deleteFile(filename);
            response.setResponseMsg("删除成功!");
            response.setResponseCode(200);
        }catch (StorageFileNotFoundException e){
            response.setResponseMsg("文件不存在!");
            response.setResponseCode(404);
        }catch (IOException e){
            response.setResponseMsg("删除失败!");
            response.setResponseCode(500);
        }
        return response;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}