import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int id;
    private String name;
    private String email;
    private long mobile;
    private boolean isActive;
    private LocalDate birthDate;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, String email, long mobile, boolean isActive, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.isActive = isActive;
        this.setBirthDate(birthDate); // Apply validation
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate != null && birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future.");
        }
        this.birthDate = birthDate;
    }

    // toString with custom date formatting
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = (birthDate != null) ? birthDate.format(formatter) : "N/A";

        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", isActive=" + isActive +
                ", birthDate=" + formattedDate +
                '}';
    }
}
