public class Employee {
    private int id;
    private String name;
    private String email;
    private long mobile;
    private boolean isActive;
    private LocalDate birthDate;

    public Employee() {
    }

    public Employee(int id, String name, String email, long mobile, boolean isActive, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.isActive = isActive;
        this.birthDate = birthDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return this.mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        int var10000 = this.id;
        return "Employee{id=" + var10000 + ", name='" + this.name + "', email='" + this.email + "', mobile=" + this.mobile + ", isActive=" + this.isActive + ", birthDate=" + String.valueOf(this.birthDate) + "}";
    }
}
