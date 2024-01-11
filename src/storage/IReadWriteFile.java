package storage;

import model.Employee;

import java.io.IOException;
import java.util.List;

public interface IReadWriteFile {
    List<Employee> readFile() throws IOException;
    void writeFile(List<Employee> list) throws IOException;
}
