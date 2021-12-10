package model;

//Số điện thoại.
//- Nhóm của danh bạ.
//- Họ tên.
//- Giới tính.
//- Địa chỉ
//- Ngày sinh.
//- Email
public class Contact {
    private String phoneNum;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birth;
    private String email;


    public Contact() {
    }

    public Contact(String phoneNum,String group, String name, String gender, String address, String birth, String email) {
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birth = birth;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return phoneNum  + ","  +
                 name + ","   +
                 gender + ","   +
                address + ","   +
                birth + ","   +
                  email + ","+
                group
                ;
    }
}
