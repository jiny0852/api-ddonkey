package com.javaex.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.JyStepDao;
import com.javaex.vo.RoomStepVo;

@Service
public class JyStepService {

    @Autowired
    private JyStepDao jyStepDao;
    

    @Autowired
    private S3Service s3Service; // S3 서비스 주입 - aws에 파일 저장을 위한

    @Value("${file.upload-dir}")  // application.properties 또는 application.yml에 설정된 파일 경로를 가져옴
    private String uploadDir;

    
    // 임시저장 체크
    public int checkRoom ( int userNum ) {
        return jyStepDao.checkRoom ( userNum );
    }
    
    // 임시저장 불러오기
    public RoomStepVo getRoomInfo ( int roomNum ) {
        return jyStepDao.getRoomInfo ( roomNum );
    }
    
    public int insertStep1 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep1(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep1(roomStepVo);
    }
    
    public int insertStep2 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep2(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep2(roomStepVo);
    }
    
    public int insertStep3 ( RoomStepVo roomStepVo, MultipartFile imageUrl ) throws IOException {

    	//System.out.println("service"+roomStepVo);
    	
        // 이미지와 음악 파일을 S3에 업로드
        String imageFileName = s3Service.uploadFile(imageUrl);

        // 이미지와 음악 파일 저장 로컬
//        String imageFileName = saveFile(imageUrl);

        // roomStepVo 객체에 파일 이름과 경로 설정
//        roomStepVo.setImageName(imageFileName);
//        roomStepVo.setImagePath(uploadDir + File.separator + imageFileName);
//        roomStepVo.setRoomThumbNail(uploadDir + File.separator + imageFileName);
        roomStepVo.setRoomThumbNail(imageFileName);
        
        // DB에 음원 정보 저장
    	int count = jyStepDao.insertStep3(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep3(roomStepVo);
    }
    
    public int insertStep4 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep4(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep4(roomStepVo);
    }
    
    public int insertStep44 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep44(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep44(roomStepVo);
    }
    
    public int insertStep5 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep5(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep5(roomStepVo);
    }
    
    public int insertStep7 ( RoomStepVo roomStepVo ) {
    	System.out.println("service"+roomStepVo);
    	int count = jyStepDao.insertStep7(roomStepVo);
    	return count;
    	
//        return jyStepDao.insertStep5(roomStepVo);
    }
    
    
    
    // 지역 목록 불러오기
    public List<RoomStepVo> getResionList (  ) {
        return jyStepDao.getResionList();
    }
    

     
    
    
    
    
    

}
