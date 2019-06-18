package com.gg.www.articleWeb.controller.back.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/articleWeb/base/articleWeb")
public class upload {
    @RequestMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object article(HttpServletRequest request, MultipartFile file) throws IOException {
        String url = request.getScheme() + "://" + request.getLocalAddr() + ":" + request.getServerPort() + request.getContextPath() + "/" + "upload/";
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath() + "/src/main/resources/static/upload";
        } catch (IOException e) {
            e.printStackTrace();
        }
        String image = this.uploadImage(file, courseFile);
        Map<String, Object> map = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "测试");
//        data.put("src", "http://192.168.2.112:8100/crm/upload/c1a53938c1d44beeae3e3fb9e3811d24.png");
        data.put("src", url + image);
        map.put("data", data);

        return map;
    }

    public String uploadImage(MultipartFile file, String path) {
        String name = file.getOriginalFilename();
        String hash = this.getUUIDFileName(name);
        File tempFile = new File(path, hash);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        try {
            tempFile.createNewFile();
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile.getName();
    }

    public String getUUIDFileName(String fileName) {
        int idx = fileName.lastIndexOf(".");
        String extention = fileName.substring(idx);
        String uuidFileName = UUID.randomUUID().toString().replace("-", "") + extention;
        return uuidFileName;
    }
}
