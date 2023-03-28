package utils;

public class UserData {
    String firstName, lastName, email, gender, phone, day, month, year, subjects, hobbies, picture, address, state, city;

    public UserData thisFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserData thisLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserData thisEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData thisGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserData thisPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserData thisDay(String day) {
        this.day = day;
        return this;
    }

    public UserData thisMonth(String month) {
        this.month = month;
        return this;
    }

    public UserData thisYear(String year) {
        this.year = year;
        return this;
    }

    public UserData thisSubjects(String subjects) {
        this.subjects = subjects;
        return this;
    }

    public UserData thisHobbies(String hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public UserData thisPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public UserData thisAddress(String address) {
        this.address = address;
        return this;
    }

    public UserData thisState(String state) {
        this.state = state;
        return this;
    }

    public UserData thisCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}