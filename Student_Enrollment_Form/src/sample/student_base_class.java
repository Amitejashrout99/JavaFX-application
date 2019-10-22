package sample;

public class student_base_class
{
    public String first_name;
    public String last_name;
    public String father_name;
    public String mother_name;
    public String gender;
    public String dob;
    public String address;
    public String info;

    public student_base_class(String first_name, String last_name, String father_name, String mother_name, String gender, String dob, String address, String info) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.info = info;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return info;
    }
}
