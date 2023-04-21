package com.amanda.fsms.service.impl;

import com.amanda.fsms.data.UploadRequest;
import com.amanda.fsms.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jingji
 * @Date: 2023/4/18 19:38
 */

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String handleFileUpload(final MultipartFile file, final UploadRequest uploadRequest) {
        try {
            // 获取上传文件的文件名
            String fileName = file.getOriginalFilename();

            // 构建文件存储路径
            String filePath = generateFileName(uploadRequest) + "/" + fileName;

            // 保存文件到磁盘
            saveFile(filePath);

            // 返回上传成功的消息
            return "File uploaded successfully";
        } catch (IOException e) {
            // 处理文件上传异常
            return "Error uploading file";
        }
    }

    private void saveFile(String filePath) throws IOException {
        // Create the directory if it doesn't exist
        File dir = new File("/opt/images");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Write the file content to the specified file path
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.close();
    }

    private String generateFileName (UploadRequest uploadRequest){
        String name =
                String.valueOf(uploadRequest.getAuditId())+"/"+String.valueOf(uploadRequest.getCP())+"/"+String.valueOf(uploadRequest.getNO());
        return name;
    }
}
