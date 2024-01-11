package storage;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile{

    public List<Employee> readFile(){
        File file = new File("txt.txt");
        try {
            InputStream inputStream = new  FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            List<Employee> bookList = null;
            bookList = (List<Employee>) ois.readObject();
            return bookList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }

    }


    public void writeFile(List<Employee> bookList){
        File file = new File("txt.txt");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(bookList);
            objectOutputStream.close();
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private ReadWriteFile() {
    }
    private static ReadWriteFile instance;

    public static ReadWriteFile getInstance() {
        if (instance==null)
            synchronized (ReadWriteFile.class){
                if(instance==null)
                    instance=new ReadWriteFile();
            }
        return instance;
    }
}
