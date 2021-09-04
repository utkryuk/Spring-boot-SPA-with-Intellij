package com.utkarsh.service.impl;

import com.utkarsh.model.Phonebook;
import com.utkarsh.repository.PhonebookRepository;
import com.utkarsh.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements PhonebookService {

    @Autowired
    private PhonebookRepository repository;


    @Override
    public List<Phonebook> getAll() {
        return repository.findAll();
    }

    @Override
    public Phonebook getRecordById(String id) {
        Optional<Phonebook> record = repository.findById(id);
        return record.orElse(null);
    }

    @Override
    public Phonebook addRecord(Phonebook record) {
        return repository.save(record);
    }

    @Override
    public Phonebook updateRecordById(Phonebook record, String id) {
        Optional<Phonebook> ifRecordPresent = repository.findById(id);
        if(ifRecordPresent.isPresent()) {
            record.setId(id);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public Boolean deleteRecordById(String id) {
        Optional<Phonebook> ifRecordPresent = repository.findById(id);
        if (ifRecordPresent.isPresent()) {
            repository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
