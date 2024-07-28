package Parsing;

public class jsonData {
    int id;
    String first_name;
    String last_name;
    String email;
    String gender;

    public jsonData() {
        id = 0;
        first_name = "";
        last_name = "";
        email = "";
        gender = "";
    }

    public jsonData(int id, String first_name, String last_name, String email, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String returnStr = "";

        returnStr = returnStr.concat("id: " + this.id);
        returnStr = returnStr.concat("\tfirst_name: " + this.first_name);
        returnStr = returnStr.concat("\tlast_name: " + this.last_name);
        returnStr = returnStr.concat("\temail: " + this.email);
        returnStr = returnStr.concat("\tgender: " + this.gender);

        return returnStr;
    }
}
