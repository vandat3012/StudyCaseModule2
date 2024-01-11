package storage;

import model.Employee;

import java.io.IOException;
import java.util.List;

public class ReadWriteFileCsv implements IReadWriteFile{
    @Override
    public List<Employee> readFile() throws IOException {
        return null;
    }

    @Override
    public void writeFile(List<Employee> list) throws IOException {

    }
}
