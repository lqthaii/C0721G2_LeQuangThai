package com.codegym.service.Impl;

import com.codegym.repository.IDictionaryRepository;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository iDictionaryRepository;
    @Override
    public String getResearch(String eng) {
        return this.iDictionaryRepository.getResearch(eng);
    }
}
