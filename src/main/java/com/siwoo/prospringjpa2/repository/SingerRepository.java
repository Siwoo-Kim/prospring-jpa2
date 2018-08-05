package com.siwoo.prospringjpa2.repository;

import com.siwoo.prospringjpa2.domain.Singer;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface SingerRepository {

    @Transactional(readOnly = true)
    List<Singer> findAll();
    @Transactional(readOnly = true)
    List<Singer> findAllFetched();
    @Transactional(readOnly = true)
    Singer findById(long id);

}
