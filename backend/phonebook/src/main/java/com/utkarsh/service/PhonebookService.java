package com.utkarsh.service;

import com.utkarsh.model.Phonebook;

import java.util.List;

public interface PhonebookService {

    List<Phonebook> getAll();

    Phonebook getRecordById(String id);

    Phonebook addRecord(Phonebook record);

    Phonebook updateRecordById(Phonebook record, String id);

    Boolean deleteRecordById(String id);

}
