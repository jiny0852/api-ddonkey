package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RoomStepVo;

@Repository
public class JyStepDao {

    @Autowired
    private SqlSession sqlSession;
    
    // 임시저장 체크
    public int checkRoom( int userNum ) {
        return sqlSession.selectOne("jyStep.checkRoom", userNum);
    }
    
    // 임시저장 불러오기
    public RoomStepVo getRoomInfo( int roomNum ) {
        return sqlSession.selectOne("jyStep.getRoomInfo", roomNum);
    }
    
    
    public int insertStep1 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.insert("jyStep.insertRoomInfo", roomStepVo);
    }
    public int insertStep2 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
    	
        return sqlSession.update("jyStep.updateStep2", roomStepVo);
    }
    public int insertStep3 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.update("jyStep.updateStep3", roomStepVo);
    }
    public int insertStep4 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.update("jyStep.updateStep4", roomStepVo);
    }
    public int insertStep44 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.update("jyStep.updateStep44", roomStepVo);
    }
    public int insertStep5 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.update("jyStep.updateStep5", roomStepVo);
    }
    public int insertStep7 ( RoomStepVo roomStepVo ) {
    	System.out.println("dao"+roomStepVo);
        return sqlSession.update("jyStep.updateStep7", roomStepVo);
    }


    
    // 지역 목록 불러오기
    public List<RoomStepVo> getResionList() {
        return sqlSession.selectList("jyStep.getResionList");
    }
    
    
    
}
