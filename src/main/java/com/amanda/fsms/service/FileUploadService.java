package com.amanda.fsms.service;

import com.amanda.fsms.data.UploadRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jingji
 * @Date: 2023/4/18 19:37
 */
public interface FileUploadService {
    String handleFileUpload(MultipartFile file, UploadRequest uploadRequest);
}
