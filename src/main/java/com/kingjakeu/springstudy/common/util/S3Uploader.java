package com.kingjakeu.springstudy.common.util;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
@Component
@NoArgsConstructor
public class S3Uploader {

    private final String bucketName = "kingjakeu";
    private final String bucketRegion = "ap-northeast-2";
    private final String accessKey = "(사용자 액세스 키 ID)"; //IAM 사용자의 액세스 키 ID
    private final String secretKey = "(비밀 엑세스 키 ID)"; //비밀 액세스 키

    /**
     * S3 Client 생성
     *
     * @return 버켓 지역과 인증 값이 할당 된 Amazon S3-Client
     */
    private AmazonS3 createS3Client(){
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey); // 인증키 값 지정
        return AmazonS3ClientBuilder.standard()
                .withRegion(this.bucketRegion) // 버켓 지역 지정
                .withCredentials(new AWSStaticCredentialsProvider(credentials)) // 인증 키 값 할당
                .build();
    }

    /**
     * S3 파일 업로드
     *
     * @param addBucketName 추가 버켓 이름(하위 폴더 디렉토리)
     * @param fileName 업로드 될 파일 이름
     * @param multipartFile 파일 데이터
     * @throws IOException
     */
    public void postFile(String addBucketName, String fileName, MultipartFile multipartFile) throws IOException {
        AmazonS3 s3Client = this.createS3Client();

        ObjectMetadata metadata = new ObjectMetadata(); // S3에 보낼 파일의 메타 데이터
        metadata.setContentType(multipartFile.getContentType()); // 파일 메타 데이터 - 컨탠츠 타입 지정

        // 버켓이름, S3에 저장될 파일 이름, 파일 데이터, 파일 메타 데이터를 Request에 담아 보낸다.
        PutObjectRequest request = new PutObjectRequest(this.bucketName + addBucketName, fileName, multipartFile.getInputStream(), metadata);
        s3Client.putObject(request); // S3 업로드 요청
    }
}