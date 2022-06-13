package io;

import Models.NhanVien;


import java.io.*;
import java.util.ArrayList;


public class ReaderAndWriterNhanVien<E> {

    public void Write(ArrayList<E> list, String path) {
        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {

        }
    }

    public ArrayList<E> reader(String path) {
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<E>) objectInputStream.readObject();
        } catch (IOException |ClassNotFoundException e){

        }
        return new ArrayList<>();
    }


}
