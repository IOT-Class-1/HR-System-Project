package com.example.HR.model;

//Bu benim model sınıfım
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Bu anotasyon, bu sınıfın bir veritabanı tablosuna karşılık geldiğini belirtir.
public class Employee {

    @Id // Bu anotasyon, 'id' alanının birincil anahtar olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bu, 'id' alanının otomatik olarak artırılacağını belirtir.
    private Long Id; // Çalışanın benzersiz kimliği

    private String firstName; // Çalışanın adı

    private String lastName; // Çalışanın soyadı

    private String jobTitle; // Çalışanın pozisyonu

    private String iban; // Çalışana ait iban no

    //Getter ve Setter metotları
    //Getter, özel alanların değerini okumak için kullanılır.
    //Setter, özel alanların değerini ayarlamak için kullanılır.


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
