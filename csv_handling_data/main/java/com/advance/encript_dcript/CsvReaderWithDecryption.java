package com.advance.encript_dcript;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderWithDecryption {

    // Reads a CSV file, decrypts sensitive data fields, and writes back the decrypted data
    public  void readAndDecryptCsv(String filePath) {
        List<String[]> decryptedRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            
            String[] header = reader.readNext();
            if (header != null) {
                decryptedRecords.add(header); // Add header as is
            }
            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length < 4) {
                    System.out.println("Invalid data format");
                    continue;
                }

                String employeeId = record[0];
                String name = record[1];
                String email = record[2];
                String salary = record[3];

                // Decrypt sensitive fields (if valid)
                String decryptedEmail = BasicEncryptionUtil.isValidEncryptedData(email) ? BasicEncryptionUtil.decrypt(email) : email;
                String decryptedSalary = BasicEncryptionUtil.isValidEncryptedData(salary) ? BasicEncryptionUtil.decrypt(salary) : salary;

                // Store the decrypted record
                decryptedRecords.add(new String[]{employeeId, name, decryptedEmail, decryptedSalary});

                // Display the decrypted data
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Name: " + name);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("----------------------------");
            }

            // Write the decrypted data back to the same file
            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
                writer.writeAll(decryptedRecords);
                System.out.println("Decrypted data has been written back to the file.");
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}