//package com.jivitHealcare.Configuration;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.S3Configuration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.URI;
//
//@Configuration
//public class AmazonS3Config {
//
//
//    @Bean
//    public Storage firebaseStorage() throws IOException {
//
//        FileInputStream serviceAccount = new FileInputStream("src/main/resources/jivithealthcare-802e2-firebase-adminsdk-pmpp2-2a3a806e0b.json");
//        return StorageOptions.newBuilder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build()
//                .getService();
//    }
//
////    @Bean
////    public S3Client s3Client() {
////        return S3Client.builder()
////                .region(Region.US_EAST_1) // This is required but will be ignored by the custom endpoint
////                .endpointOverride(URI.create("https://timtims.blr1.digitaloceanspaces.com"))
////                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
////                        "DO00NX7NNTGE8JE34BXK",
////                        "ZYOX2vb6ZZ3sNxRsaImt+xhjMa6afdu0lqroPLWVShw")))
////                .serviceConfiguration(S3Configuration.builder().pathStyleAccessEnabled(true).build())
////                .build();
////    }
//}
