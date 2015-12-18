package com.fi.muni.carparkapp.service;

import com.fi.muni.carparkapp.dao.EmployeeDao;
import com.fi.muni.carparkapp.entity.Employee;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jan Hellar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeDao.findById(employeeId);
    }
    
    @Override
    public Employee findEmployeeByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    @Override
    public void addEmployee(Employee employee, String unencryptedPassword) {
        employee.setPasswordHash(new BCryptPasswordEncoder().encode(unencryptedPassword));
        employeeDao.create(employee);
    }
    
    @Override
    public void update(Employee employee, String unencryptedPassword) {
        employee.setPasswordHash(new BCryptPasswordEncoder().encode(unencryptedPassword));
        employeeDao.update(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public boolean authenticate(Employee employee, String password) {
        return validatePassword(password, employee.getPasswordHash());
    }

    @Override
    public boolean isAdmin(Employee employee) {
        return findEmployeeById(employee.getId()).isAdmin();
    }
    
    private static String createHash(String password) {
        final int SALT_SIZE = 24;
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);
        byte[] hash = pbkdf2(password.getBytes(), salt);
        return toHex(salt) + ":" + toHex(hash);
    }
    
    private static byte[] pbkdf2(byte[] password, byte[] salt) {
        PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());
        gen.init(password, salt, 4096);
        return ((KeyParameter) gen.generateDerivedParameters(256)).getKey();
    }
    
    private static String toHex(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }
    
    private static byte[] fromHex(String hex) {
        return DatatypeConverter.parseHexBinary(hex);
    }
    
    private static boolean validatePassword(String password, String correctHash) {
        String[] params = correctHash.split(":");
        byte[] salt = fromHex(params[0]);
        byte[] hash = fromHex(params[1]);
        byte[] testHash = pbkdf2(password.getBytes(), salt);
        return Arrays.equals(hash, testHash);
    }
    
}
