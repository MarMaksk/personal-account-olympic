package com.lk.backend.service;

import javax.transaction.Transactional;

public interface CRUD<D> {

    @Transactional
    D create(D dto) throws Exception;

    @Transactional
    D find(String findBy) throws Exception;

    @Transactional
    D update(D dto) throws Exception;

    @Transactional
    void delete(Long id) throws Exception;
}
