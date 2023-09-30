package com.app.repository.impl;

import com.app.repository.WriteAndRead;
import com.app.repository.WriterRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;

public class WriterRepositoryImpl implements WriterRepository {
    File filename = new File("./src/main/java/com/app/resource/writers.json");

    @Override
    public void writeEntityToFile(String data) {
        WriteAndRead.WriteToFile(data, filename);
    }

    @Override
    public ArrayList<String> readEntityFromFile() throws FileNotFoundException {
        return null;
    }

    @Override
    public void clearFile() throws FileNotFoundException {

    }

    @Override
    public Writer convertStringToEntity(String string) throws ParseException {
        return null;
    }

    @Override
    public String convertEntityToString(Writer writer) {
        return null;
    }

    @Override
    public void writeFullEntityToFile() throws FileNotFoundException {

    }

    @Override
    public void readFullEntityFromFile() throws FileNotFoundException {

    }
}
