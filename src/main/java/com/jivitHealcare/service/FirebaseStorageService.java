package com.jivitHealcare.service;


import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    private final Storage storage;

    @Value("${firebase.storage.bucket}")
    private String bucketName;

    public FirebaseStorageService(Storage storage) {
        this.storage = storage;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        String downloadToken = UUID.randomUUID().toString();

        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .setMetadata(Map.of("firebaseStorageDownloadTokens", downloadToken))
                .build();

        storage.create(blobInfo, file.getBytes());

        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media&token=%s",
                bucketName, URLEncoder.encode(fileName, StandardCharsets.UTF_8), downloadToken);
    }
}

