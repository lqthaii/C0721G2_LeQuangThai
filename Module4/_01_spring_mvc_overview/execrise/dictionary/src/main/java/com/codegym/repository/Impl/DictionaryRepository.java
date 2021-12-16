package com.codegym.repository.Impl;

import com.codegym.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private String []engs = {"dictionary","love","class","teacher","school"};
    private String []vies = {"từ điển","yêu thích","lớp","giáo viên","trường học"};
    @Override
    public String getResearch(String eng){
        for (int i=0;i<engs.length;i++) {
            if(engs[i].equals(eng)){
                return vies[i];
            }
        }
        return null;
    }
}
