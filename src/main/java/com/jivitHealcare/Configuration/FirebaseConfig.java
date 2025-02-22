package com.jivitHealcare.Configuration;


// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.cloud.storage.Storage;
// import com.google.cloud.storage.StorageOptions;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;

// @Configuration
// public class FirebaseConfig {
//     private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);
//     @Bean
//     public Storage firebaseStorage() throws IOException {
//         InputStream serviceAccount = getClass().getClassLoader()
//                 .getResourceAsStream("jivithealthcare-802e2-firebase-adminsdk-pmpp2-2a3a806e0b.json");

//         if (serviceAccount == null) {
//             throw new IOException("Firebase service account key file not found in resources.");
//         }

//         return StorageOptions.newBuilder()
//                 .setCredentials(    GoogleCredentials.fromStream(serviceAccount))
//                 .build()
//                 .getService();
//     }

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);
    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("/firebase/jivithealthcare-802e2-firebase-adminsdk-pmpp2-daa27ebb3a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance();
        }
    }

    @Bean
    public Storage firebaseStorage() throws IOException {
        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build()
                .getService();
    }




}

