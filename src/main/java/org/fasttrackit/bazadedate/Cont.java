package org.fasttrackit.bazadedate;

/**
 * Created by Marius on 23-Mar-17.
 */
public class Cont {
    private String email;
    private String password;

    public Cont(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Cont{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}



