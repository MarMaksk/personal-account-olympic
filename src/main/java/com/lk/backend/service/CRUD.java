package com.lk.backend.service;

import javax.transaction.Transactional;

public interface CRUD<D> {

    @Transactional
    void create(D dto) throws Exception;

    @Transactional
    D find(String findBy) throws Exception;

    @Transactional
    D update(D dto) throws Exception;

    @Transactional
    void delete(Long id) throws Exception;
}
